package pl.edu.pwr.carnivoreherbivore;

import pl.edu.pwr.carnivoreherbivore.config.ConfigProvider;
import pl.edu.pwr.carnivoreherbivore.config.DefaultParametersProvider;

public final class App {

    public static void main(String[] args) {
        ConfigProvider configProvider = new DefaultParametersProvider();
        SimulationParameters simulationParameters = configProvider.get();
        SimulationCreator simulationCreator = new SimulationCreatorTerminalOutput();
        //SimulationCreator simulationCreator = new SimulationCreatorGUI();
        Simulation simulation = simulationCreator.create(simulationParameters);
        simulation.startSimulation();
    }
}
