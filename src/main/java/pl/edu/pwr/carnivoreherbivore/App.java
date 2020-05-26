package pl.edu.pwr.carnivoreherbivore;

import pl.edu.pwr.carnivoreherbivore.config.*;
import pl.edu.pwr.carnivoreherbivore.simulation.Simulation;
import pl.edu.pwr.carnivoreherbivore.simulation.SimulationCreator;
import pl.edu.pwr.carnivoreherbivore.simulation.SimulationParameters;

public final class App {
    public static void main(String[] args) {
        ConfigProvider configProvider = new DefaultParametersProvider();
        SimulationParameters simulationParameters = configProvider.get();
        SimulationCreator simulationCreator = new SimulationCreator();
        Simulation simulation = simulationCreator.create(simulationParameters);
        simulation.startSimulation();
    }
}
