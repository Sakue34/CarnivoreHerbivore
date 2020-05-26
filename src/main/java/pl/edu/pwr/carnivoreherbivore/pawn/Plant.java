package pl.edu.pwr.carnivoreherbivore.pawn;

import pl.edu.pwr.carnivoreherbivore.utility.Vector2d;
import pl.edu.pwr.carnivoreherbivore.simulation.SimulationParameters;

public final class Plant extends Pawn {
    public Plant(SimulationParameters simulationParameters) {
        energy = simulationParameters.plantNutritionalValue;
        radius = simulationParameters.plantRadius;
        velocity = new Vector2d(0, 0);

        colourString = simulationParameters.colourStringOfPlant;
    }

    @Override
    public String toString() {
        return "[Plant] Nutrition: " + energy;
    }
}
