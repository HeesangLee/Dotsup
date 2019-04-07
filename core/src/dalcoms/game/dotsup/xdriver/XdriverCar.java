package dalcoms.game.dotsup.xdriver;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import dalcoms.game.dotsup.SpriteGameObject;
import dalcoms.game.dotsup.xdriver.Car;

public class XdriverCar extends Car {
    SpriteGameObject bottomEffect;
    private float refTouchX, refTouchY;
    private float deltaX = 0, deltaY = 0;

    public XdriverCar(Texture texture, float locationX, float locationY, SpriteBatch batch, boolean visible) {
        super(texture, locationX, locationY, batch, visible);
    }

    public void addBottomEffect(Texture texture) {
        this.bottomEffect = new SpriteGameObject(texture, -53.5f, 11.5f)
                .setSpriteBatch(batch)
                .enableDrawSprite(true);
    }

    private void updateBottomEffect(float delta) {
        final float angularVel = 360 / 5f;
        if ((bottomEffect != null) && Gdx.input.isTouched(0)) {
            bottomEffect.setCenterLocation(this.getCenterX(), this.getCenterY());
            bottomEffect.getSprite().rotate(angularVel * delta);
            bottomEffect.render(delta);
        }
    }

    public void resetTouchInput(float x, float y) {
        refTouchX = x;
        refTouchY = y;
    }

    public void moveXdriver(float x, float y) {
        deltaX = x - refTouchX;
        deltaY = y - refTouchY;

        refTouchX = x;
        refTouchY = y;
    }

    private void checkingMoving(float delta) {
        float posX = getLocationX() + deltaX;
        float posY = getLocationY() + deltaY;
        if (posX < 0) {
            posX = 0;
        } else if (posX > 1080f - getWidth()) {
            posX = 1080f - getWidth();
        }

        if (posY < 280f) {
            posY = 280f;
        } else if (posY > 1480f) {
            posY = 1480f;
        }
        setLocation(posX, posY);
        deltaX = 0;
        deltaY = 0;
    }

    @Override
    public void render(float delta) {
        checkingMoving(delta);
        updateBottomEffect(delta);
        super.render(delta);

    }
}
