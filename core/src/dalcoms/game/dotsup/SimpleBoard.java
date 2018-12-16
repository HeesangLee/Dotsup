package dalcoms.game.dotsup;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SimpleBoard implements Renderable {
    final int CELL_X = 6;
    final int CELL_Y = 6;
    BoardCell[][] cells;
    Position2D[][] positionCellsRef;
    Position2D centerPositonRef;
    Position2D centerPosition;
    Texture textureCell;
    boolean show = false;

    public SimpleBoard(Texture textureCell, float centerX, float centerY, boolean[][] board, SpriteBatch batch, boolean show) {
        this.cells = new BoardCell[CELL_X][CELL_Y];
        this.textureCell = textureCell;
        centerPosition = new Position2D(centerX, centerY);
        this.show = show;

        calcCellLocation();
        calcBoardCenter(board);
        initCells(board, batch);
    }


    private void calcCellLocation() {
        final float cellWidth = (float) getTextureCell().getWidth();
        final float cellHeight = (float) getTextureCell().getHeight();
        final float cellGap = cellWidth * 0.1482f;

        if (positionCellsRef == null) {
            positionCellsRef = new Position2D[CELL_X][CELL_Y];
        }


        for (int x = 0; x < CELL_X; x++) {
            for (int y = 0; y < CELL_Y; y++) {
                positionCellsRef[x][y] = new Position2D(
                        (cellWidth + cellGap) * x,
                        (cellHeight + cellGap) * y
                );
            }
        }

    }

    public void calcBoardCenter(boolean[][] board) {
        int startX = CELL_X, endX = -1, startY = CELL_Y, endY = -1;
        float width, height;
        for (int x = 0; x < CELL_X; x++) {
            for (int y = 0; y < CELL_Y; y++) {
                if (board[x][y]) {
                    if (y < startY) {
                        startY = y;
                    }
                    if (y > endY) {
                        endY = y;
                    }
                    if (x < startX) {
                        startX = x;
                    }
                    if (x > endX) {
                        endX = x;
                    }
                }
            }
        }
        width = positionCellsRef[startX][0].getX() + positionCellsRef[endX][0].getX() + getTextureCell().getWidth();
        height = positionCellsRef[0][startY].getY() + positionCellsRef[0][endY].getY() + getTextureCell().getHeight();
        this.centerPositonRef = new Position2D(width * 0.5f, height * 0.5f);
    }


    private void initCells(boolean[][] board, SpriteBatch batch) {
        for (int x = 0; x < CELL_X; x++) {
            for (int y = 0; y < CELL_Y; y++) {
                cells[x][y] = new BoardCell(textureCell
                        , positionCellsRef[x][y].getX() + centerPosition.getX() - centerPositonRef.getX()
                        , positionCellsRef[x][y].getY() + centerPosition.getY() - centerPositonRef.getY()
                        , board[x][y])
                        .setSpriteBatch(batch);
            }
        }
    }

    public void updateBoard(boolean[][] board) {
        for (int x = 0; x < CELL_X; x++) {
            for (int y = 0; y < CELL_Y; y++) {
                cells[x][y].enableDrawTexture(board[x][y]);
                cells[x][y].setLocationX(positionCellsRef[x][y].getX() + centerPosition.getX() - centerPositonRef.getX());
                cells[x][y].setLocationY(positionCellsRef[x][y].getY() + centerPosition.getY() - centerPositonRef.getY());
            }
        }
    }


    @Override
    public void render(float delta) {
        if (isShow()) {
            draw(delta);
        }

    }

    private void draw(float delta) {
        for (int x = 0; x < CELL_X; x++) {
            for (int y = 0; y < CELL_Y; y++) {
                cells[x][y].render(delta);
            }
        }
    }

    private Texture getTextureCell() {
        return textureCell;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public Position2D getCenterPosition() {
        return centerPosition;
    }
}
