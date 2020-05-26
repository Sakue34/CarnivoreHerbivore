package pl.edu.pwr.carnivoreherbivore.output;

import pl.edu.pwr.carnivoreherbivore.utility.Position;
import pl.edu.pwr.carnivoreherbivore.map.SimulationMap;
import pl.edu.pwr.carnivoreherbivore.simulation.SimulationParameters;
import pl.edu.pwr.carnivoreherbivore.pawn.Pawn;

import java.util.List;
import java.util.Map;

public final class TerminalProgressLogger implements ProgressOutput {
    private final float timeBetweenOutput;
    private float timeSinceSimulationStarted = 0.0F;
    private float timeToNextOutput = 0.0F;

    boolean isItTimeToOutput(float elapsedTime) {
        timeToNextOutput -= elapsedTime;
        return timeToNextOutput < 0.0F;
    }

    @Override
    public void outputSimulationProgress(SimulationMap simulationMap, float elapsedTime) {
        if (!isItTimeToOutput(elapsedTime))
            return;

        timeToNextOutput = timeBetweenOutput;

        timeSinceSimulationStarted += elapsedTime;
        System.out.println("");
        System.out.println("Elapsed time: " + elapsedTime + " second(s)");
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

    public TerminalProgressLogger(SimulationParameters simulationParameters) {
        timeBetweenOutput = simulationParameters.timeBetweenProgressOutputInTerminal;
        System.out.println("carnivore-herbivore - Progress output: terminal");
    }

}
