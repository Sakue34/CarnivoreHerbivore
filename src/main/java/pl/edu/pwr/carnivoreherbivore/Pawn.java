package pl.edu.pwr.carnivoreherbivore;

import java.awt.*;

public abstract class Pawn {
    protected float x;
    protected float y;

    protected Color color;
    int radius;

    public abstract void draw(Graphics g);

    Pawn(float x, float y) {
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

    public static float getDistanceBetweenNewXY(Pawn pawn, Pawn other) {
        float distanceX = pawn.newX - other.newX;
        float distanceY = pawn.newY - other.newY;
        return (float) Math.sqrt(distanceX * distanceX + distanceY * distanceY);
    }

    public static float getDistanceBetween(Pawn pawn, Pawn other) {
        float distanceX = pawn.x - other.x;
        float distanceY = pawn.y - other.y;
        return (float) Math.sqrt(distanceX * distanceX + distanceY * distanceY);
    }

    abstract public void updatePositionNewXY(float elapsedTime);

    abstract public void collideWithEntity(Pawn pawn);

    protected boolean toBeDestroyed = false;

    public boolean isToBeDestroyed() {
        return toBeDestroyed;
    }

    public void setToBeDestroyed(boolean toBeDestroyed) {
        this.toBeDestroyed = toBeDestroyed;
    }

    public void updateAI(Pawn nearestInterestingPawn, float elapsedTime) { }

    public void updateFinalPosition() { }

}
