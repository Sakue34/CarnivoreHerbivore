package pl.edu.pwr.carnivoreherbivore;

import pl.edu.pwr.Vector2d;

public abstract class Animal extends Entity {
    private float speed;
    private float energy;
    private float stamina;
    protected Vector2d velocity;

    @Override
    public void updatePosition(float elapsedTime) {
        newX = x + (velocity.x * elapsedTime);
        newY = y + (velocity.y * elapsedTime);
    }

    public Animal(float x, float y) {
        super(x, y);
    }

}
