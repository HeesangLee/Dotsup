package dalcoms.game.dotsup;

public class BoardPosition2D {
    private int mapX, mapY;

    public BoardPosition2D(int x, int y) {
        mapX = x;
        mapY = y;
    }

    public int getX() {
        return mapX;
    }

    public int getY() {
        return mapY;
    }
}
