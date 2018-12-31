package dalcoms.game.dotsup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class SpriteNumber implements Renderable {
    private SpriteBatch batch;
    Array<Texture> textureArrayOfNumbers;
    Array<Sprite> spriteNumber;

    private int number = -1;
    private float gap = 7.7f;
    private Position2D origin = new Position2D(0, 0);
    private boolean show = false;

    private GameObject positionLeadingObject;
    private boolean followPositionLeadingObject;


    public SpriteNumber(Array<Texture> textureArrayOfNumbers, int number, SpriteBatch batch) {
        spriteNumber = new Array<Sprite>();
        this.textureArrayOfNumbers = textureArrayOfNumbers;
        this.setSpriteBatch(batch);
        this.setNumber(number);
        this.show = true;
    }

    public SpriteNumber(Array<Texture> textureArrayOfNumbers, int number, SpriteBatch batch, boolean show) {
        spriteNumber = new Array<Sprite>();
        this.textureArrayOfNumbers = textureArrayOfNumbers;
        this.setSpriteBatch(batch);
        this.setNumber(number);
        this.show = show;
    }

    public SpriteNumber setSpriteBatch(SpriteBatch batch) {
        this.batch = batch;
        return this;
    }


    public void setNumber(int number) {
        if (getNumber() != number) {
            this.number = number;
            this.setSpriteNumber(number);
        }
    }

    public int getNumber() {
        return number;
    }

    private void setSpriteNumber(int number) {
        char[] charNum = String.valueOf(number).toCharArray();
        int digitNum;
        float positionX = getOrigin().getX();

        if (spriteNumber == null) {
            spriteNumber = new Array<Sprite>();
        } else {
            spriteNumber.clear();
        }

        for (int i = 0; i < charNum.length; i++) {
            digitNum = Character.getNumericValue(charNum[i]);

            Sprite tempSprite = new Sprite(textureArrayOfNumbers.get(digitNum));
            tempSprite.setPosition(positionX, getOrigin().getY());

            spriteNumber.add(tempSprite);
            positionX += (float) textureArrayOfNumbers.get(digitNum).getWidth() + getGap();
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
    public void render(float delta) {
        if (isShow()) {
            draw(delta);
        }
    }

    private void draw(float delta) {
        try {
            if (isFollowPositionLeadingObject() && getPositionLeadingObject() != null) {
                float width = 0;
                for (Sprite sprite : spriteNumber) {
                    sprite.setPosition(getOrigin().getX() + width
                                    + getPositionLeadingObject().getLocationX(),
                            getOrigin().getY() + getPositionLeadingObject().getLocationY());
                    sprite.draw(getSpriteBatch());
                    width += sprite.getWidth() + getGap();
                }
            } else {
                for (Sprite sprite : spriteNumber) {
                    sprite.draw(getSpriteBatch());
                }
            }
        } catch (Exception e) {
            Gdx.app.log("SpriteNumber.java", e.getMessage());
        }
    }

    public float getSpriteNumWidth() {
        final float startX = getSpriteNumber().get(0).getX();
        final float endX = getSpriteNumber().get(getSpriteNumber().size - 1).getX()
                + getSpriteNumber().get(getSpriteNumber().size - 1).getWidth();

        return endX - startX;
    }

    public float getRightEdgeX() {
        final float endX = getSpriteNumber().get(getSpriteNumber().size - 1).getX()
                + getSpriteNumber().get(getSpriteNumber().size - 1).getWidth();
        return endX;
    }

    public float getGap() {
        return gap;
    }

    public void setGap(float gap) {
        this.gap = gap;
    }

    public Position2D getOrigin() {
        return origin;
    }

    public void setOrigin(Position2D origin) {
        if (this.origin.getPosition() != origin.getPosition()) {
            final float diff_x = origin.getX() - getOrigin().getX();
            final float diff_y = origin.getY() - getOrigin().getY();

            for (Sprite sprite : getSpriteNumber()) {
                sprite.setPosition(sprite.getX() + diff_x,
                        sprite.getY() + diff_y);
            }
        }
        this.origin = origin;
    }

    public SpriteBatch getSpriteBatch() {
        return batch;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    public GameObject getPositionLeadingObject() {
        return positionLeadingObject;
    }

    public void setPositionLeadingObject(GameObject positionLeadingObject) {
        this.positionLeadingObject = positionLeadingObject;
    }

    public void setPositionLeadingObject(GameObject positionLeadingObject, boolean enable) {
        this.positionLeadingObject = positionLeadingObject;
        setFollowPositionLeadingObject(enable);
    }

    public boolean isFollowPositionLeadingObject() {
        return followPositionLeadingObject;
    }

    public void setFollowPositionLeadingObject(boolean followPositionLeadingObject) {
        this.followPositionLeadingObject = followPositionLeadingObject;
    }
}
