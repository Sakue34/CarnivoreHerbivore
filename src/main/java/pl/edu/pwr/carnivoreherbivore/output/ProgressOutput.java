package pl.edu.pwr.carnivoreherbivore.output;

import pl.edu.pwr.carnivoreherbivore.map.SimulationMap;

public interface ProgressOutput {
    void outputSimulationProgress(SimulationMap simulationMap, float elapsedTime);
}
