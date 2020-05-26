package pl.edu.pwr.carnivoreherbivore.output;

import pl.edu.pwr.carnivoreherbivore.map.SimulationMap;
import pl.edu.pwr.carnivoreherbivore.simulation.SimulationParameters;

public final class GUIProgressOutput implements ProgressOutput {
    @Override
    public void outputSimulationProgress(SimulationMap simulationMap, float elapsedTime) {
        //Display progress with GUI
    }

    public GUIProgressOutput(SimulationParameters simulationParameters) {
        System.out.println("carnivore-herbivore - Progress output: Swing GUI");
        //GUI Initialisation
    }

}
