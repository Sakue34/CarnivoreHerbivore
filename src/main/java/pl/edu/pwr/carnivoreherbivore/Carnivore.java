package pl.edu.pwr.carnivoreherbivore;

import pl.edu.pwr.Vector2d;

import java.awt.*;

public class Carnivore extends Animal {

    public static final float rangeOfVision = 50.0F;

    public Carnivore(float x, float y) {
        super(x, y);
        speed = 65 + (float) Math.random() * 10;
        energy = 75 + (float) Math.random() * 50;
        velocity = new Vector2d(Vector2d.getCartesian(speed, (float)Math.random() * 2 * (float)(Math.PI) - ((float)Math.PI)));
        color = Color.decode("0xFF1133");
        radius = 8;
    }

    @Override
    public void collideWithEntity(Pawn pawn) {
        if(pawn instanceof Herbivore) {
            energy = energy + (((Herbivore) pawn).getEnergy() * 0.5F) + 20;
            pawn.setToBeDestroyed(true);
        }
    }

    @Override
    public void updateAI(Pawn nearestInterestingPawn, float elapsedTime) {
        super.updateAI(nearestInterestingPawn, elapsedTime);

        if(nearestInterestingPawn != null) {
            Vector2d vector2d = new Vector2d(nearestInterestingPawn.newX - newX , nearestInterestingPawn.newY - newY);
            float angle = vector2d.getAngle();
            velocity.rotateTo(angle);
        }
        else {
            wander(elapsedTime);
        }
    }

    @Override
    public String toString() {
        return "[Carnivore] Energy: " + energy;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int)x - radius , (int)y - radius, radius * 2, radius * 2);
    }
}