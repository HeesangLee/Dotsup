package dalcoms.game.dotsup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class MenuLevelSelectButtonGroup
        implements GestureDetectableButton, Renderable {

    final Dotsup game;
    private SpriteBatch batch;
    private Array<Texture> textureArrayOfNumbers;
    private Texture textureArrowLeft, textureArrowRight;
    private float locationX, locationY, width, height;
    final int BUTTON_COUNT = 7;
    private int focusingButton = 0;
    private Array<SpriteNumber> levelNumberArray;
    private boolean displayArrowLeft, displayArrowRight;
    private Position2D positionArrowLeft, positionArrowRight;
    private int levelMin, levelMax;
    private float levelButtonWidth;
    private TexturePositon2D textureSelectedBgCircle;
    private int touchAreaX1, touchAreaX2, touchAreaY1, touchAreaY2;
    private boolean touched = false;
    private final int TOUCH_OUT = -1;
    private final int TOUCH_LEFT = 0;
    private final int TOUCH_1 = 1;
    private final int TOUCH_2 = 2;
    private final int TOUCH_3 = 3;
    private final int TOUCH_4 = 4;
    private final int TOUCH_5 = 5;
    private final int TOUCH_RIGHT = 6;
//    private int screenHeight = 1920;
    private boolean show = false;

    public MenuLevelSelectButtonGroup(float locationX, float locationY, float width, float height,
                                      SpriteBatch batch, final Dotsup game, Array<Texture> textureArrayOfNumbers,
                                      Texture textureArrowLeft, Texture textureArrowRight, Texture textureSelBgCircle,
                                      int focusingButton, boolean show) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.width = width;
        this.height = height;
        this.textureArrayOfNumbers = textureArrayOfNumbers;
        this.textureArrowLeft = textureArrowLeft;
        this.textureArrowRight = textureArrowRight;
        this.textureSelectedBgCircle = new TexturePositon2D(textureSelBgCircle, 0f, 0f);
        this.batch = batch;
        this.game = game;
        this.show = show;

        initThis();
        this.setFocusingButton(focusingButton, false);
    }

    private void initThis() {
        levelNumberArray = new Array<SpriteNumber>() {
            {
                add(new SpriteNumber(textureArrayOfNumbers, 1, batch));
                add(new SpriteNumber(textureArrayOfNumbers, 2, batch));
                add(new SpriteNumber(textureArrayOfNumbers, 3, batch));
                add(new SpriteNumber(textureArrayOfNumbers, 4, batch));
                add(new SpriteNumber(textureArrayOfNumbers, 5, batch));

            }
        };

        levelButtonWidth = getWidth() / BUTTON_COUNT;
//        screenHeight = Gdx.graphics.getHeight();

        setTouchAreaVertices();

        setPositionArrow();
    }

    private void draw(float delta) {
        batch.draw(textureSelectedBgCircle.getTexture(), textureSelectedBgCircle.getX(), textureSelectedBgCircle.getY());

        if (isDisplayArrowLeft()) {
            batch.draw(textureArrowLeft, positionArrowLeft.getX(), positionArrowLeft.getY());
        }
        if (isDisplayArrowRight()) {
            batch.draw(textureArrowRight, positionArrowRight.getX(), positionArrowRight.getY());
        }
        for (SpriteNumber spriteNumber : levelNumberArray) {
            spriteNumber.render(delta);
        }
    }

    @Override
    public void render(float delta) {
        if (isShow()) {
            draw(delta);
        }

    }

    @Override
    public void touchDown(float x, float y, int pointer, int button) {
        Gdx.app.log(this.getClass().getSimpleName() + " TouchDown",
                "x = " + String.valueOf(x) +
                        "y = " + String.valueOf(y) +
                        "pointer = " + String.valueOf(pointer) +
                        "button = " + String.valueOf(button));

        setTouched(isTouchInButtonArea((int) x, (int) y));
        actionTouchDown(getTouchAreaFlag((int) x, (int) y));
    }

    @Override
    public void tap(float x, float y, int count, int button) {
        Gdx.app.log(this.getClass().getSimpleName() + " Tap",
                "x = " + String.valueOf(x) +
                        "y = " + String.valueOf(y) +
                        "count = " + String.valueOf(count) +
                        "button = " + String.valueOf(button));
        setTouched(false);
    }

    @Override
    public void longPress(float x, float y) {
        Gdx.app.log(this.getClass().getSimpleName() + " LongPress",
                "x = " + String.valueOf(x) +
                        "y = " + String.valueOf(y));
        actionLongPress(getTouchAreaFlag((int) x, (int) y));
    }

    @Override
    public void fling(float velocityX, float velocityY, int button) {
        Gdx.app.log(this.getClass().getSimpleName() + " Fling",
                "Vel_x = " + String.valueOf(velocityX) +
                        "Vel_y = " + String.valueOf(velocityY));

    }

    public int getFocusingButton() {
        return focusingButton;
    }

    public void setFocusingButton(int focusingButton, boolean checkFocusingChanged) {
        boolean focusingChanged = false;
        if ((focusingButton > 0) & (focusingButton < GameLevel.getMaxLevel() + 1)) {

            if (this.focusingButton != focusingButton) {
                this.focusingButton = focusingButton;
                focusingChanged = true;
            }
        }

        int levelRange[] = GameLevel.getLevelViewRange(this.focusingButton);
        Gdx.app.log("setFocusingButton", String.valueOf(getLevelMin()) + " , "
                + String.valueOf(getLevelMax()));

        if (setLevelMin(levelRange[GameLevel.RANGE_MIN]) | setLevelMax(levelRange[GameLevel.RANGE_MAX])) {
            setDisplayArrow();
            setLevelNumberArray();
        }

        setSelectedBgCirclePosition();

        if (focusingChanged) {
            setLevelButtonColor();
            if (checkFocusingChanged) {
                isFocusingChanged();
            }

        }
    }

    /**
     * @return true if it is locked
     */
    public boolean isLockedLevel() {
        return getFocusingButton() > game.getGameConfiguration().getLastClearedLevel() + 1;
    }

    public boolean isClearedLevel() {
        return getFocusingButton() < game.getGameConfiguration().getLastClearedLevel() + 1;
    }

    public boolean isNewLevel() {
        return getFocusingButton() == game.getGameConfiguration().getLastClearedLevel() + 1;
    }

    public int getLevelStatus() {
        if (isNewLevel()) {
            return MenuLevelInfo.LEVEL_NEW;
        } else if (isClearedLevel()) {
            return MenuLevelInfo.LEVEL_CLEARED;
        } else {//locked
            return MenuLevelInfo.LEVEL_LOCKED;
        }
    }

    /**
     * Using this method with override in other Class
     */
    public void isFocusingChanged() {

    }

    private int getFocusingButtonIndex(int focusingButton) {
        return focusingButton % 5 > 0 ? focusingButton % 5 : 5;
    }

    private void setSelectedBgCirclePosition() {
        float x = getLocationX() + getFocusingButtonIndex(getFocusingButton()) * getLevelButtonWidth() + 0.5f * getLevelButtonWidth() -
                0.5f * this.textureSelectedBgCircle.getTexture().getWidth();
        float y = getLocationY() + 0.5f * (getHeight() - this.textureSelectedBgCircle.getTexture().getHeight());

        this.textureSelectedBgCircle.setPosition2D(x, y);
    }


    private void setDisplayArrow() {
        this.displayArrowLeft = getLevelMin() == 1 ? false : true;
        this.displayArrowRight = getLevelMax() >= GameLevel.getMaxLevel() ? false : true;
    }

    private void setLevelNumberArray() {

        for (int i = 0; i < BUTTON_COUNT - 2; i++) {
            levelNumberArray.get(i).setNumber(i + getLevelMin());

            levelNumberArray.get(i).setOrigin(new Position2D(
                    getLocationX() + levelButtonWidth
                            * (i + 1) + (levelButtonWidth - levelNumberArray.get(i).getSpriteNumWidth()) / 2f,
                    getLocationY() + (getHeight() - textureArrowRight.getHeight()) / 2f));
        }

    }

    private void setLevelButtonColor() {
        for (int i = 0; i < BUTTON_COUNT - 2; i++) {
            if ((levelNumberArray.get(i).getNumber() == getFocusingButton())
                    | (levelNumberArray.get(i).getNumber() > game.getGameConfiguration().getLastClearedLevel())) {
                levelNumberArray.get(i).setColor(GameColor.WHITE);
            } else {
                levelNumberArray.get(i).setColor(GameColor.MENU_LEVEL_SELECT_ACTIVE);
            }
        }
    }


    public int getLevelMin() {
        return levelMin;
    }

    /**
     * @param levelMin
     * @return True if levelMin is changed
     */
    public boolean setLevelMin(int levelMin) {
        boolean ret = false;
        if (this.levelMin != levelMin) {
            this.levelMin = levelMin;
            ret = true;
        }
        return ret;
    }

    public int getLevelMax() {
        return levelMax;
    }


    public boolean setLevelMax(int levelMax) {
        boolean ret = false;
        if (this.levelMax != levelMax) {
            this.levelMax = levelMax;
            ret = true;
        }
        return ret;
    }

    private void setPositionArrow() {
        setPositionArrowLeft();
        setPositionArrowRight();
    }

    private void setPositionArrowLeft() {
        this.positionArrowLeft = new Position2D(
                getLocationX() + (levelButtonWidth - textureArrowLeft.getWidth()) / 2f,
                getLocationY() + (getHeight() - textureArrowLeft.getHeight()) / 2f);
    }

    private void setPositionArrowRight() {
        this.positionArrowRight = new Position2D(
                getLocationX() + levelButtonWidth * 6 +
                        (levelButtonWidth - textureArrowRight.getWidth()) / 2f,
                getLocationY() + (getHeight() - textureArrowRight.getHeight()) / 2f);
    }


    public float getLocationX() {
        return locationX;
    }

    public float getLocationY() {
        return locationY;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public boolean isDisplayArrowLeft() {
        return displayArrowLeft;
    }

    public boolean isDisplayArrowRight() {
        return displayArrowRight;
    }

    public boolean isTouched() {
        return touched;
    }

    public void setTouched(boolean touched) {
        Gdx.app.log("setTouched", String.valueOf(touched));
        this.touched = touched;
    }

    private void setTouchAreaVertices() {
        this.touchAreaX1 = (int) getLocationX();
        this.touchAreaX2 = touchAreaX1 + (int) getWidth();
        this.touchAreaY1 = (int) getLocationY();
        this.touchAreaY2 = touchAreaY1 + (int) getHeight();
    }

    public int getTouchAreaX1() {
        return touchAreaX1;
    }

    public int getTouchAreaX2() {
        return touchAreaX2;
    }

    public int getTouchAreaY1() {
        return touchAreaY1;
    }

    public int getTouchAreaY2() {
        return touchAreaY2;
    }

    private boolean isTouchInButtonArea(int touchX, int touchY) {
        return (touchX >= getTouchAreaX1()) && (touchX <= getTouchAreaX2())
                && (touchY >= getTouchAreaY1()) && (touchY <= getTouchAreaY2());
    }

    private void actionTouchDown(int touchFlag) {
        Gdx.app.log("ActionTouchDown", String.valueOf(touchFlag));
        switch (touchFlag) {
            case TOUCH_OUT:
                break;
            case TOUCH_LEFT:
                leftButtonClick();
                break;
            case TOUCH_RIGHT:
                rightButtonClick();
                break;
            default:
                setFocusingButton(touchFlag + getLevelMin() - 1, true);
                game.getResourcesManager().getSound_tap().play();
                break;
        }
    }

    private void actionLongPress(int touchFlag) {
        Gdx.app.log("ActionLongPress", String.valueOf(touchFlag));
        switch (touchFlag) {
            case TOUCH_LEFT:
                leftButtonLongKey();
                break;
            case TOUCH_RIGHT:
                rightButtonLongKey();
                break;
        }
    }

    private void rightButtonClick() {
        if (isDisplayArrowRight()) {
            setFocusingButton(getLevelMax() + 1, true);
            game.getResourcesManager().getSound_tap().play();
        }
    }

    private void leftButtonClick() {
        if (isDisplayArrowLeft()) {
            setFocusingButton(getLevelMin() - 1, true);
            game.getResourcesManager().getSound_tap().play();
        }
    }

    private void rightButtonLongKey() {
        if (isDisplayArrowRight()) {
            setFocusingButton(GameLevel.getMaxLevel(), true);
        }
    }

    private void leftButtonLongKey() {
        if (isDisplayArrowLeft()) {
            setFocusingButton(1, true);
        }
    }

    private int getTouchAreaFlag(int touchX, int touchY) {
        int ret = TOUCH_OUT;

        if (isTouched()) {
            ret = (touchX - (int) getLocationX()) / (int) getLevelButtonWidth();

        }

        return ret;
    }

    public float getLevelButtonWidth() {
        return levelButtonWidth;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}