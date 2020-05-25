package pl.edu.pwr.carnivoreherbivore;

public final class Simulation {
    private SimulationParameters simulationParameters;
    private SimulationMap simulationMap;
    private boolean shouldSimulationRun = true;

    public Simulation(SimulationParameters simulationParameters, SimulationMap simulationMap) {
        this.simulationParameters = simulationParameters;
        this.simulationMap = simulationMap;
    }

    public void startSimulation() {
        //main loop

        long time1 = System.nanoTime();
        long time2;

        while (shouldSimulationRun) {
            time2 = System.nanoTime();
            long elapsedNanoSeconds = time2 - time1;
            time1 = time2;
            float elapsedTime = (float)elapsedNanoSeconds / 1.0e9F;
            elapsedTime *= simulationParameters.speedOfSimulationMultiplier;
            //UpdateSimulationLogic();
            //DisplaySimulationProgress();
        }


    }
}
