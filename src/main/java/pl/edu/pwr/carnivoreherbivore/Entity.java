package pl.edu.pwr.carnivoreherbivore;

abstract class Entity {
    private float x;
    private float y;

    private float newX;
    private float newY;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    abstract public void Update(float elapsedTime);

    Entity(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
