package dalcoms.game.dotsup;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameObject implements Renderable {
    private int width, height;
    private float locationX, locationY;
    private Texture texture;
    public SpriteBatch batch;

    private boolean flag_moveX, flag_moveY = false;
    private boolean flag_drawTexture = false;
    private float velocityMoveX, velocityMoveY = 0f;
    private float toX, toY = 0f;

    private ObjectActionListener actionListener;
    private GameObject positionLeadingObject;
    private boolean followPositionLeadingObject;
    private int id = -1;
    private String tag = "";

    private boolean stateBoolean = false;
    private int stateInt = -1;
    private float stateFloat = -1f;


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
        this.width = texture.getWidth();
        this.height = texture.getHeight();
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
        if (isFollowPositionLeadingObject() && getPositionLeadingObject() != null) {
            this.batch.draw(getTexture(),
                    getLocationX() + getPositionLeadingObject().getLocationX(),
                    getLocationY() + getPositionLeadingObject().getLocationY());
        } else {
            this.batch.draw(getTexture(), getLocationX(), getLocationY());
        }

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

    public float getLocationFollowingLeaderX() {

        if (isFollowPositionLeadingObject() && getPositionLeadingObject() != null) {
            return getLocationX() + getPositionLeadingObject().getLocationX();
        } else {
            return getLocationX();
        }
    }

    public float getLocationFollowingLeaderY() {

        if (isFollowPositionLeadingObject() && getPositionLeadingObject() != null) {
            return getLocationY() + getPositionLeadingObject().getLocationY();
        } else {
            return getLocationY();
        }
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
            }
        } else {
            if (toLocation <= getToX()) {
                toLocation = getToX();
                ret = false;
            }
        }
        setLocationX(toLocation);

        if (!ret & actionListener != null) {
            actionListener.onMoveCompleted(ObjectActionListener.DIR_X);
        }

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
            }
        } else {
            if (toLocation <= getToY()) {
                toLocation = getToY();
                ret = false;
            }
        }
        setLocationY(toLocation);

        if (!ret & actionListener != null) {
            actionListener.onMoveCompleted(ObjectActionListener.DIR_Y);
        }

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

    public boolean isStateBoolean() {
        return stateBoolean;
    }

    public void setStateBoolean(boolean stateBoolean) {
        this.stateBoolean = stateBoolean;
    }

    public int getStateInt() {
        return stateInt;
    }

    public void setStateInt(int stateInt) {
        this.stateInt = stateInt;
    }

    public float getStateFloat() {
        return stateFloat;
    }

    public void setStateFloat(float stateFloat) {
        this.stateFloat = stateFloat;
    }
}
