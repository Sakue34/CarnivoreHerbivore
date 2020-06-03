package pl.edu.pwr.carnivoreherbivore.utility;

/**
 * Klasa przechowująca pozycję pionków i generująca nową, losową pozycję.
 */
public class Position {
    public float x;
    public float y;

    public Position(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public static Position getRandomPosition(float maxX, float maxY) {
        float x = (float)Math.random() * maxX;
        float y = (float)Math.random() * maxY;
        return new Position(x, y);
    }

    public static float getDistanceBetween(Position first, Position second) {
        float distanceX = first.x - second.x;
        float distanceY = first.y - second.y;
        return (float) Math.sqrt(distanceX * distanceX + distanceY * distanceY);
    }

    @Override
    public String toString() {
        return "Position : (" + x + ", " + y + ")";
    }
}
