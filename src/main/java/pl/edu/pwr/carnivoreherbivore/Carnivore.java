package pl.edu.pwr.carnivoreherbivore;

public class Carnivore extends Animal {

    private static final float rangeOfVision = 10.0F;

    public Carnivore(float x, float y) {
        super(x, y);
    }



    @Override
    public void collideWithEntity(Entity entity) {

    }

    @Override
    public void updateAI() {

    }
}