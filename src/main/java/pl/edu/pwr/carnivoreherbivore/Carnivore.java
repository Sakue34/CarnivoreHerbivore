package pl.edu.pwr.carnivoreherbivore;

import pl.edu.pwr.Vector2d;

import java.util.Vector;

public class Carnivore extends Animal {

    public static final float rangeOfVision = 10.0F;

    public Carnivore(float x, float y) {
        super(x, y);
        speed = 45 + (float) Math.random()*10;
        energy = 75 + (float) Math.random()*50;
    }

    @Override
    public void collideWithEntity(Entity entity) {
        if(entity instanceof Herbivore) {
            energy = energy + (((Herbivore)entity).getEnergy() * 0.5F) + 20;
            entity.setToBeDestroyed(true);
        }
    }

    @Override
    public void updateAI(Entity nearestInterestingEntity) {
        if(nearestInterestingEntity != null) {
            Vector2d vector2d = new Vector2d(nearestInterestingEntity.newX - newX , nearestInterestingEntity.newY - newY);
            float angle = vector2d.getAngle();
            velocity.rotateTo(angle);
        }


    }
}