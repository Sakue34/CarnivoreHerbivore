package pl.edu.pwr.carnivoreherbivore;

public abstract class Entity {
    protected float x;
    protected float y;

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

    protected float newX;
    protected float newY;

    abstract public void updatePosition(float elapsedTime);

    abstract public void collideWithEntity(Entity entity);

    private boolean toBeDestroyed = false;

    public boolean isToBeDestroyed() {
        return toBeDestroyed;
    }

    public void setToBeDestroyed(boolean toBeDestroyed) {
        this.toBeDestroyed = toBeDestroyed;
    }

    abstract void updateAI();


}
