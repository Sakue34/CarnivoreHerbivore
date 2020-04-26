package pl.edu.pwr.carnivoreherbivore;

abstract class Animal extends Entity {
    private float speed;
    private float energy;
    private float stamina;

    Animal(float x, float y) {
        super(x, y);
    }

}
