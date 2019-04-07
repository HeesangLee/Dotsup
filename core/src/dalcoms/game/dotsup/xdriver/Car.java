package dalcoms.game.dotsup.xdriver;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import dalcoms.game.dotsup.SpriteGameObject;

public class Car extends SpriteGameObject {
    public Car(Texture texture, float locationX, float locationY, SpriteBatch batch, boolean visible) {
        super(texture, locationX, locationY);
        setSpriteBatch(batch);
        enableDrawSprite(visible);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }
}
