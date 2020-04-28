package pl.edu.pwr.carnivoreherbivore;

import pl.edu.pwr.Vector2d;

public abstract class Animal extends Entity {
    protected float speed;
    protected float energy;
    protected float stamina;
    protected Vector2d velocity;
    protected float timeToNextWanderingTargetUpdate = 5.0F;

    public float getEnergy() {
        return energy;
    }

    @Override
    public void updatePositionNewXY(float elapsedTime) {
        newX = x + (velocity.x * elapsedTime);
        newY = y + (velocity.y * elapsedTime);
    }

    public Animal(float x, float y) {
        super(x, y);
    }

    protected void wander(float elapsedTime) {
        if (timeToNextWanderingTargetUpdate <= 0.0F) {
            timeToNextWanderingTargetUpdate = 5.0F; //Magic value to be changed into a constant
            velocity.rotateTo(((float)Math.random()) * 2 * (float)(Math.PI) - ((float)Math.PI));
        } else {
            timeToNextWanderingTargetUpdate -= elapsedTime;
        }
    }

    @Override
    public void updateFinalPosition() {
        x = newX;
        y = newY;
    }

    @Override
    public void updateAI(Entity nearestInterestingEntity, float elapsedTime) {
        energy -= elapsedTime;
        if(energy <= 0.0F) {
            toBeDestroyed = true;
        }
    }


}
