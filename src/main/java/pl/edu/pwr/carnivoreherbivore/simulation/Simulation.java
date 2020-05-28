package pl.edu.pwr.carnivoreherbivore.simulation;

import pl.edu.pwr.carnivoreherbivore.map.SimulationMap;
import pl.edu.pwr.carnivoreherbivore.output.ProgressOutput;

/**
 * Główna klasa symulacji. Zawiera pętlę główną.
 * Klasa łączy ze sobą wszystkie komponenty programu.
 */
public final class Simulation {
    private final SimulationParameters simulationParameters;
    private final SimulationMap simulationMap;
    private final ProgressOutput progressOutput;

    public Simulation(SimulationParameters simulationParameters, SimulationMap simulationMap, ProgressOutput progressOutput) {
        this.simulationParameters = simulationParameters;
        this.simulationMap = simulationMap;
        this.progressOutput = progressOutput;
    }

    public void startSimulation()  {
        long time1 = System.nanoTime();
        long time2;

        boolean shouldSimulationRun = true;
        while (shouldSimulationRun) {
            time2 = System.nanoTime();
            long elapsedNanoSeconds = time2 - time1;
            time1 = time2;
            float elapsedTime = (float)elapsedNanoSeconds / 1.0e9F;
            elapsedTime *= simulationParameters.speedOfSimulationMultiplier;
            boolean simulationShouldEnd = updateSimulationLogic(elapsedTime);
            outputSimulationProgress(elapsedTime);
            if (simulationShouldEnd) {
                shouldSimulationRun = false;
                progressOutput.outputSimulationEnd();
            }
        }
    }

    private boolean updateSimulationLogic(float elapsedTime) {
        SimulationLogic simulationLogic = new SimulationLogic(simulationParameters, simulationMap);

        simulationLogic.updatePawnsWanderTimer(elapsedTime);
        simulationLogic.updatePawnsVelocity();
        simulationLogic.movePawns(elapsedTime);
        simulationLogic.makePawnsConsumeEnergy(elapsedTime);
        simulationLogic.checkPawnsForStarvation();
        simulationLogic.boundPawnsWithinMap();
        simulationLogic.checkPawnsForCollision();
        simulationLogic.destroyEatenOrStarvedPawns();

        return simulationLogic.shouldSimulationEnd();
    }

    private void outputSimulationProgress(float elapsedTime) {
        progressOutput.outputSimulationProgress(elapsedTime);
    }
}
