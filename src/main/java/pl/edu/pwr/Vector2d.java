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

}
