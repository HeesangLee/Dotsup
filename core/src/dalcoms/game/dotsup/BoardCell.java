package dalcoms.game.dotsup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BoardCell extends GameObject {
    final static int DISABLED = 0;
    final static int RESERVED = 1;
    final static int ENABLED_BLANK = 2;
    final static int ENABLED_DOTS = 3;

    private Dots dots;
    private Dots reservedDots;

    private boolean reserved = false;
    private GameCellListener gameCellListener;

    private Point2DInt cellPosition;


    public BoardCell(Texture texture, float locationX, float locationY) {
        super(texture, locationX, locationY);
    }

    public BoardCell(Texture texture, float locationX, float locationY, boolean isShow) {
        super(texture, locationX, locationY, isShow);
    }

    public BoardCell setSpriteBatch(SpriteBatch batch) {
        super.setSpriteBatch(batch);
        return this;
    }

    public Dots getDots() {
        return dots;
    }

    public void setDots(Dots dots) {
        this.dots = dots;
    }

    public Dots getReservedDots() {
        return reservedDots;
    }

    public void setReservedDots(Dots reservedDots) {
        reserve(true);
        this.reservedDots = reservedDots;
    }

    public void setReservedDots(Dots reservedDots, boolean effectOn) {
        setReservedDots(reservedDots);
        if (effectOn) {
            getDots().actionRotate(0, 360, 0.5f);
        }
    }

    public boolean isDotsIn() {
        return this.dots != null;
    }

    public boolean isEnabledCell() {
        return isDrawTexture();
    }

    public boolean isDotsInEnabledCell() {
        return isDotsIn() & isDrawTexture();
    }

    public boolean isBlankInEnabledCell() {
        return !isDotsIn() & isDrawTexture();
    }

    public boolean isDisabledCell() {
        return !isDrawTexture();
    }

    public boolean isReserved() {
        return reserved;
    }

    public void reserve(boolean reserved) {
        this.reserved = reserved;
    }

    public int getCellStatus() {
        int ret = DISABLED;

        if (isDisabledCell()) {
            ret = DISABLED;
            Gdx.app.log("cell status", "DISABLED");
        } else {
            if (isReserved()) {
                ret = RESERVED;
                Gdx.app.log("cell status", "RESERVED");
            } else {
                if (isDotsIn()) {
                    ret = ENABLED_DOTS;
                    Gdx.app.log("cell status", "ENABLED_DOTS");
                } else {
                    ret = ENABLED_BLANK;
                    Gdx.app.log("cell status", "ENABLED_BLANK");
                }
            }
        }

        return ret;
    }

    private boolean checkOverrideDots() {
        return ((dots.getLocationX() == reservedDots.getLocationX()) &
                (dots.getLocationY() == reservedDots.getLocationY()));
    }

    private void mergeDots() {
//        final int dotsNum = dots.getDotsNum() > 9 ? 9 : dots.getDotsNum() + 1;
        int dotsNum = dots.getDotsNum();
        if (dotsNum < 9) {
            dotsNum++;
        } else if (dotsNum == Dots.DOTS_MISSILE) {
//            dotsNum = 1;
        }
        reservedDots = null;
        reserve(false);

        dots.setDotsNum(dotsNum);
        dots.applyEffectNew();
        dotsMerged(dotsNum);
    }

    public void dotsMerged(int mergedDotsNum) {
        if (gameCellListener != null) {
            gameCellListener.dotsMerged(mergedDotsNum, getTag(), getCellPosition());
        }

    }

    public void addGameCellListener(GameCellListener gameCellListener) {
        this.gameCellListener = gameCellListener;
    }

    public Point2DInt getCellPosition() {
        return cellPosition;
    }

    public void setCellPosition(Point2DInt cellPosition) {
        this.cellPosition = cellPosition;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        if (dots != null) {
            dots.render(delta);
        }
        if (reservedDots != null) {
            reservedDots.render(delta);
        }
        if (dots != null && reservedDots != null) {
            if (checkOverrideDots()) {
                mergeDots();
            }
        }
    }
}
