package pl.edu.pwr.carnivoreherbivore.simulation;

import pl.edu.pwr.carnivoreherbivore.SimulationParameters;

public interface SimulationCreator {
    Simulation create(SimulationParameters simulationParameters);
}
