package pl.edu.pwr.carnivoreherbivore.simulation;

import pl.edu.pwr.carnivoreherbivore.pawn.Carnivore;
import pl.edu.pwr.carnivoreherbivore.pawn.Herbivore;
import pl.edu.pwr.carnivoreherbivore.pawn.Pawn;
import pl.edu.pwr.carnivoreherbivore.pawn.Plant;
import pl.edu.pwr.carnivoreherbivore.utility.Position;

import java.util.List;
import java.util.Map;

import static pl.edu.pwr.carnivoreherbivore.utility.Position.getDistanceBetween;

/**
 * Klasa pomocniczna do wyznaczania najbliższego pionka danego typu.
 * Używana przez SimulationLogic.
 */
public final class NearestPawnFinder {
    private final List<Pawn> pawns;
    private final Map<Pawn, Position> pawnsPositions;

    public NearestPawnFinder(List<Pawn> pawns, Map<Pawn, Position> pawnsPositions){
        this.pawns = pawns;
        this.pawnsPositions = pawnsPositions;
    }

    public Pawn getNearestCarnivore(Pawn pawn) {
        Position pawnPosition = pawnsPositions.get(pawn);
        Pawn closestCarnivore = null;
        float closestCarnivoreDistance = Integer.MAX_VALUE;
        for (Pawn secondPawn : pawns) {
            if (!(secondPawn instanceof Carnivore))
                continue;
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

    public Pawn getNearestHerbivore(Pawn pawn) {
        Position pawnPosition = pawnsPositions.get(pawn);
        Pawn closestHerbivore = null;
        float closestHerbivoreDistance = Integer.MAX_VALUE;
        for (Pawn secondPawn : pawns) {
            if (!(secondPawn instanceof Herbivore))
                continue;
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

    public Pawn getNearestPlant(Pawn pawn) {
        Position pawnPosition = pawnsPositions.get(pawn);
        Pawn closestPlant = null;
        float closestPlantDistance = Integer.MAX_VALUE;
        for (Pawn secondPawn : pawns) {
            if (!(secondPawn instanceof Plant))
                continue;
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
}
