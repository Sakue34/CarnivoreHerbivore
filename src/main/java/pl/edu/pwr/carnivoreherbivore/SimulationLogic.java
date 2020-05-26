package pl.edu.pwr.carnivoreherbivore;

import pl.edu.pwr.carnivoreherbivore.map.SimulationMap;
import pl.edu.pwr.carnivoreherbivore.pawn.Carnivore;
import pl.edu.pwr.carnivoreherbivore.pawn.Herbivore;
import pl.edu.pwr.carnivoreherbivore.pawn.Pawn;
import pl.edu.pwr.carnivoreherbivore.pawn.Plant;
import pl.edu.pwr.carnivoreherbivore.utility.Position;
import pl.edu.pwr.carnivoreherbivore.utility.Vector2d;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    private float getDistanceBetween(Position first, Position second) {
        float distanceX = first.x - second.x;
        float distanceY = first.y - second.y;
        return (float) Math.sqrt(distanceX * distanceX + distanceY * distanceY);
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

    private Pawn getNearestCarnivore(Pawn pawn) {
        Position pawnPosition = pawnsPositions.get(pawn);
        Pawn closestCarnivore = null;
        float closestCarnivoreDistance = Integer.MAX_VALUE;
        for (Pawn secondPawn : pawns) {
            if (!(secondPawn instanceof Carnivore))
                break;
            Position secondPawnPosition = pawnsPositions.get(secondPawn);
            float newDistance = getDistanceBetween(pawnPosition, secondPawnPosition);
            boolean isCloserThanCurrentClosest = newDistance < closestCarnivoreDistance;
            if (isCloserThanCurrentClosest) {
                closestCarnivore = secondPawn;
                closestCarnivoreDistance = newDistance;
            }
        }
        return closestCarnivore;
    }

    private Pawn getNearestHerbivore(Pawn pawn) {
        Position pawnPosition = pawnsPositions.get(pawn);
        Pawn closestHerbivore = null;
        float closestHerbivoreDistance = Integer.MAX_VALUE;
        for (Pawn secondPawn : pawns) {
            if (!(secondPawn instanceof Herbivore))
                break;
            Position secondPawnPosition = pawnsPositions.get(secondPawn);
            float newDistance = getDistanceBetween(pawnPosition, secondPawnPosition);
            boolean isCloserThanCurrentClosest = newDistance < closestHerbivoreDistance;
            if (isCloserThanCurrentClosest) {
                closestHerbivore = secondPawn;
                closestHerbivoreDistance = newDistance;
            }
        }
        return closestHerbivore;
    }

    private Pawn getNearestPlant(Pawn pawn) {
        Position pawnPosition = pawnsPositions.get(pawn);
        Pawn closestPlant = null;
        float closestPlantDistance = Integer.MAX_VALUE;
        for (Pawn secondPawn : pawns) {
            if (!(secondPawn instanceof Plant))
                break;
            Position secondPawnPosition = pawnsPositions.get(secondPawn);
            float newDistance = getDistanceBetween(pawnPosition, secondPawnPosition);
            boolean isCloserThanCurrentClosest = newDistance < closestPlantDistance;
            if (isCloserThanCurrentClosest) {
                closestPlant = secondPawn;
                closestPlantDistance = newDistance;
            }
        }
        return closestPlant;
    }

    private boolean isWithinSightRange(Pawn firstPawn, Pawn secondPawn, float sightRange) {
        Position firstPosition = pawnsPositions.get(firstPawn);
        Position secondPosition = pawnsPositions.get(secondPawn);
        return getDistanceBetween(firstPosition, secondPosition) <= sightRange;
    }

    private void setRandomlyNewRandomWanderDirection(Pawn pawn) {
        float random = (float)Math.random();
        boolean shouldChangeDirection = random <= simulationParameters.chanceToSetNewRandomCarnivoreWanderDirection;
        if (shouldChangeDirection) {
            Position randomPosition = Position.getRandomPosition(simulationParameters.mapWidth, simulationParameters.mapHeight);
            setPawnVelocityToApproachPosition(pawn, pawnsPositions.get(pawn), randomPosition);
        }
    }

    private void updateHerbivoreVelocity(Pawn herbivore) {
        Position herbivorePosition = pawnsPositions.get(herbivore);
        float herbivoreSightRange = simulationParameters.herbivoreSightRange;

        Pawn closestCarnivore = getNearestCarnivore(herbivore);
        if (closestCarnivore != null) {
            boolean doesHerbivoreSeeClosestCarnivore = isWithinSightRange(herbivore, closestCarnivore, herbivoreSightRange);
            if (doesHerbivoreSeeClosestCarnivore) {
                Position closestCarnivorePosition = pawnsPositions.get(closestCarnivore);

                //Arguments 2nd and 3rd inverted to make herbivore run away from threat
                setPawnVelocityToApproachPosition(herbivore, closestCarnivorePosition, herbivorePosition);
                return;
            }
        }

        Pawn closestPlant = getNearestPlant(herbivore);
        if (closestPlant != null) {
            boolean doesHerbivoreSeeClosestPlant = isWithinSightRange(herbivore, closestPlant, herbivoreSightRange);
            if (doesHerbivoreSeeClosestPlant) {
                Position closestPlantPosition = pawnsPositions.get(closestPlant);
                setPawnVelocityToApproachPosition(herbivore, herbivorePosition, closestPlantPosition);
            }
        }
        setRandomlyNewRandomWanderDirection(herbivore);
    }

    private void updateCarnivoreVelocity(Pawn carnivore) {
        Position carnivorePosition = pawnsPositions.get(carnivore);
        float carnivoreSightRange = simulationParameters.carnivoreSightRange;

        Pawn closestHerbivore = getNearestHerbivore(carnivore);
        if (closestHerbivore != null) {
            boolean doesCarnivoreSeeClosestHerbivore = isWithinSightRange(carnivore, closestHerbivore, carnivoreSightRange);
            if (doesCarnivoreSeeClosestHerbivore) {
                Position closestHerbivorePosition = pawnsPositions.get(closestHerbivore);

                setPawnVelocityToApproachPosition(carnivore, carnivorePosition, closestHerbivorePosition);
                return;
            }
        }
        setRandomlyNewRandomWanderDirection(carnivore);
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
                //simulationMap.removePawn(pawn);
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
                float maxCollisionDistance = firstPawn.getRadius() + secondPawn.getRadius();
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
        int pawnsCount = simulationMap.getPawns().size();
        return pawnsCount <= simulationParameters.numberOfPawnsToEndSimulation;
    }

}
