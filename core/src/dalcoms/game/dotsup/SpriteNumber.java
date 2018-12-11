package dalcoms.game.dotsup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class SpriteNumber extends TextureNumber {
    Array<Sprite> spriteNumber;

    public SpriteNumber(Array<Texture> textureArrayOfNumbers) {
        super(textureArrayOfNumbers);
        initThis();
    }

    public SpriteNumber(Array<Texture> textureArrayOfNumbers, int number) {
        super(textureArrayOfNumbers, number);
        initThis();
    }

    public SpriteNumber(Array<Texture> textureArrayOfNumbers, int number, SpriteBatch batch) {
        super(textureArrayOfNumbers, number);
        initThis();
        this.setSpriteBatch(batch);
    }

    private void initThis() {
        spriteNumber = new Array<Sprite>();
        setSpriteNumber();
    }

    @Override
    public void setNumber(int number) {
        super.setNumber(number);
        this.setSpriteNumber();
    }

    private void setSpriteNumber() {
        if (spriteNumber == null) {
            spriteNumber = new Array<Sprite>();
        } else {
            spriteNumber.clear();
        }

        for (TexturePositon2D digitTexture : this.getTextureNumber()) {
            Sprite tempSprite = new Sprite(digitTexture.getTexture());
            tempSprite.setPosition(digitTexture.getX(), digitTexture.getY());

//            Gdx.app.log("setSpriteNumber", String.valueOf(digitTexture.getX()) + ", y =" +
//                    String.valueOf(digitTexture.getY()));
            spriteNumber.add(tempSprite);
        }
    }

    public Array<Sprite> getSpriteNumber() {
        return spriteNumber;
    }

    public void setColor(Color color) {
        for (Sprite sprite : spriteNumber) {
            sprite.setColor(color);
        }
    }

    @Override
    public void setOrigin(Position2D origin, boolean updatePosition) {
        super.setOrigin(origin, updatePosition);
        if (updatePosition) {
            for (int i = 0; i < getSpriteNumber().size; i++) {
                getSpriteNumber().get(i)
                        .setPosition(
                                getTextureNumber().get(i).getX(),
                                getTextureNumber().get(i).getY());
            }
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        draw(delta);
    }

    private void draw(float delta) {
        if (getSpriteBatch() != null) {
            for (Sprite sprite : spriteNumber) {
                sprite.draw(getSpriteBatch());
            }
        } else {
            Gdx.app.log("SpriteNumber", "SpriteBatch is not initialized");
        }
    }

    public float getSpriteNumWidth() {
        final float startX = getSpriteNumber().get(0).getX();
        final float endX = getSpriteNumber().get(getSpriteNumber().size - 1).getX()
                + getSpriteNumber().get(getSpriteNumber().size - 1).getWidth();

        return endX - startX;
    }
}
