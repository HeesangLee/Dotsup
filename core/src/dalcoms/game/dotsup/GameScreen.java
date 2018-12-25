package dalcoms.game.dotsup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class GameScreen implements Screen {

    final Dotsup game;
    OrthographicCamera camera;
    private SpriteBatch batch;
    private Array<Renderable> renderableObjectArray;
    private Array<GestureDetectableButton> gestureDetectableButtonArray;

    private SpriteButton homeButton;
    private boolean dialogShow = false;
    private ReallySimpleDialog dialog;
    private TopDisplayPanel topDisplayPanel;
    protected int gameLevel;
    private MissionPanel missionPanel;

    public GameScreen(final Dotsup game, int gameLevel) {
        this.game = game;
        this.camera = new OrthographicCamera();
        this.batch = game.getSpriteBatch();
        camera.setToOrtho(false, game.getGameConfiguration().getViewportWidth(),
                game.getGameConfiguration().getViewportHeight());
        this.gameLevel = gameLevel;
        Gdx.input.setCatchBackKey(true);
    }

    private void initGameObjects() {
        renderableObjectArray.add(new GameObject(game.getResourcesManager().getTexture_game_bottom(),
                0, 0, true).setSpriteBatch(batch));

        createHomeButton(-34f, 1744f);
        createDisplayPanel(183f, 1723f);
        createMissionPanel(1540f);
    }

    private void createMissionPanel(float locationY) {
        missionPanel = new MissionPanel(locationY);
        renderableObjectArray.add(missionPanel);
    }

    private void createDisplayPanel(float x, float y) {
        this.topDisplayPanel = new TopDisplayPanel(this.gameLevel, x, y);
        renderableObjectArray.add(topDisplayPanel);
    }

    private void createHomeButton(float x, float y) {
        this.homeButton = new SpriteButton(game.getResourcesManager().getTexture_circle_200x200(),
                x, y, batch) {
            @Override
            public void actionTap() {
                super.actionTap();
                popUpAskGotoHomeScreen();
            }

            @Override
            public void actionLongPress() {
                super.actionLongPress();
                popUpAskGotoHomeScreen();
            }
        };
        homeButton.setTopTexture(game.getResourcesManager().getTexture_game_home_btn());
        homeButton.setColorEffect(true,
                GameColor.GAME_HOME_BUTTON_EN_NORMAL, GameColor.GAME_HOME_BUTTON_EN_TOUCHDOWN,
                GameColor.GAME_HOME_BUTTON_DIS_NORMAL, GameColor.GAME_HOME_BUTTON_DIS_TOUCHDOWN);

        renderableObjectArray.add(homeButton);
        gestureDetectableButtonArray.addAll(homeButton);

    }

    private void popUpAskGotoHomeScreen() {
        popUpBackKeyDialog();
    }

    private void gotoMenuScreen() {
        game.setScreen(new MenuScreen(game));

    }

    private void popUpBackKeyDialog() {

        if (isDialogShow() & (getDialog() != null)) {
            killDialog();
        } else {
            setDialogShow(true);
            ReallySimpleDialog dialog = new ReallySimpleDialog(game.getResourcesManager().getTexture_dialog_847x406()
                    , 0, 0, true, batch);
            dialog.setCenterLocation(game.getGameConfiguration().getViewportWidth() / 2f
                    , game.getGameConfiguration().getViewportHeight() / 2f);
            dialog.addGameObject(new GameObject(game.getResourcesManager().getTexture_text_ask_exit()
                    , 94f, 271f, true)
                    .setSpriteBatch(batch));

            final SpriteButton goHomeButton = new SpriteButton(game.getResourcesManager().getTexture_button_302x105()
                    , 94f, 105f, batch) {
                @Override
                public void actionTap() {
                    super.actionTap();
                    gotoMenuScreen();

                }
            };
            goHomeButton.setTopTexture(game.getResourcesManager().getTexture_btn_text_home());
            goHomeButton.enableDrawSprite(true);
            goHomeButton.setColorEffect(true,
                    GameColor.BUTTON_BLUE_NORMAL, GameColor.BUTTON_BLUE_TOUCHDOWN,
                    GameColor.MEMU_START_BUTTON_DIS_NORMAL, GameColor.MEMU_START_BUTTON_DIS_TOUCHDOWN);

            final SpriteButton stayButton = new SpriteButton(game.getResourcesManager().getTexture_button_302x105()
                    , 452f, 105f, batch) {
                @Override
                public void actionTap() {
                    super.actionTap();
                    killDialog();
                }
            };
            stayButton.setTopTexture(game.getResourcesManager().getTexture_btn_text_stay());
            stayButton.enableDrawSprite(true);
            stayButton.setColorEffect(true,
                    GameColor.BUTTON_PINK_NORMAL, GameColor.BUTTON_PINK_TOUCHDOWN,
                    GameColor.MEMU_START_BUTTON_DIS_NORMAL, GameColor.MEMU_START_BUTTON_DIS_TOUCHDOWN);


            dialog.addSpriteButton(goHomeButton);
            dialog.addSpriteButton(stayButton);


            dialog.moveY(game.getGameConfiguration().getViewportHeight(),
                    dialog.getLocationY(), 0.2f);

            dialog.addActionListener(new ObjectActionListener() {
                @Override
                public boolean onMoveCompleted(boolean direction) {
                    goHomeButton.updateTouchArea();
                    stayButton.updateTouchArea();
                    return false;
                }

                @Override
                public boolean onMoveStarted(boolean direction) {
                    return false;
                }
            });

            setDialog(dialog);

        }

    }

    private void setInputProcessor() {

        InputMultiplexer inputMultiplexer = new InputMultiplexer();

        inputMultiplexer.addProcessor(new GestureDetector(new GameGestureListener() {
            @Override
            public boolean touchDown(float x, float y, int pointer, int button) {
                if (isDialogShow() & (getDialog() != null)) {
                    getDialog().touchDown(x, y, pointer, button);
                } else {
                    for (GestureDetectableButton btn : gestureDetectableButtonArray) {
                        btn.touchDown(x, y, pointer, button);
                    }
                }

                return super.touchDown(x, y, pointer, button);
            }

            @Override
            public boolean tap(float x, float y, int count, int button) {
                if (isDialogShow() & (getDialog() != null)) {
                    getDialog().tap(x, y, count, button);
                } else {
                    for (GestureDetectableButton btn : gestureDetectableButtonArray) {
                        btn.tap(x, y, count, button);
                    }
                }
                return super.tap(x, y, count, button);
            }

            @Override
            public boolean longPress(float x, float y) {

                if (isDialogShow() & (getDialog() != null)) {
                    getDialog().longPress(x, y);
                } else {
                    for (GestureDetectableButton btn : gestureDetectableButtonArray) {
                        btn.longPress(x, y);
                    }
                }
                return super.longPress(x, y);
            }

            @Override
            public boolean fling(float velocityX, float velocityY, int button) {
                for (GestureDetectableButton btn : gestureDetectableButtonArray) {
                    btn.fling(velocityX, velocityY, button);
                }
                return super.fling(velocityX, velocityY, button);
            }

            @Override
            public boolean pan(float x, float y, float deltaX, float deltaY) {
                return super.pan(x, y, deltaX, deltaY);
            }

            @Override
            public boolean panStop(float x, float y, int pointer, int button) {
                return super.panStop(x, y, pointer, button);
            }

            @Override
            public boolean zoom(float initialDistance, float distance) {
                return super.zoom(initialDistance, distance);
            }

            @Override
            public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
                return super.pinch(initialPointer1, initialPointer2, pointer1, pointer2);
            }

            @Override
            public void pinchStop() {
                super.pinchStop();
            }
        }));

        inputMultiplexer.addProcessor(new InputProcessor() {
            @Override
            public boolean keyDown(int keycode) {
                if (keycode == Input.Keys.BACK) {
                    popUpBackKeyDialog();
                    return true;
                }
                return false;
            }

            @Override
            public boolean keyUp(int keycode) {
                return false;
            }

            @Override
            public boolean keyTyped(char character) {
                return false;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                return false;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                return false;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                return false;
            }

            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                return false;
            }

            @Override
            public boolean scrolled(int amount) {
                return false;
            }
        });

        Gdx.input.setInputProcessor(inputMultiplexer);

    }

    public boolean isDialogShow() {
        return dialogShow;
    }

    public void setDialogShow(boolean dialogShow) {
        this.dialogShow = dialogShow;
    }

    public ReallySimpleDialog getDialog() {
        return dialog;
    }

    public void setDialog(ReallySimpleDialog dialog) {
        this.dialog = dialog;
    }

    private void killDialog() {
        setDialogShow(false);
        this.dialog = null;
    }


    private void draw(float delta) {
        Gdx.gl.glClearColor(7 / 255f, 38 / 255f, 59 / 255f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.getSpriteBatch().setProjectionMatrix(camera.combined);
        game.getSpriteBatch().begin();


        for (Renderable renderableObj : renderableObjectArray) {
            renderableObj.render(delta);
        }
        if (isDialogShow() & getDialog() != null) {
            getDialog().render(delta);
        }

        game.getSpriteBatch().end();
    }

    @Override
    public void show() {
        renderableObjectArray = new Array<Renderable>();
        gestureDetectableButtonArray = new Array<GestureDetectableButton>();

        initGameObjects();
        setInputProcessor();

    }

    @Override
    public void render(float delta) {
        draw(delta);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public class MissionPanel implements Renderable {
        private float locationY;
        private float locationX = 0f;
        private Position2D[] missionDotsPositions;
        private Array<DotsOfMission> dotsOfMissions;


        public MissionPanel(float locationY) {
            this.locationY = locationY;
            dotsOfMissions = new Array<DotsOfMission>();
            initThis();
        }

        private void initThis() {
            calcLocationX();
            calcDotsPositions();
        }

        private void loadMissions() {
            Array<MissionDots> missionDots = GameLevel.getLevel(gameLevel).getMission();
            int index = 0;
            for (MissionDots mission : missionDots) {
                for (int i = 0; i < mission.getMissionCount(); i++) {
                    DotsOfMission dotsMission = new DotsOfMission(
                            game.getResourcesManager().getTexture_menu_dotsArray().get(mission.getMissionDots() - 1),
                            missionDotsPositions[index].getX(), missionDotsPositions[index].getY(),
                            mission.getMissionDots());
                    dotsMission.setSpriteBatch(batch);
                    dotsMission.actionRotate(0, 360, 0.3f);

                    dotsOfMissions.add(dotsMission);
                    index++;
                }
            }
        }

        private void calcLocationX() {
            this.locationX = (game.getGameConfiguration().getViewportWidth()
                    - game.getResourcesManager().getTexture_game_mission_info_bg().getWidth()) / 2f;
        }

        private void calcDotsPositions() {
            final int MISSION_COUNT = 9;
            final float OFFSET_X = 25f;
            final float DOTS_SIZE = (float) game.getResourcesManager().getTexture_rect_90x90().getHeight();

            final float POSITION_Y
                    = ((float) game.getResourcesManager().getTexture_game_mission_info_bg().getHeight()
                    - DOTS_SIZE) / 2f;
            final float DOTS_GAP
                    = (game.getResourcesManager().getTexture_game_mission_info_bg().getWidth()
                    - DOTS_SIZE * MISSION_COUNT - 2 * OFFSET_X) / 8f;

            missionDotsPositions = new Position2D[MISSION_COUNT];

            for (int i = 0; i < MISSION_COUNT; i++) {
                missionDotsPositions[i] = new Position2D(locationX + OFFSET_X + (DOTS_SIZE + DOTS_GAP) * i,
                        locationY + POSITION_Y);
            }

            loadMissions();
        }

        @Override
        public void render(float delta) {
            batch.draw(game.getResourcesManager().getTexture_game_mission_info_bg(), locationX, locationY);

            for (DotsOfMission mission : dotsOfMissions) {
                mission.render(delta);
            }

        }

        public class DotsOfMission extends SpriteGameObject {
            private boolean missionCleared = false;
            private int dotNum;

            public DotsOfMission(Texture texture, float locationX, float locationY, int dotNum) {
                super(texture, locationX, locationY);
                this.dotNum = dotNum;
            }


            public boolean isMissionCleared() {
                return missionCleared;
            }

            public void setMissionCleared(boolean missionCleared) {
                if(this.missionCleared!=missionCleared){
                    actionRotate(0,360,1f);
                }
                this.missionCleared = missionCleared;
            }

            @Override
            public void render(float delta) {
                super.render(delta);
                if (isMissionCleared()) {
                    batch.draw(game.getResourcesManager().getTexture_level_selected_circle(),
                            getCenterX() - game.getResourcesManager().getTexture_level_selected_circle().getWidth() / 2f,
                            getCenterY() - game.getResourcesManager().getTexture_level_selected_circle().getHeight() / 2f);
                }
                getSprite().setPosition(getLocationFollowingLeaderX(), getLocationFollowingLeaderY());
                getSprite().draw(batch);
            }


            public int getDotNum() {
                return dotNum;
            }

            public void setDotNum(int dotNum) {
                this.dotNum = dotNum;
            }
        }
    }

    public class TopDisplayPanel implements Renderable {
        private float locationX, locationY;
        private int gameLevel;
        private Array<Renderable> renderableArray;
        private int gameTimeSec = 0;
        private Array<Integer> alarmTimeSecArray;
        private float gameTimer200msec = 0f;
        private float gameTimer1sec = 0f;

        SpriteNumber gameLevelNumber, movesNumber, timeHourNumber, timeMinNumber, timeSecNumber;
        GameObject levelText, movesText, timeText, timeText_h, timeText_m, timeText_s;
        Array<Sprite> spritesTimeProgress;
        private int timeProgressIndex = 0;

        private int gameMovesNumber = -1;


        public TopDisplayPanel(int gameLevel, float locationX, float locationY) {
            this.gameLevel = gameLevel;
            this.locationX = locationX;
            this.locationY = locationY;

            this.renderableArray = new Array<Renderable>();
            this.alarmTimeSecArray = new Array<Integer>();
            initThis();
        }

        private void initThis() {
            setGameLevel(this.gameLevel);
            initTimeMovesTexts();
            initTimeProgressSprites();
            initTimeSprites();
            initMovesNumSprite();
        }

        public int getGameMovesNumber() {
            return gameMovesNumber;
        }

        public void setGameMovesNumber(int gameMovesNumber) {
            final float RIGHT_ALIGN_X = 542f;
            final float MOVES_ORIGIN_Y = 113f;

            if (getGameMovesNumber() != gameMovesNumber) {
                this.gameMovesNumber = gameMovesNumber;
                movesNumber.setNumber(getGameMovesNumber());
                movesNumber.setOrigin(new Position2D(locationX + RIGHT_ALIGN_X - movesNumber.getSpriteNumWidth(),
                        locationY + MOVES_ORIGIN_Y));
            }

        }

        private void initMovesNumSprite() {
            movesNumber = new SpriteNumber(game.getResourcesManager().getTexture_t35NumArray(), 0, batch, true);
            setGameMovesNumber(0);
            renderableArray.add(movesNumber);
        }

        private void initTimeSprites() {
            timeHourNumber = new SpriteNumber(game.getResourcesManager().getTexture_t35NumArray(), 0, batch, false);
            timeMinNumber = new SpriteNumber(game.getResourcesManager().getTexture_t35NumArray(), 0, batch, false);
            timeSecNumber = new SpriteNumber(game.getResourcesManager().getTexture_t35NumArray(), 0, batch, false);

            timeText_h = new GameObject(game.getResourcesManager().getTexture_t35_h(), 0, 0, false)
                    .setSpriteBatch(batch);
            timeText_m = new GameObject(game.getResourcesManager().getTexture_t35_m(), 0, 0, false)
                    .setSpriteBatch(batch);
            timeText_s = new GameObject(game.getResourcesManager().getTexture_t35_s(), 0, 0, false)
                    .setSpriteBatch(batch);

            renderableArray.add(timeHourNumber);
            renderableArray.add(timeText_h);
            renderableArray.add(timeMinNumber);
            renderableArray.add(timeText_m);
            renderableArray.add(timeSecNumber);
            renderableArray.add(timeText_s);

            upDateTimeNumbers(this.getGameTimeSec());
        }

        private void upDateTimeNumbers(int gameTimeSec) {
            final float TIME_ORIGIN_X = 569f;
            final float TIME_ORIGIN_Y = 47f;

            int hour = 0, min = 0, sec = 0;

            hour = gameTimeSec / 3600;
            min = (gameTimeSec - hour * 3600) / 60;
            sec = gameTimeSec - hour * 360 - min * 60;

            if (hour != 0) {//h:m:s
                timeHourNumber.setNumber(hour);
                timeHourNumber.setOrigin(new Position2D(locationX + TIME_ORIGIN_X, locationY + TIME_ORIGIN_Y));
                timeHourNumber.setShow(true);

                timeText_h.setLocation(timeHourNumber.getRightEdgeX() + timeHourNumber.getGap(),
                        locationY + TIME_ORIGIN_Y);
                timeText_h.setShow(true);

                timeMinNumber.setNumber(min);
                timeMinNumber.setOrigin(new Position2D(timeText_h.getLocationX()
                        + timeText_h.getWidth() + timeHourNumber.getGap(), locationY + TIME_ORIGIN_Y));
                timeMinNumber.setShow(true);

                timeText_m.setLocation(timeMinNumber.getRightEdgeX() + timeMinNumber.getGap(),
                        locationY + TIME_ORIGIN_Y);
                timeText_m.setShow(true);

                timeSecNumber.setNumber(sec);
                timeSecNumber.setOrigin(new Position2D(timeText_m.getLocationX()
                        + timeText_m.getWidth() + timeMinNumber.getGap(), locationY + TIME_ORIGIN_Y));
                timeSecNumber.setShow(true);

                timeText_s.setLocation(timeSecNumber.getRightEdgeX() + timeSecNumber.getGap(),
                        locationY + TIME_ORIGIN_Y);
                timeText_s.setShow(true);
            } else if (min != 0) {//m:s
                timeHourNumber.setShow(false);

                timeMinNumber.setNumber(min);
                timeMinNumber.setOrigin(new Position2D(locationX + TIME_ORIGIN_X, locationY + TIME_ORIGIN_Y));
                timeMinNumber.setShow(true);

                timeText_m.setLocation(timeMinNumber.getRightEdgeX() + timeMinNumber.getGap(),
                        locationY + TIME_ORIGIN_Y);
                timeText_m.setShow(true);

                timeSecNumber.setNumber(sec);
                timeSecNumber.setOrigin(new Position2D(timeText_m.getLocationX()
                        + timeText_m.getWidth() + timeMinNumber.getGap(), locationY + TIME_ORIGIN_Y));
                timeSecNumber.setShow(true);

                timeText_s.setLocation(timeSecNumber.getRightEdgeX() + timeSecNumber.getGap(),
                        locationY + TIME_ORIGIN_Y);
                timeText_s.setShow(true);

            } else {//s
                timeHourNumber.setShow(false);
                timeMinNumber.setShow(false);

                timeSecNumber.setNumber(sec);
                timeSecNumber.setOrigin(new Position2D(locationX + TIME_ORIGIN_X, locationY + TIME_ORIGIN_Y));
                timeSecNumber.setShow(true);

                timeText_s.setLocation(timeSecNumber.getRightEdgeX() + timeSecNumber.getGap(),
                        locationY + TIME_ORIGIN_Y);
                timeText_s.setShow(true);

            }
        }

        private void initTimeProgressSprites() {
            final float TIME_ORIGIN_X = 476f;
            final float TIME_ORIGIN_Y = 47f;
            final float WITH_GAP = 14f;

            spritesTimeProgress = new Array<Sprite>();
            for (int i = 0; i < 5; i++) {
                Sprite sp = new Sprite(game.getResourcesManager().getTexture_rec_10x10());
                sp.setColor(GameColor.GAME_TIME_PROGRESS_OFF);
                sp.setPosition(this.locationX + TIME_ORIGIN_X + WITH_GAP * i,
                        this.locationY + TIME_ORIGIN_Y);
                spritesTimeProgress.add(sp);
            }
        }

        private void initTimeMovesTexts() {
            final float TIME_ORIGIN_X = 476f;
            final float TIME_ORIGIN_Y = 67f;
            final float MOVES_ORIGIN_X = 569f;
            final float MOVES_ORIGIN_Y = 113f;

            timeText = new GameObject(game.getResourcesManager().getTexture_t19_time()
                    , this.locationX + TIME_ORIGIN_X, this.locationY + TIME_ORIGIN_Y
                    , true)
                    .setSpriteBatch(batch);

            movesText = new GameObject(game.getResourcesManager().getTexture_t19_moves()
                    , this.locationX + MOVES_ORIGIN_X, this.locationY + MOVES_ORIGIN_Y
                    , true)
                    .setSpriteBatch(batch);

            renderableArray.add(timeText);
            renderableArray.add(movesText);
        }

        protected void setGameLevel(int gameLevel) {
            final float GAP_TEXT = 33f;

            if (gameLevelNumber == null) {
                gameLevelNumber = new SpriteNumber(game.getResourcesManager().getTexture_t152NumArray(),
                        gameLevel, batch);
                gameLevelNumber.setOrigin(new Position2D(locationX, locationY));

                levelText = new GameObject(game.getResourcesManager().getTexture_t19_level(),
                        gameLevelNumber.getRightEdgeX() + GAP_TEXT,
                        gameLevelNumber.getOrigin().getY(), true)
                        .setSpriteBatch(batch);

                renderableArray.add(gameLevelNumber);
                renderableArray.add(levelText);
            } else {
                gameLevelNumber.setNumber(gameLevel);
            }

        }

        protected void onTimer1Sec() {
            setGameTimeSec(getGameTimeSec() + 1);
            upDateTimeNumbers(getGameTimeSec());
            checkAlarmSecond();
        }

        protected void onTimer200msec() {
            if (spritesTimeProgress == null) {
                return;
            }

            timeProgressIndex = timeProgressIndex < 5 ? timeProgressIndex + 1 : 0;
            for (int i = 0; i < 5; i++) {
                if (i < timeProgressIndex) {
                    spritesTimeProgress.get(i).setColor(GameColor.GAME_TIME_PROGRESS_ON);
                } else {
                    spritesTimeProgress.get(i).setColor(GameColor.GAME_TIME_PROGRESS_OFF);
                }
            }

        }

        private void checkAlarmSecond() {
            for (Integer time : this.alarmTimeSecArray) {
                if (getGameTimeSec() == time.intValue()) {
                    onAlarm(time.longValue());
                    break;
                }
            }
        }

        protected void onAlarm(long alarmSeconds) {

        }

        protected void addAlarmSecond(int alarmSeconds) {
            alarmTimeSecArray.add(alarmSeconds);
        }

        private void checkGameTimer(float delta) {
            this.gameTimer1sec += delta;
            this.gameTimer200msec += delta;
            boolean is200msec = false;
            boolean is1sec = false;

            if (this.gameTimer200msec >= 0.1990f) {
                this.gameTimer200msec = 0f;
                is200msec = true;
            }
            if (this.gameTimer1sec >= 1.9990f) {
                this.gameTimer1sec = 0f;
                is1sec = true;
            }

            if (is200msec) {
                onTimer200msec();
            }
            if (is1sec) {
                onTimer1Sec();
            }

        }

        public int getGameTimeSec() {
            return gameTimeSec;
        }

        public void setGameTimeSec(int gameTimeSec) {
            this.gameTimeSec = gameTimeSec;
        }

        @Override
        public void render(float delta) {
            checkGameTimer(delta);

            for (Renderable rend : renderableArray) {
                rend.render(delta);
            }

            for (Sprite sprite : spritesTimeProgress) {
                sprite.draw(batch);
            }
        }
    }
}
