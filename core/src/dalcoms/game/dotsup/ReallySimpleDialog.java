package dalcoms.game.dotsup;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class ReallySimpleDialog extends GameObject
        implements GestureDetectableButton {

    Array<Renderable> renderables;
    Array<SpriteButton> spriteButtons;
    private int id = -1;
    private String tag = "";

    public ReallySimpleDialog(Texture texture, float locationX, float locationY, SpriteBatch batch) {
        super(texture, locationX, locationY);
        setSpriteBatch(batch);
        initThis();
    }

    public ReallySimpleDialog(Texture texture, float locationX, float locationY, boolean isShow, SpriteBatch batch) {
        super(texture, locationX, locationY, isShow);
        setSpriteBatch(batch);
        initThis();
    }

    private void initThis() {
        renderables = new Array<Renderable>();
        spriteButtons = new Array<SpriteButton>();

    }


    @Override
    public void render(float delta) {
        super.render(delta);
        for (Renderable renderable : renderables) {
            renderable.render(delta);
        }
        for (SpriteButton spriteButton : spriteButtons) {
            spriteButton.render(delta);
        }
    }


    @Override
    public void touchDown(float x, float y, int pointer, int button) {
        for (SpriteButton spriteButton : spriteButtons) {
            spriteButton.touchDown(x, y, pointer, button);
        }
    }

    @Override
    public void tap(float x, float y, int count, int button) {
        for (SpriteButton spriteButton : spriteButtons) {
            spriteButton.tap(x, y, count, button);
        }
    }

    @Override
    public void longPress(float x, float y) {
        for (SpriteButton spriteButton : spriteButtons) {
            spriteButton.longPress(x, y);
        }
    }

    @Override
    public void fling(float velocityX, float velocityY, int button) {
        for (SpriteButton spriteButton : spriteButtons) {
            spriteButton.fling(velocityX, velocityY, button);
        }
    }

    public void addGameObject(GameObject gameObject) {
        gameObject.setPositionLeadingObject(this, true);
        renderables.add(gameObject);
    }

    public void addSpriteGameObject(SpriteGameObject spriteGameObject) {
        spriteGameObject.setPositionLeadingObject(this, true);
        renderables.add(spriteGameObject);
    }

    public void addSpriteNumber(SpriteNumber spriteNumber) {
        spriteNumber.setPositionLeadingObject(this, true);
        renderables.add(spriteNumber);
    }

    public Array<Renderable> getRenderables() {
        return renderables;
    }

    public Array<SpriteButton> getSpriteButtons() {
        return spriteButtons;
    }


    public void addSpriteButton(SpriteButton spriteButton) {
        spriteButton.setPositionLeadingObject(this, true);
        this.spriteButtons.add(spriteButton);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}