package pl.edu.pwr;

import java.lang.Math;

public class Vector2d {
    float x;
    float y;

    public static final float FLOATING_POINT_ERROR_MARGIN = 1.0e-6F;

    Vector2d() { }

    Vector2d(float x, float y) {
        this.x = x;
        this.y = y;
    }

    float getLength() {
        return (float) Math.sqrt(x*x + y*y);
    }

    Vector2d getNormalised() {
        float magnitude = getLength();
        return new Vector2d(x / magnitude, y / magnitude);
    }

    float getAngle() {
        return (float) Math.atan2(y, x);
    }

    void set(Vector2d v) {
        this.x = v.x;
        this.y = v.y;
    }

    static Vector2d getCartesian(float magnitude, float angle) {
        return new Vector2d((float)(magnitude * Math.cos(angle)), (float)(magnitude * Math.sin(angle)));
    }

    void rotateTo(float angle) {
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
}
