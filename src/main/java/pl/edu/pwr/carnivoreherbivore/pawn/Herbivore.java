package pl.edu.pwr.carnivoreherbivore.pawn;

import pl.edu.pwr.carnivoreherbivore.utility.Vector2d;
import pl.edu.pwr.carnivoreherbivore.simulation.SimulationParameters;

/**
 * Klasa reprezentująca roślinożercę.
 */
public final class Herbivore extends Animal {
    public Herbivore(SimulationParameters simulationParameters) {
        energy = simulationParameters.herbivoreStartingEnergy;
        radius = simulationParameters.herbivoreRadius;
        velocity = Vector2d.getRandomVector2dWithGivenLength(simulationParameters.herbivoreSpeed);
        energyConsumptionPerSecond = simulationParameters.herbivoreEnergyConsumptionPerSecond;
        wanderUpdateTimer = simulationParameters.timeToSetNewRandomHerbivoreWanderDirection;
        wanderUpdateTimeMax = wanderUpdateTimer;

        colourString = simulationParameters.colourStringOfHerbivore;
    }

    @Override
    public String toString() {
        return "[Herbivore] Energy: " + energy;
    }
}