package dalcoms.game.dotsup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class TextureNumber implements Renderable {
    private SpriteBatch batch;
    private Array<Texture> textureArrayOfNumbers;
    private boolean drawEnabled = false;
    private Array<TexturePositon2D> textureNumber;
    private int number = 0;
    private float gap = 7.7f;
    private Position2D origin = new Position2D(0, 0);

    public TextureNumber(Array<Texture> textureArrayOfNumbers) {
        this.textureArrayOfNumbers = textureArrayOfNumbers;
        textureNumber = new Array<TexturePositon2D>();
    }

    public TextureNumber(Array<Texture> textureArrayOfNumbers, int number) {
        this.textureArrayOfNumbers = textureArrayOfNumbers;
        textureNumber = new Array<TexturePositon2D>();
        this.setNumber(number);
    }

    public TextureNumber setSpriteBatch(SpriteBatch batch) {
        this.batch = batch;
        return this;
    }

    @Override
    public void render(float delta) {
        if (isDrawEnabled()) {
            draw(delta);
        }
    }

    private void draw(float delta) {
        if (batch != null) {
            for (TexturePositon2D digitTexture : textureNumber) {
                this.batch.draw(digitTexture.getTexture(), digitTexture.getX(), digitTexture.getY());
            }
        } else {
            Gdx.app.log("TextureNumber", "SpriteBatch is not initialized");
        }
    }

    public Position2D getOrigin() {
        return origin;
    }

    public void setOrigin(Position2D origin) {
        this.origin = origin;
    }

    public void setOrigin(Position2D origin, boolean updatePosition) {
        this.origin = origin;

        if (updatePosition) {
            for (TexturePositon2D texturePositon2D : textureNumber) {
                texturePositon2D.setX(texturePositon2D.getX() + origin.getX());
                texturePositon2D.setY(texturePositon2D.getY() + origin.getY());
            }
        }
    }

    public boolean isDrawEnabled() {
        return drawEnabled;
    }

    public void setDrawEnabled(boolean drawEnabled) {
        this.drawEnabled = drawEnabled;
    }

    public Array<TexturePositon2D> getTextureNumber() {
        return textureNumber;
    }

    private void setTextureNumber(int num) {
        char[] charNum = String.valueOf(num).toCharArray();
        int digitNum;
        float positionX = getOrigin().getX();

        textureNumber.clear();

        for (int i = 0; i < charNum.length; i++) {
            digitNum = Character.getNumericValue(charNum[i]);

            textureNumber.add(new TexturePositon2D(textureArrayOfNumbers.get(digitNum),
                    positionX, getOrigin().getY()));
            positionX += (float) textureArrayOfNumbers.get(digitNum).getWidth() + getGap();
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
        setTextureNumber(number);
    }

    public float getGap() {
        return gap;
    }

    public void setGap(float gap) {
        this.gap = gap;
    }

    public SpriteBatch getSpriteBatch() {
        return batch;
    }

}
