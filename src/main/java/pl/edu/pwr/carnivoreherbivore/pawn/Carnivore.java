package pl.edu.pwr.carnivoreherbivore.pawn;

import pl.edu.pwr.carnivoreherbivore.utility.Vector2d;
import pl.edu.pwr.carnivoreherbivore.simulation.SimulationParameters;

public final class Carnivore extends Animal {
    public Carnivore(SimulationParameters simulationParameters) {
        energy = simulationParameters.carnivoreStartingEnergy;
        radius = simulationParameters.carnivoreRadius;
        velocity = Vector2d.getRandomVector2dWithGivenLength(simulationParameters.carnivoreSpeed);
        energyConsumptionPerSecond = simulationParameters.carnivoreEnergyConsumptionPerSecond;

        colourString = simulationParameters.colourStringOfCarnivore;
    }

    @Override
    public String toString() {
        return "[Carnivore] Energy: " + energy;
    }
}