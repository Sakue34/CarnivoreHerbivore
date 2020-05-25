package pl.edu.pwr.carnivoreherbivore;

public class SimulationCreator {
    public Simulation Create(SimulationParameters simulationParameters) {
        Map map = new Map();
        return new Simulation(simulationParameters, map);
    }
}
