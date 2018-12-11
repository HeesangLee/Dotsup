package dalcoms.game.dotsup;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SpritePosition2D extends Position2D {
    Sprite sprite;

    public SpritePosition2D(Texture texture, float x, float y) {
        super(x, y);
        this.sprite = new Sprite(texture);
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
}