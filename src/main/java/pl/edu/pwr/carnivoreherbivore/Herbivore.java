package pl.edu.pwr.carnivoreherbivore;

import pl.edu.pwr.Vector2d;

import java.lang.Math;

public class Herbivore extends Animal {

    public static final float rangeOfVision = 10.0F;

    public Herbivore(float x, float y) {
        super(x, y);
        speed = 45 + (float) Math.random() * 10;
        energy = 75 + (float) Math.random() * 50;
        velocity = new Vector2d(Vector2d.getCartesian(speed, (float)Math.random() * 2 * (float)(Math.PI) - ((float)Math.PI)));
    }

    @Override
    public void collideWithEntity(Entity entity) {
        if (entity instanceof Plant) {
            energy = energy + ((Plant) entity).getNutritionalValue();
            entity.setToBeDestroyed(true);
        }

    }

    @Override
    public void updateAI(Entity nearestInterestingEntity, float elapsedTime) {
        if (nearestInterestingEntity instanceof Plant) {
            Vector2d vector2d = new Vector2d(nearestInterestingEntity.newX - newX, nearestInterestingEntity.newY - newY);
            float angle = vector2d.getAngle();
            velocity.rotateTo(angle);
        }
        else if(nearestInterestingEntity instanceof Carnivore) {
            Vector2d vector2d = new Vector2d(-(nearestInterestingEntity.newX - newX), -(nearestInterestingEntity.newY - newY));
            float angle = vector2d.getAngle();
            velocity.rotateTo(angle);
        }
        else {
            wander(elapsedTime);
        }

    }
}