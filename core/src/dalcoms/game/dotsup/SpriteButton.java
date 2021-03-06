package dalcoms.game.dotsup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * 기본적으로 단일 Sprite button 으로 작성
 * Button touch effect and state
 * [State]
 * Enabled/Disabled and touchdown --> default : enabled
 * enabled normal and touchdown, disabled normal and touchdown
 * Color, Size
 */
public class SpriteButton extends SpriteGameObject
        implements GestureDetectableButton {

    final static boolean STATE_EN = false;
    final static boolean STATE_DIS = true;
    private boolean colorEffectEnabled, scaleEffectEnabled = false;
    private boolean touched = false;
    private Color colorEnNormal, colorEnTouchDown, colorDisNormal, colorDisTouchDown;
    private float scaleEnTouchDown, scaleDisTouchDown = 1f;
    private int buttonX1 = 0, buttonX2 = 0, buttonY1 = 0, buttonY2 = 0;
    private int screenHeight = 1920;
    private boolean buttonState = STATE_EN;
    private Texture textureTop;
    private float textureTopLocationX = 0f, textureTopLocationY = 0f;
    private Viewport viewport;

//    public SpriteButton(Texture texture, float locationX, float locationY) {
//        super(texture, locationX, locationY);
//        initThis();
//
//    }

    public SpriteButton(Texture texture, float locationX, float locationY, SpriteBatch batch,
            Viewport viewport) {
        super(texture, locationX, locationY);
        initThis();
        super.setSpriteBatch(batch);
        this.viewport = viewport;
    }

    private void initThis() {
        setButtonVertices();
        this.enableDrawSprite(true);
        screenHeight = Gdx.graphics.getHeight();
    }


    public SpriteButton setSpriteBatch(SpriteBatch batch) {
        super.setSpriteBatch(batch);
        return this;
    }

    public void setTopTexture(Texture topTexture) {
        textureTop = topTexture;
        setTopTextureToCenter();
    }

    public void setTopTexture(Texture topTexture, float locationX, float locationY) {
        setTopTexture(topTexture);
        this.textureTopLocationX = locationX;
        this.textureTopLocationY = locationY;
    }

    private void setTopTextureToCenter() {
        this.textureTopLocationX = (float) (getWidth() - this.textureTop.getWidth()) / 2f;
        this.textureTopLocationY = (float) (getHeight() - this.textureTop.getHeight()) / 2f;
    }

    public float getTextureTopLocationX() {
        return textureTopLocationX;
    }

    public float getTextureTopLocationY() {
        return textureTopLocationY;
    }

    public void setColorEffect(boolean enable, Color enNormal, Color enTouchDown, Color disNormal,
            Color disTouchDown) {
        this.colorEffectEnabled = enable;
        this.colorEnNormal = enNormal;
        this.colorEnTouchDown = enTouchDown;
        this.colorDisNormal = disNormal;
        this.colorDisTouchDown = disTouchDown;

        checkColorEffect(false);
    }

    public void setScaleEffect(boolean enable, float enTouchDown, float disTouchDown) {
        this.scaleEffectEnabled = enable;
        this.scaleEnTouchDown = enTouchDown;
        this.scaleDisTouchDown = disTouchDown;

    }

    public boolean isColorEffectEnabled() {
        return colorEffectEnabled;
    }

    public boolean isScaleEffectEnabled() {
        return scaleEffectEnabled;
    }

    public Color getColorEnNormal() {
        return colorEnNormal;
    }

    public Color getColorEnTouchDown() {
        return colorEnTouchDown;
    }

    public Color getColorDisNormal() {
        return colorDisNormal;
    }

    public Color getColorDisTouchDown() {
        return colorDisTouchDown;
    }

    public void setButtonState(boolean buttonState) {
        this.buttonState = buttonState;
        checkColorEffect(false);
//        Gdx.input.isTouched() & isTouchInButtonArea(Gdx.input.getX()
    }


    public boolean getButtonState() {
        return buttonState;
    }

    public float getScaleEnTouchDown() {
        return scaleEnTouchDown;
    }

    public float getScaleDisTouchDown() {
        return scaleDisTouchDown;
    }

    private float getScaleTouchDown(boolean buttonState) {
        float scaleTouchDown;
        if (buttonState) {//true = disabled
            scaleTouchDown = getScaleDisTouchDown();
        } else {
            scaleTouchDown = getScaleEnTouchDown();
        }
        return scaleTouchDown;
    }

    private Color getColorTouchDown(boolean buttonState) {
        Color ret;

        if (buttonState) {
            ret = getColorDisTouchDown();
        } else {
            ret = getColorEnTouchDown();
        }

        return ret;
    }

    private Color getColorNormal(boolean buttonState) {
        Color ret;

        if (buttonState) {
            ret = getColorDisNormal();
        } else {
            ret = getColorEnNormal();
        }

        return ret;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        if (isTouched()) {
            Position2D newTouchPosition = getNewTouchPoint(Gdx.input.getX(), Gdx.input.getY());
            int touchX = (int) newTouchPosition.getX();
            int touchY = (int) newTouchPosition.getY();

            setTouched(Gdx.input.isTouched()
                       & isTouchInButtonArea(touchX, touchY));
        }
        if (textureTop != null) {
            drawTopTexture(delta);
        }
    }

    Position2D getNewTouchPoint(float x, float y) {
        Gdx.app.log("touchdebug", "1.x : " + String.valueOf(x) + ",y : " + String.valueOf(y));
        Vector2 newPoints = new Vector2(x, y);
        newPoints = viewport.unproject(newPoints);
        x = newPoints.x;
        y = newPoints.y;
        Gdx.app.log("touchdebug", "2.x : " + String.valueOf(x) + ",y : " + String.valueOf(y));
        return new Position2D(x, y);
    }


    private void drawTopTexture(float delta) {
        batch.draw(textureTop,
                   getLocationFollowingLeaderX() + getTextureTopLocationX(),
                   getLocationFollowingLeaderY() + getTextureTopLocationY());
    }


    @Override
    public void touchDown(float screenX, float screenY, int pointer, int button) {
        Gdx.app.log(this.getClass().getSimpleName() + " TouchDown",
                    "x = " + String.valueOf(screenX) +
                    "y = " + String.valueOf(screenY) +
                    "pointer = " + String.valueOf(pointer) +
                    "button = " + String.valueOf(button));
        setTouched(isTouchInButtonArea((int) screenX, (int) screenY));

        if (isTouchInButtonArea((int) screenX, (int) screenY)) {
            actionTouchDown();
        }
    }

    @Override
    public void tap(float screenX, float screenY, int count, int button) {
        Gdx.app.log(this.getClass().getSimpleName() + " Tap",
                    "x = " + String.valueOf(screenX) +
                    "y = " + String.valueOf(screenY) +
                    "count = " + String.valueOf(count) +
                    "button = " + String.valueOf(button));
        setTouched(false);
        if (isTouchInButtonArea((int) screenX, (int) screenY)) {
            actionTap();
        }
    }

    @Override
    public void longPress(float x, float y) {
        Gdx.app.log(this.getClass().getSimpleName() + " LongPress",
                    "x = " + String.valueOf(x) +
                    "y = " + String.valueOf(y));
        if (isTouchInButtonArea((int) x, (int) y)) {
            actionLongPress();
        }
    }

    @Override
    public void fling(float velocityX, float velocityY, int button) {

    }


    private boolean isTouchInButtonArea(int touchX, int touchY) {
        boolean ret = false; // true : touch on, false : touch out

        ret = (touchX >= buttonX1) && (touchX <= buttonX2) && (touchY >= buttonY1) &&
              (touchY <= buttonY2);

        return ret;
    }

    public void actionTouchDown() {

    }

    public void actionTap() {

    }

    public void actionLongPress() {

    }


    private void checkTouchEffect(boolean isTouched) {

        if (isColorEffectEnabled()) {
            checkColorEffect(isTouched);
        }
        if (isScaleEffectEnabled()) {
            checkScaleEffect(isTouched);
        }
    }

    private void checkColorEffect(boolean isTouched) {
        if (isTouched) {
            this.getSprite().setColor(getColorTouchDown(getButtonState()));
        } else {
            this.getSprite().setColor(getColorNormal(getButtonState()));
        }
    }

    private void checkScaleEffect(boolean isTouched) {
        if (isTouched) {
            this.getSprite().setScale(getScaleTouchDown(getButtonState()));
        } else {
            this.getSprite().setScale(1f);
        }
    }

    private void setButtonVertices() {
        this.buttonX1 = (int) getLocationFollowingLeaderX();
        this.buttonX2 = buttonX1 + getWidth();
        this.buttonY1 = (int) getLocationFollowingLeaderY();
        this.buttonY2 = buttonY1 + getHeight();
    }

    public void updateTouchArea() {
        setButtonVertices();
    }

    public boolean isTouched() {
        return touched;
    }

    public void setTouched(boolean touched) {
        if (this.touched != touched) { // Apply effect only when touch status is changed.
            checkTouchEffect(touched);
        }
        this.touched = touched;
    }
}
