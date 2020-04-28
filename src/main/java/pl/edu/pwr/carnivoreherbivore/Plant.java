package pl.edu.pwr.carnivoreherbivore;

public class Plant extends Entity {

    public Plant(float x, float y) {
        super(x, y);
        nutritionalValue = (float)(Math.random()) * 20 + 20;
    }

    private float nutritionalValue;

    public float getNutritionalValue() {
        return nutritionalValue;
    }

    @Override
    public void updatePositionNewXY(float elapsedTime) { }

    @Override
    public void collideWithEntity(Entity entity) { }

    @Override
    public String toString() {
        return "Plant [" + x + " , " + y + "], Nutrition: " + nutritionalValue;
    }

}
