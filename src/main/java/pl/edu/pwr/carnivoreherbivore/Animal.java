package pl.edu.pwr.carnivoreherbivore;

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
}