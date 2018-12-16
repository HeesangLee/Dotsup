package dalcoms.game.dotsup;

import com.badlogic.gdx.graphics.Texture;

public class TexturePositon2D extends Position2D {
    Texture texture;

    public TexturePositon2D(Texture texture, float x, float y) {
        super(x, y);
        this.texture = texture;
    }

    public TexturePositon2D(Texture texture, Position2D position2D) {
        super(position2D.getX(), position2D.getY());
        this.texture = texture;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }
}
