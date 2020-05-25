package pl.edu.pwr.carnivoreherbivore;

import java.awt.*;

public class Plant extends Pawn {

    public Plant(float x, float y) {
        super(x, y);
        nutritionalValue = (float)(Math.random()) * 20 + 10;
        newX = x;
        newY = y;
        color = Color.decode("0x11EE22");
        radius = 4;
    }

    private float nutritionalValue;

    public float getNutritionalValue() {
        return nutritionalValue;
    }

    @Override
    public void updatePositionNewXY(float elapsedTime) { }

    @Override
    public void collideWithEntity(Pawn pawn) { }

    @Override
    public String toString() {
        return "[Plant] Nutrition: " + nutritionalValue;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int)x - radius , (int)y - radius, radius * 2, radius * 2);
    }

}
