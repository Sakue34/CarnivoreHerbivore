package pl.edu.pwr;

import org.junit.Test;
import java.lang.Math;

import static org.junit.Assert.*;

public class Vector2dTest {

    public static final float FLOATING_POINT_ERROR_MARGIN = 1.0e-6F;

    @Test
    public void shouldReturnCorrectAngles() {
        Vector2d vec = new Vector2d(0.86602540378F, 0.5F);
        float result = vec.getAngle();
        System.out.println(result);
        assertTrue("Should return pi/6 [rad]", Math.abs(result - 0.52359877559F) <= FLOATING_POINT_ERROR_MARGIN);

        vec = new Vector2d(0.5F, 0.86602540378F);
        result = vec.getAngle();
        System.out.println(result);
        assertTrue("Should return pi/3 [rad]", Math.abs(result - 1.0471975512F) <= FLOATING_POINT_ERROR_MARGIN);

        vec = new Vector2d(-0.70710678118F, -0.70710678118F);
        result = vec.getAngle();
        System.out.println(result);
        assertTrue("Should return -3pi/4 [rad]", Math.abs(result - -2.35619449019F) <= FLOATING_POINT_ERROR_MARGIN);
    }

}