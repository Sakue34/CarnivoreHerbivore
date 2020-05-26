package pl.edu.pwr.carnivoreherbivore;

import pl.edu.pwr.Vector2d;

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

    /*@Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int)x - radius , (int)y - radius, radius * 2, radius * 2);
    }*/
}