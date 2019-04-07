package dalcoms.game.dotsup.xdriver;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import dalcoms.game.dotsup.SpriteGameObject;

public class Heart extends SpriteGameObject {
    private boolean enbaled = true;

    public Heart(Texture texture, float locationX, float locationY, SpriteBatch batch, boolean visible) {
        super(texture, locationX, locationY);
        enableDrawSprite(visible);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

    public boolean isEnbaled() {
        return enbaled;
    }

    public void setEnbaled(boolean enbaled) {
        this.enbaled = enbaled;

    }
}
