package pl.edu.pwr.carnivoreherbivore;

import pl.edu.pwr.Vector2d;

public class Carnivore extends Animal {

    public static final float rangeOfVision = 50.0F;

    public Carnivore(float x, float y) {
        super(x, y);
        speed = 65 + (float) Math.random() * 10;
        energy = 75 + (float) Math.random() * 50;
        velocity = new Vector2d(Vector2d.getCartesian(speed, (float)Math.random() * 2 * (float)(Math.PI) - ((float)Math.PI)));
    }

    @Override
    public void collideWithEntity(Entity entity) {
        if(entity instanceof Herbivore) {
            energy = energy + (((Herbivore)entity).getEnergy() * 0.5F) + 20;
            entity.setToBeDestroyed(true);
        }
    }

    @Override
    public void updateAI(Entity nearestInterestingEntity, float elapsedTime) {
        super.updateAI(nearestInterestingEntity, elapsedTime);

        if(nearestInterestingEntity != null) {
            Vector2d vector2d = new Vector2d(nearestInterestingEntity.newX - newX , nearestInterestingEntity.newY - newY);
            float angle = vector2d.getAngle();
            velocity.rotateTo(angle);
        }
        else {
            wander(elapsedTime);
        }
    }

    @Override
    public String toString() {
        return "Carnivore [" + x + " , " + y + "], Energy: " + energy;
    }
}