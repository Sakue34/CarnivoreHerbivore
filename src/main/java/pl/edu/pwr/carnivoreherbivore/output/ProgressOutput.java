package pl.edu.pwr.carnivoreherbivore.output;

/**
 * Intersejs unifikujący klasy wyświetlające przebieg symulacji.
 */
public interface ProgressOutput {
    boolean outputSimulationProgress(float elapsedTime);
    void outputSimulationEnd();
}
