package dalcoms.game.dotsup;

public class Point2DInt {
    private int x = 0, y = 0;

    public Point2DInt() {

    }

    public Point2DInt(int x, int y) {
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point2DInt getPoint() {
        return new Point2DInt(getX(), getY());
    }
    public String toString() {
        return "(" + String.valueOf(getX()) + ", " + String.valueOf(getY())+")";
    }
}
