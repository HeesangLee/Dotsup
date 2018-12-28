package dalcoms.game.dotsup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Timer;

public class GameBoard extends SimpleBoard {

    private Array<Texture> textureDots;
    private Array<Dots> dotsBank;
    private Array<Dots> dotsOnBoard;
    private boolean gameStarted = false;
    public final static int LEFT = 0;
    public final static int RIGHT = 1;
    public final static int UP = 2;
    public final static int DOWN = 3;

    private boolean onMoving = false;

    private float flingVelocityX, flingVelocityY;

    private GameBoardListener gameBoardListener;


    public GameBoard(Texture textureCell, Array<Texture> textureDots,
                     float centerX, float centerY, boolean[][] board,
                     SpriteBatch batch, boolean show) {
        super(textureCell, centerX, centerY, board, batch, show);
        this.textureDots = textureDots;
        dotsBank = new Array<Dots>();
        dotsOnBoard = new Array<Dots>();
        initThis(board);
    }

    private void initThis(boolean[][] board) {
        initDots(calcEnabledBoardCellCount(board));
    }

    private void initDots(int dotsCount) {
        for (int i = 0; i < dotsCount; i++) {
            dotsBank.add(new Dots(textureDots, 0, 0, 1)
                    .setSpriteBatch(batch));
        }
    }

    private Dots popDotsFromBank() {
        if (dotsBank.size == 0) {
            dotsBank.add(new Dots(textureDots, 0, 0, 1)
                    .setSpriteBatch(batch));
        } else if (dotsBank.size < 4) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Gdx.app.postRunnable(new Runnable() {
                        @Override
                        public void run() {
                            initDots(10);
                        }
                    });
                }
            }).start();
        }
        return dotsBank.pop();
    }

    private int calcEnabledBoardCellCount(boolean[][] board) {
        int count = 0;
        for (int x = 0; x < CELL_X; x++) {
            for (int y = 0; y < CELL_Y; y++) {
                if (board[x][y]) {
                    count++;
                }
            }
        }
        return count;
    }

    public void start() {
        gameStarted = true;
        setNewDotsInCell(getBlankCells());
    }

    public void stop() {
        gameStarted = false;
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    private boolean setNewDotsInCell(Array<BoardPosition2D> blankCells) {//return true if no blank cell
        boolean ret = false;

        if (blankCells.size != 0) {
            blankCells.shuffle();
            BoardPosition2D posionCell = blankCells.peek();
            BoardCell cell = getCell(posionCell.getX(), posionCell.getY());

            Dots dots = popDotsFromBank();
            dots.setDotsNum(1);
            dots.setLocation(cell.getLocationX(), cell.getLocationY());
            dots.applyEffectNew();

            cell.setDots(dots);
        } else {
            ret = true;
        }

        return ret;
    }

    private Array<BoardPosition2D> getBlankCells() {
        Array<BoardPosition2D> blankCells = new Array<BoardPosition2D>();

        for (int x = 0; x < CELL_X; x++) {
            for (int y = 0; y < CELL_Y; y++) {
                if (getCell(x, y).isEnabledCell() & !getCell(x, y).isDotsIn()) {
                    blankCells.add(new BoardPosition2D(x, y));
                }
            }
        }

        return blankCells;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

    public void addGameBoardListener(GameBoardListener gameBoardListener) {
        this.gameBoardListener = gameBoardListener;
    }

    @Override
    protected void initCells(boolean[][] board, SpriteBatch batch) {
        super.initCells(board, batch);
        addCellListenerToCells();
    }

    private void addCellListenerToCells() {
        for (int x = 0; x < CELL_X; x++) {
            for (int y = 0; y < CELL_Y; y++) {
                getCell(x, y).addGameCellListener(new GameCellListener() {
                    @Override
                    public void dotsMerged(int mergedDotsNum, String id) {
                        super.dotsMerged(mergedDotsNum, id);
                        if (gameBoardListener != null) {
                            gameBoardListener.dotsMerged(mergedDotsNum, id);
                        }
                    }
                });
            }
        }
    }

    private void moveDots(int direction) {
        boolean isMoved = false;
        switch (direction) {
            case LEFT:
                isMoved = moveDotsToLeft();
                break;
            case RIGHT:
                isMoved = moveDotsToRight();
                break;
            case UP:
                isMoved = moveDotsToUp();
                break;
            case DOWN:
                isMoved = moveDotsToDown();
                break;
            default:
                Gdx.app.log("GameBoard.moveDots", "Not defined direction int");
                break;
        }
        if (isMoved) {
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    setNewDotsInCell(getBlankCells());
                    setOnMoving(false);
                }
            }, getMovingTimeByVelocity() * (CELL_X - 1));

        } else {
            setOnMoving(false);
        }

    }


    private boolean checkMovingLeft(BoardPosition2D cellPosition) {
        final Dots myDots = getCell(cellPosition.getX(), cellPosition.getY()).getDots();
        final int myDotsNum = myDots.getDotsNum();
        final int y = cellPosition.getY();
        final float MOVING_TIME = getMovingTimeByVelocity();

        boolean loopBreak = false;
        int gotoX = cellPosition.getX();
        boolean isGoto = false;
        boolean gotoForMerge = false;


        for (int x = cellPosition.getX(); x > 0; x--) {
            switch (getCell(x - 1, y).getCellStatus()) {
                case BoardCell.DISABLED:
                case BoardCell.RESERVED:
                    if (x != cellPosition.getX()) {//it should be moved
                        gotoX = x;
                        isGoto = true;
                    }
                    loopBreak = true;
                    break;
                case BoardCell.ENABLED_BLANK://only move when it reach to the edge
                    if ((x - 1) == 0) {
                        gotoX = x - 1;
                        isGoto = true;
                    }
                    break;
                case BoardCell.ENABLED_DOTS:
                    if ((getCell(x - 1, y).getDots().getDotsNum()
                            == myDotsNum) & myDotsNum < 9) {//merge
                        gotoForMerge = true;
                        gotoX = x - 1;
                        isGoto = true;
                    } else {//stop
                        if (x != cellPosition.getX()) {//it should be moved
                            gotoX = x;
                            isGoto = true;
                        }
                    }
                    loopBreak = true;
                    break;
            }
            if (loopBreak) {
                break;
            }
        }
        if (isGoto) {
            if (gotoForMerge) {
                getCell(gotoX, y).setReservedDots(myDots);
            } else {
                getCell(gotoX, y).setDots(myDots);
            }
            myDots.moveX(getCell(cellPosition.getX(), y).getLocationX(),
                    getCell(gotoX, y).getLocationX(),
                    MOVING_TIME * (cellPosition.getX() - gotoX));
            getCell(cellPosition.getX(), y).setDots(null);
        }

        return isGoto;
    }


    private boolean checkMovingRight(BoardPosition2D cellPosition) {
        final Dots myDots = getCell(cellPosition.getX(), cellPosition.getY()).getDots();
        final int myDotsNum = myDots.getDotsNum();
        final int y = cellPosition.getY();
        final float MOVING_TIME = getMovingTimeByVelocity();

        boolean loopBreak = false;
        int gotoX = cellPosition.getX();
        boolean isGoto = false;
        boolean gotoForMerge = false;


        for (int x = cellPosition.getX(); x < CELL_X - 1; x++) {
            switch (getCell(x + 1, y).getCellStatus()) {
                case BoardCell.DISABLED:
                case BoardCell.RESERVED:
                    if (x != cellPosition.getX()) {//it should be moved
                        gotoX = x;
                        isGoto = true;
                    }
                    loopBreak = true;
                    break;
                case BoardCell.ENABLED_BLANK://only move when it reach to the edge
                    if ((x + 1) == CELL_X - 1) {
                        gotoX = x + 1;
                        isGoto = true;
                    }
                    break;
                case BoardCell.ENABLED_DOTS:
                    if ((getCell(x + 1, y).getDots().getDotsNum()
                            == myDotsNum) & myDotsNum < 9) {//merge
                        gotoForMerge = true;
                        gotoX = x + 1;
                        isGoto = true;
                    } else {//stop
                        if (x != cellPosition.getX()) {//it should be moved
                            gotoX = x;
                            isGoto = true;
                        }
                    }
                    loopBreak = true;
                    break;
            }
            if (loopBreak) {
                break;
            }
        }
        if (isGoto) {
            if (gotoForMerge) {
                getCell(gotoX, y).setReservedDots(myDots);
            } else {
                getCell(gotoX, y).setDots(myDots);
            }
            myDots.moveX(getCell(cellPosition.getX(), y).getLocationX(),
                    getCell(gotoX, y).getLocationX(),
                    MOVING_TIME * (gotoX - cellPosition.getX()));
            getCell(cellPosition.getX(), y).setDots(null);
        }
        return isGoto;
    }

    private boolean checkMovingUp(BoardPosition2D cellPosition) {
        final Dots myDots = getCell(cellPosition.getX(), cellPosition.getY()).getDots();
        final int myDotsNum = myDots.getDotsNum();
        final int x = cellPosition.getX();
        final float MOVING_TIME = getMovingTimeByVelocity();

        boolean loopBreak = false;
        int gotoY = cellPosition.getY();
        boolean isGoto = false;
        boolean gotoForMerge = false;


        for (int y = cellPosition.getY(); y < CELL_Y - 1; y++) {
            switch (getCell(x, y + 1).getCellStatus()) {
                case BoardCell.DISABLED:
                case BoardCell.RESERVED:
                    if (y != cellPosition.getY()) {//it should be moved
                        gotoY = y;
                        isGoto = true;
                    }
                    loopBreak = true;
                    break;
                case BoardCell.ENABLED_BLANK://only move when it reach to the edge
                    if ((y + 1) == CELL_Y - 1) {
                        gotoY = y + 1;
                        isGoto = true;
                    }
                    break;
                case BoardCell.ENABLED_DOTS:
                    if ((getCell(x, y + 1).getDots().getDotsNum()
                            == myDotsNum) & myDotsNum < 9) {//merge
                        gotoForMerge = true;
                        gotoY = y + 1;
                        isGoto = true;
                    } else {//stop
                        if (y != cellPosition.getY()) {//it should be moved
                            gotoY = y;
                            isGoto = true;
                        }
                    }
                    loopBreak = true;
                    break;
            }
            if (loopBreak) {
                break;
            }
        }
        if (isGoto) {
            if (gotoForMerge) {
                getCell(x, gotoY).setReservedDots(myDots);
            } else {
                getCell(x, gotoY).setDots(myDots);
            }
            myDots.moveY(getCell(x, cellPosition.getY()).getLocationY(),
                    getCell(x, gotoY).getLocationY(),
                    MOVING_TIME * (gotoY - cellPosition.getY()));
            getCell(x, cellPosition.getY()).setDots(null);
        }
        return isGoto;
    }

    private boolean checkMovingDown(BoardPosition2D cellPosition) {
        final Dots myDots = getCell(cellPosition.getX(), cellPosition.getY()).getDots();
        final int myDotsNum = myDots.getDotsNum();
        final int x = cellPosition.getX();
        final float MOVING_TIME = getMovingTimeByVelocity();

        boolean loopBreak = false;
        int gotoY = cellPosition.getY();
        boolean isGoto = false;
        boolean gotoForMerge = false;


        for (int y = cellPosition.getY(); y > 0; y--) {
            switch (getCell(x, y - 1).getCellStatus()) {
                case BoardCell.DISABLED:
                case BoardCell.RESERVED:
                    if (y != cellPosition.getY()) {//it should be moved
                        gotoY = y;
                        isGoto = true;
                    }
                    loopBreak = true;
                    break;
                case BoardCell.ENABLED_BLANK://only move when it reach to the edge
                    if ((y - 1) == 0) {
                        gotoY = y - 1;
                        isGoto = true;
                    }
                    break;
                case BoardCell.ENABLED_DOTS:
                    if ((getCell(x, y - 1).getDots().getDotsNum()
                            == myDotsNum) & myDotsNum < 9) {//merge
                        gotoForMerge = true;
                        gotoY = y - 1;
                        isGoto = true;
                    } else {//stop
                        if (y != cellPosition.getY()) {//it should be moved
                            gotoY = y;
                            isGoto = true;
                        }
                    }
                    loopBreak = true;
                    break;
            }
            if (loopBreak) {
                break;
            }
        }

        if (isGoto) {
            if (gotoForMerge) {
                getCell(x, gotoY).setReservedDots(myDots);
            } else {
                getCell(x, gotoY).setDots(myDots);
            }
            myDots.moveY(getCell(x, cellPosition.getY()).getLocationY(),
                    getCell(x, gotoY).getLocationY(),
                    MOVING_TIME * (cellPosition.getY() - gotoY));
            getCell(x, cellPosition.getY()).setDots(null);
        }
        return isGoto;
    }

    private boolean moveDotsToLeft() {
        Gdx.app.log("GameBoard", "moveLeft");
        BoardCell cell;
        boolean ret = false;

        for (int x = 1; x < CELL_X; x++) {
            for (int y = 0; y < CELL_Y; y++) {
                cell = getCell(x, y);
                if (cell.isDotsInEnabledCell()) {
                    if (checkMovingLeft(new BoardPosition2D(x, y))) {
                        ret = true;
                    }
                }
            }
        }
        return ret;
    }


    private boolean moveDotsToRight() {
        Gdx.app.log("GameBoard", "moveRight");
        BoardCell cell;
        boolean ret = false;

        for (int x = CELL_X - 2; x > -1; x--) {
            for (int y = 0; y < CELL_Y; y++) {
                cell = getCell(x, y);
                if (cell.isDotsInEnabledCell()) {
                    if (checkMovingRight(new BoardPosition2D(x, y))) {
                        ret = true;
                    }
                }
            }
        }
        return ret;
    }

    private boolean moveDotsToUp() {
        Gdx.app.log("GameBoard", "moveUp");
        BoardCell cell;
        boolean ret = false;

        for (int y = CELL_Y - 2; y > -1; y--) {
            for (int x = 0; x < CELL_X; x++) {
                cell = getCell(x, y);
                if (cell.isDotsInEnabledCell()) {
                    if (checkMovingUp(new BoardPosition2D(x, y))) {
                        ret = true;
                    }
                }
            }
        }
        return ret;
    }

    private boolean moveDotsToDown() {
        Gdx.app.log("GameBoard", "moveDown");
        BoardCell cell;
        boolean ret = false;

        for (int y = 1; y < CELL_Y; y++) {
            for (int x = 0; x < CELL_X; x++) {
                cell = getCell(x, y);
                if (cell.isDotsInEnabledCell()) {
                    if (checkMovingDown(new BoardPosition2D(x, y))) {
                        ret = true;
                    }
                }
            }
        }
        return ret;
    }

    public void fling(float velocityX, float velocityY, int button) {
        int flingDirection;

        if (isOnMoving()) {
            return;
        }

        setLastFlingVelocity(velocityX, velocityY);

        if (!isGameStarted()) {
            return;
        }
        if (Math.abs(velocityX) > Math.abs(velocityY)) {//horizontal
            if (velocityX > 0) {
                flingDirection = RIGHT;
            } else {
                flingDirection = LEFT;
            }
        } else {//vertical --> 극성이 이미지 좌표와 반대이다. 터치,제스처의 값을 처리할 때에는 극성을 주의할 것.
            if (velocityY > 0) {
                flingDirection = DOWN;
            } else {
                flingDirection = UP;
            }
        }

        Gdx.app.log("fling", "x : " + String.valueOf(velocityX) +
                "y : " + String.valueOf(velocityY +
                "vector : " + String.valueOf(getLastFlingVeolcity())));

        setOnMoving(true);
        moveDots(flingDirection);
    }

    public boolean isOnMoving() {
        return onMoving;
    }

    public void setOnMoving(boolean onMoving) {
        this.onMoving = onMoving;
    }

    private void setLastFlingVelocity(float velocityX, float velocityY) {
        this.flingVelocityX = velocityX;
        this.flingVelocityY = velocityY;
    }

    public float getLastFlingVelocityX() {
        return flingVelocityX;
    }

    public float getLastFlingVelocityY() {
        return flingVelocityY;
    }

    public float getLastFlingVeolcity() {
        final float x = getLastFlingVelocityX();
        final float y = getLastFlingVelocityY();

        return (float) Math.sqrt(x * x + y * y);
    }

    public float getMovingTimeByVelocity() {
        final float lastVel = getLastFlingVeolcity();
        if (lastVel < 1000f) {
            return 0.12f;
        } else if (lastVel < 2000f) {
            return 0.075f;
        } else if (lastVel < 3000f) {
            return 0.05f;
        } else {
            return 0.025f;
        }
    }

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
}
