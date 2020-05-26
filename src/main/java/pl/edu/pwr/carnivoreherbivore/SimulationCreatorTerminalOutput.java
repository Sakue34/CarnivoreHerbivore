package pl.edu.pwr.carnivoreherbivore;

public final class SimulationCreatorTerminalOutput implements SimulationCreator {
    @Override
    public Simulation create(SimulationParameters simulationParameters) {
        MapCreator mapCreator = new MapCreator();
        SimulationMap simulationMap = mapCreator.create(simulationParameters);
        return new Simulation(simulationParameters, simulationMap, new TerminalProgressLogger(simulationParameters));
    }
}