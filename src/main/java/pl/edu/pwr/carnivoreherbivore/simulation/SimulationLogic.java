package pl.edu.pwr.carnivoreherbivore.simulation;

import pl.edu.pwr.carnivoreherbivore.map.SimulationMap;
import pl.edu.pwr.carnivoreherbivore.pawn.*;
import pl.edu.pwr.carnivoreherbivore.utility.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static pl.edu.pwr.carnivoreherbivore.utility.Position.getDistanceBetween;

/**
 * Klasa obsługująca całą logikę symulacji.
 * Tworzona przy każdej iteracji pętli głównej przez główną klasę symulacji.
 * @see Simulation
 */
public final class SimulationLogic {
    private final SimulationParameters simulationParameters;
    private final SimulationMap simulationMap;
    private final List<Pawn> pawns;
    private final Map<Pawn, Position> pawnsPositions;

    public SimulationLogic(SimulationParameters simulationParameters, SimulationMap simulationMap) {
        this.simulationParameters = simulationParameters;
        this.simulationMap = simulationMap;
        this.pawns = simulationMap.getPawns();
        this.pawnsPositions = simulationMap.getPawnsPositions();
    }

    private void setPawnVelocityToApproachPosition(Pawn pawn, Position pawnPosition, Position destination) {
        float randomVelocityX = destination.x - pawnPosition.x;
        float randomVelocityY = destination.y - pawnPosition.y;
        Vector2d randomVelocity = new Vector2d(randomVelocityX, randomVelocityY);
        float angle = randomVelocity.getAngle();

        Vector2d pawnVelocity = pawn.getVelocity();
        pawnVelocity.rotateTo(angle);

        pawn.setVelocity(pawnVelocity);
    }

    public void updatePawnsWanderTimer(float elapsedTime) {
        for (Pawn pawn : pawns) {
            pawn.wander(elapsedTime);
        }
    }

    private boolean isWithinSightRange(Pawn firstPawn, Pawn secondPawn, float sightRange) {
        Position firstPosition = pawnsPositions.get(firstPawn);
        Position secondPosition = pawnsPositions.get(secondPawn);
        return getDistanceBetween(firstPosition, secondPosition) <= sightRange;
    }

    private void updateHerbivoreVelocity(Pawn herbivore) {
        Position herbivorePosition = pawnsPositions.get(herbivore);
        float herbivoreSightRange = simulationParameters.herbivoreSightRange;

        NearestPawnFinder nearestPawnFinder = new NearestPawnFinder(pawns, pawnsPositions);
        Pawn closestCarnivore = nearestPawnFinder.getNearestCarnivore(herbivore);
        if (closestCarnivore != null) {
            boolean doesHerbivoreSeeClosestCarnivore = isWithinSightRange(herbivore, closestCarnivore, herbivoreSightRange);
            if (doesHerbivoreSeeClosestCarnivore) {
                Position closestCarnivorePosition = pawnsPositions.get(closestCarnivore);
                setPawnVelocityToApproachPosition(herbivore, herbivorePosition, closestCarnivorePosition);
                herbivore.flipVelocity();
                return;
            }
        }

        Pawn closestPlant = nearestPawnFinder.getNearestPlant(herbivore);
        if (closestPlant != null) {
            boolean doesHerbivoreSeeClosestPlant = isWithinSightRange(herbivore, closestPlant, herbivoreSightRange);
            if (doesHerbivoreSeeClosestPlant) {
                Position closestPlantPosition = pawnsPositions.get(closestPlant);
                setPawnVelocityToApproachPosition(herbivore, herbivorePosition, closestPlantPosition);
            }
        }
    }

    private void updateCarnivoreVelocity(Pawn carnivore) {
        Position carnivorePosition = pawnsPositions.get(carnivore);
        float carnivoreSightRange = simulationParameters.carnivoreSightRange;

        NearestPawnFinder nearestPawnFinder = new NearestPawnFinder(pawns, pawnsPositions);
        Pawn closestHerbivore = nearestPawnFinder.getNearestHerbivore(carnivore);
        if (closestHerbivore != null) {
            boolean doesCarnivoreSeeClosestHerbivore = isWithinSightRange(carnivore, closestHerbivore, carnivoreSightRange);
            if (doesCarnivoreSeeClosestHerbivore) {
                Position closestHerbivorePosition = pawnsPositions.get(closestHerbivore);
                setPawnVelocityToApproachPosition(carnivore, carnivorePosition, closestHerbivorePosition);
            }
        }
    }

    public void updatePawnsVelocity() {
        for (Pawn firstPawn : pawns) {
            if (firstPawn instanceof Herbivore) {
                updateHerbivoreVelocity(firstPawn);
            }
            else if (firstPawn instanceof Carnivore) {
                updateCarnivoreVelocity(firstPawn);
            }
        }
    }

    public void movePawns(float elapsedTime) {
        for (Pawn pawn : pawns) {
            Position pawnPosition = pawnsPositions.get(pawn);
            float movementX = pawn.getVelocity().x * elapsedTime;
            float movementY = pawn.getVelocity().y * elapsedTime;
            pawnPosition.x += movementX;
            pawnPosition.y += movementY;
        }
    }

    public void makePawnsConsumeEnergy(float elapsedTime) {
        for (Pawn pawn : pawns) {
            pawn.consumeEnergy(elapsedTime);
        }
    }

    public void checkPawnsForStarvation() {
        ArrayList<Pawn> pawnsToBeDeleted = new ArrayList<>();
        for (Pawn pawn : pawns) {
            if (pawn.isOutOfEnergy()) {
                pawn.setToBeDestroyed();
            }
        }
    }

    public void boundPawnsWithinMap() {
        for (Pawn pawn : pawns) {
            Position pawnPosition = pawnsPositions.get(pawn);
            if (pawnPosition.x < 0)
                pawnPosition.x = 0;
            else if (pawnPosition.x > simulationParameters.mapWidth)
                pawnPosition.x = simulationParameters.mapWidth;
            if (pawnPosition.y < 0)
                pawnPosition.y = 0;
            else if (pawnPosition.y > simulationParameters.mapHeight)
                pawnPosition.y = simulationParameters.mapHeight;
        }
    }

    private void collide(Pawn first, Pawn second) {
        if (first instanceof Herbivore) {
            if (second instanceof Plant) {
                first.addEnergy(second.getEnergy());
                second.setToBeDestroyed();
            }
        }
        else if (first instanceof Carnivore) {
            if (second instanceof Herbivore) {
                first.addEnergy(second.getEnergy() + simulationParameters.baseHerbivoreNutritionalValue);
                second.setToBeDestroyed();
            }
        }
    }

    public void checkPawnsForCollision() {
        for (Pawn firstPawn : pawns) {
            for (Pawn secondPawn : pawns) {
                if (firstPawn == secondPawn)
                    continue;
                Position firstPosition = pawnsPositions.get(firstPawn);
                Position secondPosition = pawnsPositions.get(secondPawn);
                float collisionRangeMultiplier = simulationParameters.collisionRangeMultiplierOfSumOfRadii;
                float maxCollisionDistance = (firstPawn.getRadius() + secondPawn.getRadius()) * collisionRangeMultiplier;
                boolean collisionHappened = getDistanceBetween(firstPosition, secondPosition) <= maxCollisionDistance;
                if (collisionHappened)
                    collide(firstPawn, secondPawn);
            }
        }
    }

    public void destroyEatenOrStarvedPawns() {
        for (int i = 0; i < simulationMap.getPawns().size(); i++) {
            Pawn pawn = simulationMap.getPawns().get(i);
            if (pawn.isToBeDestroyed()) {
                simulationMap.removePawn(pawn);
            }
        }
    }

    public boolean shouldSimulationEnd() {
        int herbivoresLeft = 0;
        int carnivoresLeft = 0;
        for (Pawn pawn : pawns) {
            if (pawn instanceof Herbivore)
                herbivoresLeft++;
            else if (pawn instanceof Carnivore)
                carnivoresLeft++;
        }

        if (simulationParameters.endSimulationWhenNoHerbivoresLeft) {
            if (herbivoresLeft == 0)
                return true;
        }

        if (simulationParameters.endSimulationWhenNoCarnivoresLeft) {
            if (carnivoresLeft == 0)
                return true;
        }

        int pawnsCount = simulationMap.getPawns().size();
        return pawnsCount <= simulationParameters.numberOfPawnsToEndSimulation;
    }
}