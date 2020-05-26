package pl.edu.pwr.carnivoreherbivore.utility;

import org.junit.Test;
import pl.edu.pwr.carnivoreherbivore.utility.Vector2d;

import java.lang.Math;

import static org.junit.Assert.*;

public class Vector2dTest {

    @Test
    public void equalsShouldReturnTrue() {
        Vector2d vector2d = new Vector2d(Vector2d.FLOATING_POINT_ERROR_MARGIN, Vector2d.FLOATING_POINT_ERROR_MARGIN);
        System.out.println(vector2d.toString());
        assertEquals("Vectors should be equal within margin", new Vector2d(0,0), vector2d);
    }

    @Test
    public void shouldReturnCorrectAngles() {
        Vector2d vec = new Vector2d(0.86602540378F, 0.5F);
        float result = vec.getAngle();
        System.out.println(result);
        assertTrue("Should return pi/6 [rad]",
                Math.abs(result - 0.52359877559F) <= Vector2d.FLOATING_POINT_ERROR_MARGIN);

        vec = new Vector2d(0.5F, 0.86602540378F);
        result = vec.getAngle();
        System.out.println(result);
        assertTrue("Should return pi/3 [rad]",
                Math.abs(result - 1.0471975512F) <= Vector2d.FLOATING_POINT_ERROR_MARGIN);

        vec = new Vector2d(-0.70710678118F, -0.70710678118F);
        result = vec.getAngle();
        System.out.println(result);
        assertTrue("Should return -3pi/4 [rad]",
                Math.abs(result - -2.35619449019F) <= Vector2d.FLOATING_POINT_ERROR_MARGIN);
    }

    @Test
    public void shouldReturnCorrectLength() {
        Vector2d vec = new Vector2d(2,2);
        float result = vec.getLength();
        System.out.println(result);
        assertTrue("should return 2*sqrt(2) = 2.82842712475",
                Math.abs(result - 2.82842712475F) <= Vector2d.FLOATING_POINT_ERROR_MARGIN);
    }

    @Test
    public void shouldReturnRotatedVector() {
        Vector2d vec = new Vector2d(-1,-1);
        vec.rotateTo(0.0F);
        System.out.println(vec);
        assertEquals("Rotated vector should be [sqrt(2), 0]", new Vector2d((float) Math.sqrt(2), 0), vec);
    }

    @Test
    public void shouldReturnVectorInCartesian() {
        Vector2d vector2d = Vector2d.getCartesian(4, (float) Math.PI);
        System.out.println(vector2d);
        assertEquals("Vector in cartesian should be [-4, 0]", new Vector2d(-4, 0), vector2d);
    }
}