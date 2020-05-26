package pl.edu.pwr.carnivoreherbivore;

public final class SimulationCreator {
    public Simulation create(SimulationParameters simulationParameters) {
        MapCreator mapCreator = new MapCreator();
        SimulationMap simulationMap = mapCreator.create(simulationParameters);

        //Temporal output progress logger
        return new Simulation(simulationParameters, simulationMap, new TerminalProgressLogger(simulationParameters));
    }
}