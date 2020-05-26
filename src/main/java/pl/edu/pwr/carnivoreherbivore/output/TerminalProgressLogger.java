package pl.edu.pwr.carnivoreherbivore.output;

import pl.edu.pwr.carnivoreherbivore.utility.Position;
import pl.edu.pwr.carnivoreherbivore.map.SimulationMap;
import pl.edu.pwr.carnivoreherbivore.simulation.SimulationParameters;
import pl.edu.pwr.carnivoreherbivore.pawn.Pawn;

import java.util.List;
import java.util.Map;

public final class TerminalProgressLogger implements ProgressOutput {
    private final SimulationMap simulationMap;
    private final float timeBetweenOutput;
    private float timeSinceSimulationStarted = 0.0F;
    private float timeToNextOutput = 0.0F;

    private boolean isItTimeToOutput(float elapsedTime) {
        timeToNextOutput -= elapsedTime;
        return timeToNextOutput < 0.0F;
    }

    private void properOutput(SimulationMap simulationMap, float elapsedTime) {
        System.out.println();
        System.out.println("Last main loop iteration execution time: " + elapsedTime + " second(s)");
        System.out.println("Time since simulation started: " + timeSinceSimulationStarted + " second(s)");

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
    public void outputSimulationProgress(float elapsedTime) {
        timeSinceSimulationStarted += elapsedTime;
        if (!isItTimeToOutput(elapsedTime))
            return;

        timeToNextOutput = timeBetweenOutput;
        properOutput(simulationMap, elapsedTime);
    }

    public TerminalProgressLogger(SimulationParameters simulationParameters, SimulationMap simulationMap) {
        timeBetweenOutput = simulationParameters.timeBetweenProgressOutputInTerminal;
        this.simulationMap = simulationMap;
        System.out.println("carnivore-herbivore - Progress output: terminal");
    }

}
