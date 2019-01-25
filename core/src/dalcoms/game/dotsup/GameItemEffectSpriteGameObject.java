package dalcoms.game.dotsup;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameItemEffectSpriteGameObject extends SpriteGameObject {

    public GameItemEffectSpriteGameObject(Texture texture, float locationX, float locationY) {
        super(texture, locationX, locationY);

    }

    public GameItemEffectSpriteGameObject(Texture texture
            , float centerLocationX, float centerLocationY
            , SpriteBatch batch) {
        this(texture, 0, 0);
        setSpriteBatch(batch);
        setCenterLocation(centerLocationX, centerLocationY);
    }

    public GameItemEffectSpriteGameObject(Texture texture
            , Position2D centerLocation
            , SpriteBatch batch) {
        this(texture, centerLocation.getX(), centerLocation.getY(), batch);
    }

    public GameItemEffectSpriteGameObject show() {
        addEffectActions();
        enableDrawSprite(true);
        return this;
    }

    private void addEffectActions() {
        addSpriteActionListener(new SpriteActionListener() {
            @Override
            public void onActionScaleStarted() {

            }

            @Override
            public void onActionScaleCompleted() {

            }

            @Override
            public void onActionAlphaStarted() {

            }

            @Override
            public void onActionAlphaCompleted() {
                onEffectCompleted();
            }

            @Override
            public void onActionRotateStarted() {

            }

            @Override
            public void onActionRotateCompleted() {

            }
        });
        actionRotate(0, 360, 0.2f);
        actionScale(0.5f, 1f, 0.33f);
        actionAlpha(1f,0.1f,0.6f);
    }

    public void onEffectCompleted() {

    }
}
