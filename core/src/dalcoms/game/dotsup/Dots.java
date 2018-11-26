package dalcoms.game.dotsup;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class Dots extends SpriteGameObject {

    Array<Texture> texture_dotsArray;
    private int dotsNum = 0;

    /*
     *@param defaultDotsNum range 1~9
     */
    public Dots(Array<Texture> dots_texture, float locationX, float locationY, int defaultDotsNum) {
        super(dots_texture.get(defaultDotsNum-1), locationX, locationY);

        this.texture_dotsArray = dots_texture;
        this.enableDrawSprite(true); //enable to draw sprite as default.

        dotsNum = defaultDotsNum;
    }

    public Dots setSpriteBatch(SpriteBatch batch) {
        super.setSpriteBatch(batch);
        return this;
    }


    @Override
    public void render(float delta) {
        super.render(delta);
    }

    /*
     *@param dotsNum range 1~9
     */
    public void setDotsNum(int dotsNum) {
        this.dotsNum = dotsNum;
        getSprite().setTexture(this.texture_dotsArray.get(dotsNum - 1));
    }

    public int getDotsNum() {
        return this.dotsNum;
    }


}
