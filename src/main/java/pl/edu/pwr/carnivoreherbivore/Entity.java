package pl.edu.pwr.carnivoreherbivore;

abstract class Entity {
    private float x;
    private float y;

    Entity(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }

    private float newX;
    private float newY;

    abstract public void updatePosition(float elapsedTime);
    abstract public void collideWithEntity(Entity entity);

    private boolean toBeDestroyed = false;

    abstract void updateAI();


}
