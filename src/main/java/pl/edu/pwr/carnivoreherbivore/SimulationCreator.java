package pl.edu.pwr.carnivoreherbivore;

public class SimulationCreator {
    public Simulation Create(SimulationParameters simulationParameters) {
        MapCreator mapCreator = new MapCreator();
        SimulationMap simulationMap = mapCreator.Create(simulationParameters);
        return new Simulation(simulationParameters, simulationMap);
    }
}
