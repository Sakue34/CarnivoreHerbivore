package pl.edu.pwr.carnivoreherbivore;

import pl.edu.pwr.Vector2d;

public class Herbivore extends Animal {
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