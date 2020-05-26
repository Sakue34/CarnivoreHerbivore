package pl.edu.pwr.carnivoreherbivore.utility;

import java.lang.Math;

public class Vector2d {
    public float x;
    public float y;

    public static final float FLOATING_POINT_ERROR_MARGIN = 1.0e-6F;

    public Vector2d(float x, float y) {
        this.x = x;
        this.y = y;
    }

    private void set(Vector2d v) {
        this.x = v.x;
        this.y = v.y;
    }

    public float getLength() {
        return (float) Math.sqrt(x*x + y*y);
    }

    public float getAngle() {
        return (float) Math.atan2(y, x);
    }

    public void rotateTo(float angle) {
        set(getCartesian(getLength(), angle));
    }

    @Override
    public String toString() {
        return "[" + x + " " + y + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj instanceof Vector2d) {
            Vector2d vec = (Vector2d) obj;
            return Math.abs(vec.x - x) <= FLOATING_POINT_ERROR_MARGIN
                    && Math.abs(vec.y - y) <= FLOATING_POINT_ERROR_MARGIN;
        }
        return false;
    }

    public static Vector2d getCartesian(float magnitude, float angle) {
        return new Vector2d((float)(magnitude * Math.cos(angle)), (float)(magnitude * Math.sin(angle)));
    }

    public static Vector2d getRandomVector2dWithGivenLength(float length) {
        Vector2d vector2d = new Vector2d(length, 0);

        float randomX = (float) Math.random() - 0.5F;
        float randomY = (float) Math.random() - 0.5F;
        Vector2d randomVector2d = new Vector2d(randomX, randomY);
        float angle = randomVector2d.getAngle();

        vector2d.rotateTo(angle);
        return vector2d;
    }

}
