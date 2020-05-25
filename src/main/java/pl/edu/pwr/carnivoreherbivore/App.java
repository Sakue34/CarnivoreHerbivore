package pl.edu.pwr.carnivoreherbivore;

public class App {

    public static void main(String[] args) {
        ConfigProvider configProvider = new DefaultParametersProvider();
        SimulationParameters simulationParameters = configProvider.get();
        SimulationCreator simulationCreator = new SimulationCreator();
        Simulation simulation = simulationCreator.create(simulationParameters);
        simulation.startSimulation();
    }
}
