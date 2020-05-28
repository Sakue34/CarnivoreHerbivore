package pl.edu.pwr.carnivoreherbivore.simulation;

import pl.edu.pwr.carnivoreherbivore.map.MapCreator;
import pl.edu.pwr.carnivoreherbivore.map.SimulationMap;
import pl.edu.pwr.carnivoreherbivore.output.*;

/**
 * Klasa tworząca obiekt symulacji.
 * Tworzy ona również mapę w której przechowywane są wszystkie pionki, wykorzystując do tego
 * klasę MapCreator.
 * @see MapCreator
 */
public class SimulationCreator {
    public Simulation create(SimulationParameters simulationParameters) {
        MapCreator mapCreator = new MapCreator();
        SimulationMap simulationMap = mapCreator.create(simulationParameters);

        ProgressOutput progressOutput;
        if (simulationParameters.useGUI)
            progressOutput = new GUIProgressOutput(simulationParameters, simulationMap);
        else
            progressOutput = new TerminalProgressLogger(simulationParameters, simulationMap);

        return new Simulation(simulationParameters, simulationMap, progressOutput);
    }
}
