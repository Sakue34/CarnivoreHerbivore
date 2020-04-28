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

    public static float getDistanceBetweenNewXY(Entity entity, Entity other) {
        float distanceX = entity.newX - other.newX;
        float distanceY = entity.newY - other.newY;
        return (float) Math.sqrt(distanceX * distanceX + distanceY * distanceY);
    }

    public static float getDistanceBetween(Entity entity, Entity other) {
        float distanceX = entity.x - other.x;
        float distanceY = entity.y - other.y;
        return (float) Math.sqrt(distanceX * distanceX + distanceY * distanceY);
    }

    abstract public void updatePositionNewXY(float elapsedTime);

    abstract public void collideWithEntity(Entity entity);

    protected boolean toBeDestroyed = false;

    public boolean isToBeDestroyed() {
        return toBeDestroyed;
    }

    public void setToBeDestroyed(boolean toBeDestroyed) {
        this.toBeDestroyed = toBeDestroyed;
    }

    public void updateAI(Entity nearestInterestingEntity, float elapsedTime) { }

    public void updateFinalPosition() { }

}
