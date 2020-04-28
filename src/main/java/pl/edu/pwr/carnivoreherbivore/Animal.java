package pl.edu.pwr.carnivoreherbivore;

import pl.edu.pwr.Vector2d;

public abstract class Animal extends Entity {
    protected float speed;
    protected float energy;
    protected float stamina;
    protected Vector2d velocity;

    public float getEnergy() {
        return energy;
    }

    @Override
    public void updatePosition(float elapsedTime) {
        newX = x + (velocity.x * elapsedTime);
        newY = y + (velocity.y * elapsedTime);
    }

    public Animal(float x, float y) {
        super(x, y);
    }

}
