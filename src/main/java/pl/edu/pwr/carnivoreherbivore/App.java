package pl.edu.pwr.carnivoreherbivore;

import pl.edu.pwr.carnivoreherbivore.config.*;
import pl.edu.pwr.carnivoreherbivore.simulation.Simulation;
import pl.edu.pwr.carnivoreherbivore.simulation.SimulationCreator;
import pl.edu.pwr.carnivoreherbivore.simulation.SimulationParameters;

public final class App {
    private static SimulationParameters getSimulationParameters() {
        ConfigProvider configProvider = new FileConfigProvider("simulation.properties");
        SimulationParameters simulationParameters = configProvider.get();
        if (simulationParameters == null) {
            configProvider = new DefaultParametersProvider();
            simulationParameters = configProvider.get();
        }
        return simulationParameters;
    }

    public static void main(String[] args) {
        SimulationParameters simulationParameters = getSimulationParameters();
        SimulationCreator simulationCreator = new SimulationCreator();
        Simulation simulation = simulationCreator.create(simulationParameters);
        simulation.startSimulation();
    }
}
