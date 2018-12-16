package dalcoms.game.dotsup;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameObject implements Renderable {
    private int width, height;
    private float locationX, locationY;
    private Texture texture;
    //    private boolean flag_show = false;
    public SpriteBatch batch;

    private boolean flag_moveX, flag_moveY = false;
    private boolean flag_drawTexture = false;
    private float velocityMoveX, velocityMoveY = 0f;
    private float toX, toY = 0f;

    private ObjectActionListener actionListener;


    public GameObject(Texture texture, float locationX, float locationY) {
        this.texture = texture;
        this.width = texture.getWidth();
        this.height = texture.getHeight();
        this.locationX = locationX;
        this.locationY = locationY;
    }

    public GameObject(Texture texture, float locationX, float locationY, boolean isShow) {
        this.texture = texture;
        this.width = texture.getWidth();
        this.height = texture.getHeight();
        this.locationX = locationX;
        this.locationY = locationY;

        setShow(isShow);
    }

    public GameObject(int width, int height, float locationX, float locationY) {
        this.width = width;
        this.height = height;
        this.locationX = locationX;
        this.locationY = locationY;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public Texture getTexture() {
        return this.texture;
    }

    public GameObject setSpriteBatch(SpriteBatch batch) {
        this.batch = batch;
        return this;
    }

    public GameObject enableDrawTexture(boolean enable) {
        flag_drawTexture = enable;
        return this;
    }


    @Override
    public void render(float delta) {
        updateMovingLocation(delta);
        if (isDrawTexture()) {
            drawTexture();
        }
    }

    private void drawTexture() {
        this.batch.draw(getTexture(), getLocationX(), getLocationY());
    }

    public boolean isDrawTexture() {
        return flag_drawTexture;
    }

    private void updateMovingLocation(float delta) {
        if (isMoveX()) {
            setMoveX(checkMoveX(delta));
        }
        if (isMoveY()) {
            setMoveY(checkMoveY(delta));
        }
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return this.height;
    }

    public void setCenterLocation(float locationX, float locationY) {
        setLocation(locationX - getWidth() / 2, locationY - getHeight() / 2);
    }

    public void setLocation(float locationX, float locationY) {
        setLocationX(locationX);
        setLocationY(locationY);
    }

    public void setLocationX(float locationX) {
        this.locationX = locationX;
    }

    public float getLocationX() {
        return this.locationX;
    }

    public void setLocationY(float locationY) {
        this.locationY = locationY;
    }

    public float getLocationY() {
        return this.locationY;
    }

    public float getCenterX() {
        return getLocationX() + (float) getWidth() / 2;
    }

    public float getCenterY() {
        return getLocationY() + (float) getHeight() / 2;
    }

    public Position2D getLocation() {
        return new Position2D(getLocationX(), getLocationY());
    }

    public Position2D getCenterLocation() {
        return new Position2D(getCenterX(), getCenterY());
    }

    public void setShow(boolean flag_show) {
        enableDrawTexture(flag_show);
    }


    public boolean checkMoveX(float delta) {
        boolean ret = true;
        float toLocation;

        toLocation = getLocationX() + delta * getVelocityMoveX();
        if (getVelocityMoveX() > 0) {
            if (toLocation >= getToX()) {
                toLocation = getToX();
                ret = false;
                if (actionListener != null) {
                    actionListener.onMoveCompleted(ObjectActionListener.DIR_X);
                }
            }
        } else {
            if (toLocation <= getToX()) {
                toLocation = getToX();
                ret = false;
                if (actionListener != null) {
                    actionListener.onMoveCompleted(ObjectActionListener.DIR_X);
                }
            }
        }
        setLocationX(toLocation);

        return ret;
    }

    public boolean checkMoveY(float delta) {
        boolean ret = true;
        float toLocation;

        toLocation = getLocationY() + delta * getVelocityMoveY();
        if (getVelocityMoveY() > 0) {
            if (toLocation >= getToY()) {
                toLocation = getToY();
                ret = false;
                if (actionListener != null) {
                    actionListener.onMoveCompleted(ObjectActionListener.DIR_Y);
                }
            }
        } else {
            if (toLocation <= getToY()) {
                toLocation = getToY();
                ret = false;
                if (actionListener != null) {
                    actionListener.onMoveCompleted(ObjectActionListener.DIR_Y);
                }
            }
        }
        setLocationY(toLocation);

        return ret;
    }

    public void moveX(float fromX, float toX, float duration) {
        setMoveX(true);
        setVelocityMoveX((toX - fromX) / duration);
        setLocationX(fromX);
        this.toX = toX;
        if (actionListener != null) {
            actionListener.onMoveStarted(ObjectActionListener.DIR_X);
        }
    }

    public void moveY(float fromY, float toY, float duration) {
        setMoveY(true);
        setVelocityMoveY((toY - fromY) / duration);
        setLocationY(fromY);
        this.toY = toY;
        if (actionListener != null) {
            actionListener.onMoveStarted(ObjectActionListener.DIR_Y);
        }
    }


    public float getVelocityMoveX() {
        return this.velocityMoveX;
    }

    public void setVelocityMoveX(float vel) {
        this.velocityMoveX = vel;
    }

    public float getVelocityMoveY() {
        return this.velocityMoveY;
    }

    public void setVelocityMoveY(float vel) {
        this.velocityMoveY = vel;
    }

    public boolean isMoveX() {
        return flag_moveX;
    }

    public boolean isMoveY() {
        return flag_moveY;
    }

    public void setMoveX(boolean flag_move) {
        this.flag_moveX = flag_move;
    }

    public void setMoveY(boolean flag_move) {
        this.flag_moveY = flag_move;
    }

    public float getToX() {
        return this.toX;
    }

    public float getToY() {
        return this.toY;
    }


    public void addActionListener(ObjectActionListener listener) {
        actionListener = listener;
    }

}
