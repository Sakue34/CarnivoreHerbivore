package pl.edu.pwr.carnivoreherbivore.pawn;

import pl.edu.pwr.carnivoreherbivore.utility.Vector2d;
import pl.edu.pwr.carnivoreherbivore.SimulationParameters;

public final class Herbivore extends Animal {
    public Herbivore(SimulationParameters simulationParameters) {
        energy = simulationParameters.herbivoreStartingEnergy;
        radius = simulationParameters.herbivoreRadius;
        velocity = Vector2d.getRandomVector2dWithGivenLength(simulationParameters.herbivoreSpeed);
        energyConsumptionPerSecond = simulationParameters.herbivoreEnergyConsumptionPerSecond;

        colourString = simulationParameters.colourStringOfHerbivore;
    }

    @Override
    public String toString() {
        return "[Herbivore] Energy: " + energy;
    }

    /*@Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int)x - radius , (int)y - radius, radius * 2, radius * 2);
    }*/
}