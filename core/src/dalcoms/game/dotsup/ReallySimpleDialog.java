package dalcoms.game.dotsup;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class ReallySimpleDialog extends GameObject
        implements GestureDetectableButton {

    Array<GameObject> gameObjects;
    Array<SpriteButton> spriteButtons;
    DialogInfoText dialogInfoText;


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
        gameObjects = new Array<GameObject>();
        spriteButtons = new Array<SpriteButton>();

    }


    @Override
    public void render(float delta) {
        super.render(delta);
        for (GameObject gameObject : gameObjects) {
            gameObject.render(delta);
        }
        for (SpriteButton spriteButton : spriteButtons) {
            spriteButton.render(delta);
        }
        if (dialogInfoText != null) {
            dialogInfoText.render(delta);
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
        gameObject.setPositionLeadingObject(this,true);
        gameObjects.add(gameObject);
    }


    public Array<GameObject> getGameObjects() {
        return gameObjects;
    }

    public Array<SpriteButton> getSpriteButtons() {
        return spriteButtons;
    }


    public void addSpriteButton(SpriteButton spriteButton) {
        spriteButton.setPositionLeadingObject(this,true);
//        spriteButton.updateTouchArea();
        this.spriteButtons.add(spriteButton);
    }


    public DialogInfoText getDialogInfoText() {
        return dialogInfoText;
    }

    public void setDialogInfoText(DialogInfoText dialogInfoText) {
        this.dialogInfoText = dialogInfoText;
    }
}