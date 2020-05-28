package pl.edu.pwr.carnivoreherbivore.output;

import pl.edu.pwr.carnivoreherbivore.map.SimulationMap;
import pl.edu.pwr.carnivoreherbivore.pawn.Pawn;
import pl.edu.pwr.carnivoreherbivore.simulation.SimulationParameters;
import pl.edu.pwr.carnivoreherbivore.utility.Position;

import java.util.List;
import java.util.Map;

/**
 * Jedna z klas reprezentujących wyjście programu.
 * Wyświetla ona przebieg symulacji w konsoli.
 */
public final class TerminalProgressLogger extends SimpleProgressOutput {
    private void properTerminalOutput(SimulationMap simulationMap, float elapsedTime) {
        System.out.println("Last main loop iteration execution time: " + elapsedTime  + "in-simulation second(s)");

        List<Pawn> pawns = simulationMap.getPawns();
        Map<Pawn, Position> pawnsPositions = simulationMap.getPawnsPositions();
        for (int i = 0; i < pawns.size(); i++) {
            Pawn pawn = pawns.get(i);
            String nameAndEnergyString = pawn.toString();
            String positionString = pawnsPositions.get(pawn).toString();
            String finalOutputString = (i+1) + ". " + nameAndEnergyString + ", " + positionString;
            System.out.println(finalOutputString);
        }
    }

    @Override
    public boolean outputSimulationProgress(float elapsedTime) {
        boolean isItTimeToOutput = super.outputSimulationProgress(elapsedTime);
        if (isItTimeToOutput)
            properTerminalOutput(simulationMap, elapsedTime);
        return false;
    }

    public TerminalProgressLogger(SimulationParameters simulationParameters, SimulationMap simulationMap) {
        super(simulationParameters, simulationMap);
        System.out.println("carnivore-herbivore - Progress output: terminal");
    }
}
