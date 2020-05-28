package pl.edu.pwr.carnivoreherbivore.pawn;

import pl.edu.pwr.carnivoreherbivore.utility.Vector2d;

/**
 * Klasa abstrakcyjna unifikująca "zwierzęta", czyli pionki które się poruszają.
 */
public abstract class Animal extends Pawn {
    protected float energyConsumptionPerSecond;

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
    public void wander(float elapsedTime) {
        wanderUpdateTimer -= elapsedTime;
        if (wanderUpdateTimer < 0.0F) {
            velocity = Vector2d.getRandomVector2dWithGivenLength(velocity.getLength());
            wanderUpdateTimer = wanderUpdateTimeMax;
        }
    }
}