package pl.edu.pwr.carnivoreherbivore;

public class SimulationCreatorGUI implements SimulationCreator {
    @Override
    public Simulation create(SimulationParameters simulationParameters) {
        MapCreator mapCreator = new MapCreator();
        SimulationMap simulationMap = mapCreator.create(simulationParameters);
        return new Simulation(simulationParameters, simulationMap, new GUIProgressOutput(simulationParameters));
    }
}
