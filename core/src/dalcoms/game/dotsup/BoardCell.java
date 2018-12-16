package dalcoms.game.dotsup;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BoardCell extends GameObject {
    public BoardCell(Texture texture, float locationX, float locationY) {
        super(texture, locationX, locationY);
    }

    public BoardCell(Texture texture, float locationX, float locationY, boolean isShow) {
        super(texture, locationX, locationY, isShow);
    }
    public BoardCell setSpriteBatch(SpriteBatch batch){
        super.setSpriteBatch(batch);
        return this;
    }
}
