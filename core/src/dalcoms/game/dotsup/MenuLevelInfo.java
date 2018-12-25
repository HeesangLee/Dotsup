package dalcoms.game.dotsup;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import java.util.Map;

public class MenuLevelInfo implements Renderable {
    private Array<Texture> textureNumbers;
    private Texture texture_t35_s;
    private Texture texture_t35_m;
    private Texture texture_t19_time;
    private Texture texture_t19_moves;
    private Texture texture_t52_cleared;
    private Texture texture_t52_locked;
    private Texture texture_t52_new;

    private boolean show = false;

    SpriteBatch batch;

    public static final String KEY_S = "s";
    public static final String KEY_M = "m";
    public static final String KEY_TIME = "time";
    public static final String KEY_MOVES = "moves";
    public static final String KEY_CLEARED = "cleared";
    public static final String KEY_LOCKED = "locked";
    public static final String KEY_NEW = "new";

    public static final int LEVEL_NEW = 0;
    public static final int LEVEL_CLEARED = 1;
    public static final int LEVEL_LOCKED = 2;

    private Array<TexturePositon2D> drawTextures;


    public MenuLevelInfo(Array<Texture> textureNumbers, Map<String, Texture> infoTextures
            , boolean show, SpriteBatch batch) {
        this.batch = batch;
        this.textureNumbers = textureNumbers;
        this.texture_t35_s = infoTextures.get(KEY_S);
        this.texture_t35_m = infoTextures.get(KEY_M);
        this.texture_t19_time = infoTextures.get(KEY_TIME);
        this.texture_t19_moves = infoTextures.get(KEY_MOVES);
        this.texture_t52_cleared = infoTextures.get(KEY_CLEARED);
        this.texture_t52_locked = infoTextures.get(KEY_LOCKED);
        this.texture_t52_new = infoTextures.get(KEY_NEW);

        this.show = show;
        drawTextures = new Array<TexturePositon2D>();
    }

    @Override
    public void render(float delta) {
        if (isShow()) {
            draw(delta);
        }
    }

    private void draw(float delta) {
        for (TexturePositon2D texturePositon2D : drawTextures) {
            this.batch.draw(texturePositon2D.getTexture()
                    , texturePositon2D.getX(), texturePositon2D.getY());
        }
    }

    public void setInfo(int levelStatus,int moves, long time) {
        if (drawTextures == null) {
            drawTextures = new Array<TexturePositon2D>();
        } else {
            drawTextures.clear();
        }

        drawTextures.add(new TexturePositon2D(getLevelStatusTexture(levelStatus)
                , 110f, 156f));
    }

    private Texture getLevelStatusTexture(int levelStatus) {
        Texture textureLevelStatus;
        switch (levelStatus) {
            case LEVEL_NEW:
                textureLevelStatus = this.getTexture_t52_new();
                break;
            case LEVEL_CLEARED:
                textureLevelStatus = this.getTexture_t52_cleared();
                break;
            case LEVEL_LOCKED:
                textureLevelStatus = this.getTexture_t52_locked();
                break;
            default:
                textureLevelStatus = this.getTexture_t52_new();
                break;
        }
        return textureLevelStatus;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    private Array<Texture> getTextureNumbers() {
        return textureNumbers;
    }

    private Texture getTexture_t35_s() {
        return texture_t35_s;
    }

    private Texture getTexture_t35_m() {
        return texture_t35_m;
    }

    private Texture getTexture_t19_time() {
        return texture_t19_time;
    }

    private Texture getTexture_t19_moves() {
        return texture_t19_moves;
    }

    private Texture getTexture_t52_cleared() {
        return texture_t52_cleared;
    }

    private Texture getTexture_t52_locked() {
        return texture_t52_locked;
    }

    private Texture getTexture_t52_new() {
        return texture_t52_new;
    }
}
