package pl.edu.pwr.carnivoreherbivore.map;

import pl.edu.pwr.carnivoreherbivore.utility.Position;
import pl.edu.pwr.carnivoreherbivore.pawn.Pawn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class SimulationMap {
    private final List<Pawn> pawns;
    public List<Pawn> getPawns() {
        return pawns;
    }

    private final Map<Pawn, Position> pawnsPosition;
    public Map<Pawn, Position> getPawnsPositions() {
        return pawnsPosition;
    }

    public SimulationMap() {
        pawns = new ArrayList<>();
        pawnsPosition = new HashMap<>();
    }

    public void addPawn(Pawn pawn, Position position) {
        pawns.add(pawn);
        pawnsPosition.put(pawn, position);
    }

    public void removePawn(Pawn pawn) {
        pawnsPosition.remove(pawn);
        pawns.remove(pawn);
    }
}