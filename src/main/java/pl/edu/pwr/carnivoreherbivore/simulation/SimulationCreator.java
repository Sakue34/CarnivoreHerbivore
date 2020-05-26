package pl.edu.pwr.carnivoreherbivore.simulation;

import pl.edu.pwr.carnivoreherbivore.map.MapCreator;
import pl.edu.pwr.carnivoreherbivore.map.SimulationMap;
import pl.edu.pwr.carnivoreherbivore.output.*;

public class SimulationCreator {
    public Simulation create(SimulationParameters simulationParameters) {
        MapCreator mapCreator = new MapCreator();
        SimulationMap simulationMap = mapCreator.create(simulationParameters);

        ProgressOutput progressOutput;
        if (simulationParameters.useGUI)
            progressOutput = new GUIProgressOutput(simulationParameters);
        else
            progressOutput = new TerminalProgressLogger(simulationParameters);

        return new Simulation(simulationParameters, simulationMap, progressOutput);
    }
}
