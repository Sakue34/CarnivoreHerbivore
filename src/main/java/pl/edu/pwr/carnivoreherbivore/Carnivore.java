package pl.edu.pwr.carnivoreherbivore;

public class Carnivore extends Animal {

    private static final float rangeOfVision = 10.0F;

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
    public void updateAI() {

    }
}