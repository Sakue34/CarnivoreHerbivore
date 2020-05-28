package pl.edu.pwr.carnivoreherbivore.config;

import pl.edu.pwr.carnivoreherbivore.simulation.SimulationParameters;

/**
 * Interfejs unifikujący klasy dostarczające parametry symulacji.
 */
public interface ConfigProvider {
    SimulationParameters get();
}
