package pl.edu.pwr.carnivoreherbivore.pawn;

import pl.edu.pwr.carnivoreherbivore.utility.Vector2d;

public abstract class Pawn {
    protected float energy;
    protected int radius;
    protected Vector2d velocity;

    protected String colourString;

    protected float wanderUpdateTimer = 0.0F;
    protected float wanderUpdateTimeMax = 0.0F;

    protected boolean toBeDestroyed = false;

    public void setToBeDestroyed() {
        toBeDestroyed = true;
    }

    public boolean isToBeDestroyed() {
        return toBeDestroyed;
    }

    public int getRadius() {
        return radius;
    }

    public void setVelocity(Vector2d velocity) {
        this.velocity = velocity;
    }

    public Vector2d getVelocity() {
        return velocity;
    }

    public void addEnergy(float energy) { }

    public void consumeEnergy(float elapsedTime) { }

    public float getEnergy() {
        return energy;
    }

    public boolean isOutOfEnergy() {
        return false;
    }

    public String getColourString() {
        return colourString;
    }

    public void wander(float elapsedTime) { }
}
