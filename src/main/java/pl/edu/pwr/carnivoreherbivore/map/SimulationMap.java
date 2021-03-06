package pl.edu.pwr.carnivoreherbivore.map;

import pl.edu.pwr.carnivoreherbivore.utility.Position;
import pl.edu.pwr.carnivoreherbivore.pawn.Pawn;

import java.util.*;

/**
 * Klasa reprezentująca mapę na której odbywa sie symulacja.
 * Przechowuje ona pionki i ich pozycje.
 */
public final class SimulationMap {
    private final List<Pawn> pawns;
    public List<Pawn> getPawns() {
        return pawns;
    }

    private final Map<Pawn, Position> pawnsPosition;
    public Map<Pawn, Position> getPawnsPositions() {
        return pawnsPosition;
    }

    public SimulationMap(List<Pawn> pawns, Map<Pawn, Position> pawnsPosition) {
        this.pawns = pawns;
        this.pawnsPosition = pawnsPosition;
    }

    public void removePawn(Pawn pawn) {
        pawnsPosition.remove(pawn);
        pawns.remove(pawn);
    }
}