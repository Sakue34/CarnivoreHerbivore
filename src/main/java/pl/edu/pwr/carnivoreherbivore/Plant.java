package pl.edu.pwr.carnivoreherbivore;

public class Plant extends Entity {

    public Plant(float x, float y) {
        super(x, y);
    }

    private float nutritionalValue;

    public float getNutritionalValue() {
        return nutritionalValue;
    }

    @Override
    public void updatePosition(float elapsedTime) { }

    @Override
    public void collideWithEntity(Entity entity) { }

}
