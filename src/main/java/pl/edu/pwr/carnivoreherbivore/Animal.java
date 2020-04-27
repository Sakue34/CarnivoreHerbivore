package pl.edu.pwr.carnivoreherbivore;

public abstract class Animal extends Entity {
    private float speed;
    private float energy;
    private float stamina;

    public Animal(float x, float y) {
        super(x, y);
    }

}
