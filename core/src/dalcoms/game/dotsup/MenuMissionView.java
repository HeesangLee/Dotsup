package dalcoms.game.dotsup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class MenuMissionView implements Renderable {
    private Array<Texture> textureDots;
    private Array<Texture> textureNumbers;
    Texture texture_t35_x;
    Position2D location;
    private boolean show = false;

    Array<TexturePositon2D> textureMissions;
    Array<Position2D> positionRef;

    SpriteBatch batch;


    public MenuMissionView(Array<Texture> textureDots, Array<Texture> textureNumbers,
                           Texture texture_t35_x, float locationX, float locationY, boolean show,
                           SpriteBatch batch) {
        this.batch = batch;
        this.textureDots = textureDots;
        this.textureNumbers = textureNumbers;
        this.texture_t35_x = texture_t35_x;
        this.location = new Position2D(locationX, locationY);
        this.show = show;
        textureMissions = new Array<TexturePositon2D>();

        calcReferencePositons();
    }

    private void calcReferencePositons() {// 그냥 상수를 넣어 버리자.
        final float dotsWidth = this.textureDots.get(0).getWidth();
        //mission / count....
        positionRef = new Array<Position2D>();

        positionRef.add(new Position2D(0, 120f));//mission1
        positionRef.add(new Position2D(111f, 137f));//count1

        positionRef.add(new Position2D(292f, 120f));//mission2
        positionRef.add(new Position2D(111f + 292f, 137f));//count2

        positionRef.add(new Position2D(0, 0));//mission3
        positionRef.add(new Position2D(111f, 17f));//count3

        positionRef.add(new Position2D(292f, 0));//mission4
        positionRef.add(new Position2D(111f + 292f, 17f));//count4

    }

    public MenuMissionView setMission(Array<MissionDots> mission) {
//        this.mission = mission;
        int positionIndex = 0;
        final int MAX_MISSION_COUNT = 4;

        if (textureMissions != null) {
            textureMissions.clear();
        } else {
            textureMissions = new Array<TexturePositon2D>();
        }

        for (MissionDots missionDots : mission) {
            textureMissions.add(new TexturePositon2D(getTextureDot(missionDots.getMissionDots())
                    , positionRef.get(positionIndex++)));
            textureMissions.add(new TexturePositon2D(getTexture_t35_x()
                    , positionRef.get(positionIndex)));
            textureMissions.add(new TexturePositon2D(getTextureNumber(missionDots.getMissionCount())
                    , positionRef.get(positionIndex).getX() + 45f, positionRef.get(positionIndex++).getY()));

            if (positionIndex >= MAX_MISSION_COUNT * 2) {
                Gdx.app.log(this.getClass().getSimpleName() + "setMission",
                        "num of mission is over" + String.valueOf(MAX_MISSION_COUNT));
                break;
            }
        }


        return this;
    }

    @Override
    public void render(float delta) {
        if (isShow()) {
            draw(delta);
        }
    }

    private void draw(float delta) {
        for (TexturePositon2D texturePositon2D : textureMissions) {
            this.batch.draw(texturePositon2D.getTexture()
                    , getLocation().getX() + texturePositon2D.getX()
                    , getLocation().getY() + texturePositon2D.getY());
        }
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }

    private Array<Texture> getTextureDots() {
        return textureDots;
    }

    private Texture getTextureDot(int dotNum) {
        final int MIN_DOT = 1;
        final int MAX_DOT = 9;
        if ((dotNum < 1) | (dotNum > MAX_DOT)) {
            Gdx.app.log(this.getClass().getSimpleName() + "getTextureDot(int dotNum",
                    "dotNum is out of range");
            return null;
        } else {
            return getTextureDots().get(dotNum - 1);
        }
    }

    private Texture getTexture_t35_x() {
        return texture_t35_x;
    }

    private Array<Texture> getTextureNumbers() {
        return textureNumbers;
    }

    private Texture getTextureNumber(int num) {
        if ((num > -1) & (num < 9)) {
            return getTextureNumbers().get(num);
        } else {
            Gdx.app.log(this.getClass().getSimpleName() + "getTextureNumber(int num",
                    "num is out of range");
            return null;
        }
    }

    public Position2D getLocation() {
        return location;
    }

    public void setLocation(Position2D location) {
        this.location = location;
    }
}
