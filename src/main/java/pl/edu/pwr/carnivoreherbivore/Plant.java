package pl.edu.pwr.carnivoreherbivore;

import pl.edu.pwr.Vector2d;

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

    /*@Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int)x - radius , (int)y - radius, radius * 2, radius * 2);
    }*/

}
