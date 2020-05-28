package pl.edu.pwr.carnivoreherbivore.output;

import pl.edu.pwr.carnivoreherbivore.map.SimulationMap;
import pl.edu.pwr.carnivoreherbivore.simulation.SimulationParameters;

/**
 * Klasa bazowa dla pozostałych metod wyświetlania przebiegu symulacji.
 * Pozwala spełnić zasadę DRY, gdyż zajmuję się ona wyświetlaniem najbardziej podstawowych
 * informacji o postępie symulacji, używanych zarówno przez GUI jak i wyjście przez terminal.
 */
public class SimpleProgressOutput implements ProgressOutput {
    protected final SimulationMap simulationMap;
    protected final float timeBetweenOutput;
    protected float timeSinceSimulationStarted = 0.0F;
    protected float timeToNextOutput = 0.0F;

    private boolean isItTimeToOutput(float elapsedTime) {
        timeToNextOutput -= elapsedTime;
        return timeToNextOutput < 0.0F;
    }

    public SimpleProgressOutput(SimulationParameters simulationParameters, SimulationMap simulationMap) {
        timeBetweenOutput = simulationParameters.timeBetweenProgressOutputInTerminal;
        this.simulationMap = simulationMap;
    }

    @Override
    public boolean outputSimulationProgress(float elapsedTime) {
        timeSinceSimulationStarted += elapsedTime;
        if (!isItTimeToOutput(elapsedTime))
            return false;
        timeToNextOutput = timeBetweenOutput;

        System.out.println();
        System.out.println("Time since simulation started: " + timeSinceSimulationStarted + " in-simulation second(s)");
        return true;
    }

    @Override
    public void outputSimulationEnd() {
        SimulationResults simulationResults = new SimulationResults(simulationMap);
        System.out.println();
        System.out.println("Simulation ended due to one of the specified conditions");
        System.out.println("Number of Plants left: " + simulationResults.getNumberOfPlantsLeft());
        System.out.println("Number of Herbivores left: " + simulationResults.getNumberOfHerbivoresLeft());
        System.out.println("Number of Carnivores left: " + simulationResults.getNumberOfCarnivoresLeft());
        System.out.println("Total number of pawns left: " + simulationResults.getNumberOfPawnsLeft());
    }
}
