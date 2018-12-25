package dalcoms.game.dotsup;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SpriteGameObject extends GameObject {
    private Sprite sprite;
    private SpriteActionListener spriteActionListener;
    private boolean flag_checkActionScale, flag_checkActionAlpha, flag_checkActionRotation = false;
    private float velocityActionScale, velocityActionAlpha, velocityActionRotation = 0f;
    private float toActionScale, toActionAlpha, toActionRotation = 0f;
    private boolean flag_drawSprite = false;

    /*
     *@param defaultDotsNum range 1~9
     */
    public SpriteGameObject(Texture texture, float locationX, float locationY) {
        super(texture, locationX, locationY);
        createSprite(texture);
    }

    public SpriteGameObject setSpriteBatch(SpriteBatch batch) {
        super.setSpriteBatch(batch);
        return this;
    }

    private void createSprite(Texture texture) {
        sprite = new Sprite(texture);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        checkSpriteActions(delta);

        if (isDrawSpriteEnabled()) {
            draw(delta);
        }

    }

    public SpriteGameObject enableDrawSprite(boolean enable) {
        this.flag_drawSprite = enable;
        return this;
    }

    public boolean isDrawSpriteEnabled() {
        return this.flag_drawSprite;
    }

    private void draw(float delta) {
        sprite.setPosition(getLocationFollowingLeaderX(), getLocationFollowingLeaderY());

        sprite.draw(batch);
    }

    public Sprite getSprite() {
        return this.sprite;
    }

    public void addSpriteActionListener(SpriteActionListener spriteActionListener) {
        this.spriteActionListener = spriteActionListener;
    }

    private void checkSpriteActions(float delta) {
        if (isFlag_checkActionScale()) {
            checkActionScale(delta);
        }
        if (isFlag_checkActionAlpha()) {
            checkActionAlpha(delta);
        }
        if (isFlag_checkActionRotation()) {
            checkActionRotate(delta);
        }
    }

    public void actionScale(float fromScale, float toScale, float duration) {
        setFlag_checkActionScale(true);
        this.setVelocityActionScale((toScale - fromScale) / duration);
        this.sprite.setScale(fromScale);
        setToActionScale(toScale);

        if (spriteActionListener != null) {
            spriteActionListener.onActionScaleStarted();
        }
    }

    private void checkActionScale(float delta) {
        boolean checkAction = true;
        float toScale;
        float velocity = getVelocityActionScale();

        toScale = this.sprite.getScaleX() + delta * velocity;

        if (velocity > 0) {
            if (toScale >= getToActionScale()) {
                toScale = getToActionScale();
                checkAction = false;
            }
        } else {
            if (toScale <= getToActionScale()) {
                toScale = getToActionScale();
                checkAction = false;
            }
        }

        this.sprite.setScale(toScale);

        if (checkAction == false) {
            setFlag_checkActionScale(checkAction);
            if (spriteActionListener != null) {
                spriteActionListener.onActionScaleCompleted();
            }
        }

    }

    public void actionRotate(float fromRotate, float toRotate, float duration) {
        setFlag_checkActionRotation(true);
        this.setVelocityActionRotation((toRotate - fromRotate) / duration);
        this.sprite.setRotation(fromRotate);
        setToActionRotation(toRotate);

        if (spriteActionListener != null) {
            spriteActionListener.onActionRotateStarted();
        }
    }

    private void checkActionRotate(float delta) {
        boolean checkAction = true;
        float toRotate;
        float velocity = getVelocityActionRotation();

        toRotate = this.sprite.getRotation() + delta * velocity;

        if (velocity > 0) {
            if (toRotate >= getToActionRotation()) {
                toRotate = getToActionRotation();
                checkAction = false;
            }
        } else {
            if (toRotate <= getToActionRotation()) {
                toRotate = getToActionRotation();
                checkAction = false;
            }
        }

        this.sprite.setRotation(toRotate);

        if (checkAction == false) {
            setFlag_checkActionRotation(checkAction);
            if (spriteActionListener != null) {
                spriteActionListener.onActionRotateCompleted();
            }
        }

    }

    public void actionAlpha(float fromAlpha, float toAlpha, float duration) {
        setFlag_checkActionAlpha(true);
        this.setVelocityActionAlpha((toAlpha - fromAlpha) / duration);
        this.sprite.setAlpha(fromAlpha);
        setToActionAlpha(toAlpha);

        if (spriteActionListener != null) {
            spriteActionListener.onActionAlphaStarted();
        }
    }

    private void checkActionAlpha(float delta) {
        boolean checkAction = true;
        float toAlpha;
        float velocity = getVelocityActionAlpha();

        toAlpha = this.sprite.getColor().a + delta * velocity;

        if (velocity > 0) {
            if (toAlpha >= getToActionAlpha()) {
                toAlpha = getToActionAlpha();
                checkAction = false;
            }
        } else {
            if (toAlpha <= getToActionAlpha()) {
                toAlpha = getToActionAlpha();
                checkAction = false;
            }
        }

        this.sprite.setAlpha(toAlpha);

        if (checkAction == false) {
            setFlag_checkActionAlpha(checkAction);
            if (spriteActionListener != null) {
                spriteActionListener.onActionAlphaCompleted();
            }
        }

    }

    public boolean isFlag_checkActionScale() {
        return flag_checkActionScale;
    }

    public boolean isFlag_checkActionAlpha() {
        return flag_checkActionAlpha;
    }

    public boolean isFlag_checkActionRotation() {
        return flag_checkActionRotation;
    }

    public void setFlag_checkActionScale(boolean flag_checkActionScale) {
        this.flag_checkActionScale = flag_checkActionScale;
    }


    public void setFlag_checkActionAlpha(boolean flag_checkActionAlpha) {
        this.flag_checkActionAlpha = flag_checkActionAlpha;
    }

    public void setFlag_checkActionRotation(boolean flag_checkActionRotation) {
        this.flag_checkActionRotation = flag_checkActionRotation;
    }

    public void setVelocityActionScale(float velocityActionScale) {
        this.velocityActionScale = velocityActionScale;
    }


    public void setVelocityActionAlpha(float velocityActionAlpha) {
        this.velocityActionAlpha = velocityActionAlpha;
    }

    public void setVelocityActionRotation(float velocityActionRotation) {
        this.velocityActionRotation = velocityActionRotation;
    }

    public float getVelocityActionScale() {
        return velocityActionScale;
    }


    public float getVelocityActionAlpha() {
        return velocityActionAlpha;
    }

    public float getVelocityActionRotation() {
        return velocityActionRotation;
    }

    public void setToActionScale(float toActionScale) {
        this.toActionScale = toActionScale;
    }


    public void setToActionAlpha(float toActionAlpha) {
        this.toActionAlpha = toActionAlpha;
    }

    public void setToActionRotation(float toActionRotation) {
        this.toActionRotation = toActionRotation;
    }

    public float getToActionScale() {
        return toActionScale;
    }


    public float getToActionAlpha() {
        return toActionAlpha;
    }

    public float getToActionRotation() {
        return toActionRotation;
    }
}
