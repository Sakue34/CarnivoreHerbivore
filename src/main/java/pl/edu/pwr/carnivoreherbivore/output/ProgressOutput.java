package pl.edu.pwr.carnivoreherbivore.output;

public interface ProgressOutput {
    boolean outputSimulationProgress(float elapsedTime);
    void outputSimulationEnd();
}
