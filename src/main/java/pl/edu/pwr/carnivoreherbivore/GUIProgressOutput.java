package pl.edu.pwr.carnivoreherbivore;

public final class GUIProgressOutput implements ProgressOutput {
    @Override
    public void outputSimulationProgress(SimulationMap simulationMap) {
        //Display progress with GUI
    }

    public GUIProgressOutput(SimulationParameters simulationParameters) {
        System.out.println("carnivore-herbivore - Progress output: Swing GUI");
        //GUI Initialisation
    }

}
