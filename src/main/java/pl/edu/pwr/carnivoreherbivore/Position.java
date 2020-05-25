package pl.edu.pwr.carnivoreherbivore;

public class Position {
    public float x;
    public float y;

    public Position(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Position() {
        x = 0;
        y = 0;
    }

    public static Position getRandomPosition(float maxX, float maxY) {
        float x = (float)Math.random() * maxX;
        float y = (float)Math.random() * maxY;
        return new Position(x, y);
    }
}