package pl.edu.pwr.carnivoreherbivore.output;

import pl.edu.pwr.carnivoreherbivore.utility.Position;
import pl.edu.pwr.carnivoreherbivore.map.SimulationMap;
import pl.edu.pwr.carnivoreherbivore.SimulationParameters;
import pl.edu.pwr.carnivoreherbivore.pawn.Pawn;

import java.util.List;
import java.util.Map;

public final class TerminalProgressLogger implements ProgressOutput {
    @Override
    public void outputSimulationProgress(SimulationMap simulationMap) {
        List<Pawn> pawns = simulationMap.getPawns();
        Map<Pawn, Position> pawnsPositions = simulationMap.getPawnsPositions();
        for (int i = 0; i < pawns.size(); i++) {
            String nameAndEnergyString = pawns.get(i).toString();
            String positionString = pawnsPositions.get(pawns.get(i)).toString();
            String finalOutputString = (i+1) + ". " + nameAndEnergyString + ", " + positionString;
            System.out.println(finalOutputString);
        }
    }

    public TerminalProgressLogger(SimulationParameters simulationParameters) {
        System.out.println("carnivore-herbivore - Progress output: terminal");
    }

}
