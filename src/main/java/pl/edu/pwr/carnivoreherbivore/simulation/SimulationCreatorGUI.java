package pl.edu.pwr.carnivoreherbivore.simulation;

import pl.edu.pwr.carnivoreherbivore.map.MapCreator;
import pl.edu.pwr.carnivoreherbivore.map.SimulationMap;
import pl.edu.pwr.carnivoreherbivore.SimulationParameters;
import pl.edu.pwr.carnivoreherbivore.output.GUIProgressOutput;

public class SimulationCreatorGUI implements SimulationCreator {
    @Override
    public Simulation create(SimulationParameters simulationParameters) {
        MapCreator mapCreator = new MapCreator();
        SimulationMap simulationMap = mapCreator.create(simulationParameters);
        return new Simulation(simulationParameters, simulationMap, new GUIProgressOutput(simulationParameters));
    }
}
