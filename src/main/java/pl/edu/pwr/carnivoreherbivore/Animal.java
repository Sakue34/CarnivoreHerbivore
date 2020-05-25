package pl.edu.pwr.carnivoreherbivore;

import pl.edu.pwr.Vector2d;

public abstract class Animal extends Pawn {
    protected float speed;
    protected float energyConsumptionPerSecond;
    protected float timeToNextWanderingTargetUpdate = 5.0F;

    public float getEnergy() {
        return energy;
    }

    @Override
    public void consumeEnergy(float elapsedTime) {
        energy -= energyConsumptionPerSecond * elapsedTime;
    }

    @Override
    public boolean isOutOfEnergy() {
        return energy < 0.0F;
    }

    @Override
    public final void addEnergy(float energy) {
        this.energy += energy;
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
            timeToNextWanderingTargetUpdate = 3.0F; //Magic value to be changed into a constant
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
    public void updateAI(Pawn nearestInterestingPawn, float elapsedTime) {
        energy -= elapsedTime;
        if(energy <= 0.0F) {
            toBeDestroyed = true;
        }

        if (newX < 0.0F) newX = 0.0F;
        if (newX > App.getMapWidth()) newX = App.getMapWidth();
        if (newY < 0.0F) newY = 0.0F;
        if (newY > App.getMapHeight()) newY = App.getMapHeight();
    }


}
