package pl.edu.pwr.carnivoreherbivore;

import java.lang.Math;

public class Herbivore extends Animal {

    private static final float rangeOfVision = 10.0F;

    public Herbivore(float x, float y) {
        super(x, y);
        speed = 45 + (float) Math.random()*10;
        energy = 75 + (float) Math.random()*50;

    }

    @Override
    public void collideWithEntity(Entity entity) {
        if(entity instanceof Plant) {
            energy = energy + ((Plant)entity).getNutritionalValue();
            entity.setToBeDestroyed(true);
        }

    }

    @Override
    public void updateAI() {

    }
}
