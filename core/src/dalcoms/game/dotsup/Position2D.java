package dalcoms.game.dotsup;

public class Position2D {
    private float x, y = 0;

    public Position2D() {
    }

    public Position2D(float x, float y) {
        setX(x);
        setY(y);
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setPosition2D(float x, float y) {
        setX(x);
        setY(y);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Position2D getPosition() {
        return new Position2D(getX(), getY());
    }
}
