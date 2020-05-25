package pl.edu.pwr.carnivoreherbivore;

import java.util.List;
import java.util.Map;

public class TerminalProgressLogger implements ProgressOutput {
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

    TerminalProgressLogger(SimulationParameters simulationParameters) {
        System.out.println("carnivore herbivore - Progress output: terminal");
    }

}
