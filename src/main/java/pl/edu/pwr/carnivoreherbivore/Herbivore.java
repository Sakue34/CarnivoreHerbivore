package pl.edu.pwr.carnivoreherbivore;

import pl.edu.pwr.Vector2d;

import java.awt.*;
import java.lang.Math;

public class Herbivore extends Animal {

    public static final float rangeOfVision = 50.0F;

    public Herbivore(float x, float y) {
        super(x, y);
        speed = 45 + (float) Math.random() * 10;
        energy = 75 + (float) Math.random() * 50;
        velocity = new Vector2d(Vector2d.getCartesian(speed, (float)Math.random() * 2 * (float)(Math.PI) - ((float)Math.PI)));
        color = Color.decode("0x77BA66");
        radius = 8;
    }

    @Override
    public void collideWithEntity(Pawn pawn) {
        if (pawn instanceof Plant) {
            energy = energy + ((Plant) pawn).getNutritionalValue();
            pawn.setToBeDestroyed(true);
        }

    }

    @Override
    public void updateAI(Pawn nearestInterestingPawn, float elapsedTime) {
        super.updateAI(nearestInterestingPawn, elapsedTime);

        if (nearestInterestingPawn instanceof Plant) {
            Vector2d vector2d = new Vector2d(nearestInterestingPawn.newX - newX, nearestInterestingPawn.newY - newY);
            float angle = vector2d.getAngle();
            velocity.rotateTo(angle);
        }
        else if(nearestInterestingPawn instanceof Carnivore) {
            Vector2d vector2d = new Vector2d(-(nearestInterestingPawn.newX - newX), -(nearestInterestingPawn.newY - newY));
            float angle = vector2d.getAngle();
            velocity.rotateTo(angle);
        }
        else {
            wander(elapsedTime);
        }
    }

    @Override
    public String toString() {
        return "[Herbivore] Energy: " + energy;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int)x - radius , (int)y - radius, radius * 2, radius * 2);
    }
}