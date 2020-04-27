package pl.edu.pwr;

import java.lang.Math;

public class Vector2d {
    float x;
    float y;

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

    static Vector2d toCartesian(float magnitude, float angle) {
        return new Vector2d((float)(magnitude * Math.cos(angle)), (float)(magnitude * Math.sin(angle)));
    }

    void rotateTo(float angle) {
        set(toCartesian(getLength(), angle));
    }

}
