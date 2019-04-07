package dalcoms.game.dotsup.xdriver;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import dalcoms.game.dotsup.AdmobAdListener;
import dalcoms.game.dotsup.Dotsup;
import dalcoms.game.dotsup.GameColor;
import dalcoms.game.dotsup.GameGestureListener;
import dalcoms.game.dotsup.GameObject;
import dalcoms.game.dotsup.MenuScreen;
import dalcoms.game.dotsup.ObjectActionListener;
import dalcoms.game.dotsup.Position2D;
import dalcoms.game.dotsup.ReallySimpleDialog;
import dalcoms.game.dotsup.Renderable;
import dalcoms.game.dotsup.SpriteActionListener;
import dalcoms.game.dotsup.SpriteButton;
import dalcoms.game.dotsup.SpriteGameObject;
import dalcoms.game.dotsup.SpriteNumber;

import static dalcoms.game.dotsup.GameColor.XDRIVE_DISTANCE_NUM;

public class GameXdriverScreen implements Screen {

    private final Dotsup game;
    Viewport viewport;
    OrthographicCamera camera;
    private SpriteBatch batch;
    private Array<Renderable> renderableObjectArray;
    private Array<Renderable> renderableHudArray;
    private Array<Renderable> renderableRoadLineArray;
    private Array<GameObject> roadLineArrayBank;
    private Array<Car> carsArrayBank;
    private Array<Heart> heartArrayBank;

    private GameObject appTitle, km;
    private XdriverCar xdriverCar;
    private SpriteGameObject flag;

    private boolean dialogShow = false;
    private ReallySimpleDialog dialog;

    private final int DIALOG_TOMEMU = 0;
    private final int DIALOG_SUCCESS = 1;
    private final int DIALOG_FAIL = 2;

    private boolean admobInterstitialAdLoaded = false;

    private SpriteNumber distanceNumKm, highScoreNum, heartNum;

    private float timer1Sec = 0f;
    private float timer100msec = 0f;
    private float timerRoadUpdate = 0f;
    private float timerCarUpdate = 0f;
    private float timer = 0f;

    private boolean gameStarted = false;
    private int gameStartCountdown = 0;
    private final int GAME_START_COUNT_DONW = 3;

    private int newCarProbabilityIntex = 0;
    private final float[] newCarProbabilityArray = {0.7f, 0.15f, 0.5f, 0.3f};

    private Music musicBgm;


    public GameXdriverScreen(final Dotsup game) {
        this.game = game;
        this.camera = new OrthographicCamera();
        this.batch = game.getSpriteBatch();
        camera.setToOrtho(false, game.getGameConfiguration().getViewportWidth(),
                          game.getGameConfiguration().getViewportHeight());
        this.viewport = new FitViewport(game.getGameConfiguration().getViewportWidth(),
                                        game.getGameConfiguration().getViewportHeight(), camera);
        Gdx.input.setCatchBackKey(true);
    }

    private void initGameObjects() {
        initFlagSprite();
        initDistanceNumKm();
        initAppTitle();
        initXdriverCar();
        playBgm(initSoundMusic());
        initRoadLines();
        initCarsBank();
        initHeartBank();
    }

    private void initGameStart() {
        detachAppTitle();
        detachFlag();
        initDistanceNumKmPannel();
        initHighScore();
        initHeartNum();
    }

    private void initRoadLines() {
        final int BUF_COUNT = 16;

        for (int i = 0; i < BUF_COUNT; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Gdx.app.postRunnable(new Runnable() {
                        @Override
                        public void run() {
                            roadLineArrayBank
                                    .add(new GameObject(
                                            game.getResourcesManager().getTexture_roadline(),
                                            0, 0, true).setSpriteBatch(batch));
                        }
                    });
                }
            }).start();

        }

    }

    private void initHeartBank() {
        final int BUF_COUNT = 30;

        for (int i = 0; i < BUF_COUNT; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Gdx.app.postRunnable(new Runnable() {
                        @Override
                        public void run() {
                            heartArrayBank
                                    .add(new Heart(game.getResourcesManager().getTexture_heart(), 0,
                                                   0, batch, true));
                        }
                    });

                }
            }).start();
        }
    }

    private void initCarsBank() {
        final int BUF_COUNT = 35;
        final int[] carIndex = {
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 6, 5, 4, 3, 2, 1, 0, 5, 4, 3, 2, 1, 0, 8, 2, 3, 4, 0,
                1, 6, 7, 3, 4, 5, 6, 3};

        for (int i = 0; i < BUF_COUNT; i++) {
            final int index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Gdx.app.postRunnable(new Runnable() {
                        @Override
                        public void run() {
                            carsArrayBank.add(new Car(
                                    game.getResourcesManager()
                                            .getTextureCar(carIndex[index % BUF_COUNT]), 0, 0,
                                    batch, true));
                        }
                    });
                }
            }).start();

        }
    }

    private void initHeartNum() {
        GameObject hudHeart =
                new GameObject(game.getResourcesManager().getTexture_heart(), 965f, 1792f, true)
                        .setSpriteBatch(this.batch);

        this.heartNum =
                new SpriteNumber(game.getResourcesManager().getTexture_t35NumArray(), 0, batch);
        heartNum.setOrigin(new Position2D(965f, 1731f));
        setHeartNum(0);

        renderableHudArray.add(hudHeart);
        renderableHudArray.add(heartNum);
    }

    private void initHighScore() {
        GameObject thumbup =
                new GameObject(game.getResourcesManager().getTexture_thumbup(), 31f, 1792f, true)
                        .setSpriteBatch(this.batch);

        this.km = new GameObject(game.getResourcesManager().getTexture_text_km(), 0, 1731f, true)
                .setSpriteBatch(this.batch);

        this.highScoreNum =
                new SpriteNumber(game.getResourcesManager().getTexture_t35NumArray(), 0, batch);
        highScoreNum.setOrigin(new Position2D(40f, 1731f));
        setHighScoreNumber(0);

        renderableHudArray.add(thumbup);
        renderableHudArray.add(getHighScoreNum());
        renderableHudArray.add(km);
    }

    private void initDistanceNumKmPannel() {

        GameObject numBg =
                new GameObject(game.getResourcesManager().getTexture_hud_bg(), 0, 0, true)
                        .setSpriteBatch(this.batch);
        numBg.setCenterLocation(1080f / 2f, 1920f);
        numBg.moveY(1920f, 1663f, 0.3f);
        renderableHudArray.insert(0, numBg);
        setDistanceNumKmNumber(0, 1731, XDRIVE_DISTANCE_NUM);
    }

    private void detachFlag() {
        this.flag.actionRotate(0, 360, 0.6f);
        this.flag.actionScale(1f, 0.1f, 0.6f);
        this.flag.addSpriteActionListener(new SpriteActionListener() {
            @Override
            public void onActionScaleStarted() {

            }

            @Override
            public void onActionScaleCompleted() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Gdx.app.postRunnable(new Runnable() {
                            @Override
                            public void run() {
                                renderableObjectArray.removeValue(flag, true);
                            }
                        });
                    }
                }).start();
            }

            @Override
            public void onActionAlphaStarted() {

            }

            @Override
            public void onActionAlphaCompleted() {

            }

            @Override
            public void onActionRotateStarted() {

            }

            @Override
            public void onActionRotateCompleted() {

            }
        });
    }

    private void detachAppTitle() {
        this.appTitle.moveY(appTitle.getLocationY(), 1920f, 0.6f);
        this.appTitle.addActionListener(new ObjectActionListener() {
            @Override
            public boolean onMoveCompleted(boolean direction) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Gdx.app.postRunnable(new Runnable() {
                            @Override
                            public void run() {
                                renderableObjectArray.removeValue(appTitle, true);
                            }
                        });
                    }
                }).start();
                return false;
            }

            @Override
            public boolean onMoveStarted(boolean direction) {
                return false;
            }
        });
    }

    private void initXdriverCar() {
        this.xdriverCar =
                new XdriverCar(game.getResourcesManager().getTexture_me(), 0, 0, this.batch, true);
        xdriverCar.addBottomEffect(game.getResourcesManager().getTexture_me_light());
        xdriverCar.setCenterLocation(1080f / 2f, 348f);
        xdriverCar.moveY(xdriverCar.getLocationY(), 700f, 1f);
        renderableObjectArray.add(xdriverCar);
    }

    private void initAppTitle() {
        appTitle = new GameObject(game.getResourcesManager().getTexture_xdriver_title(), 0, 0, true)
                .setSpriteBatch(this.batch);
        appTitle.setCenterLocation(1080f / 2f, 1920f / 2f);
        appTitle.moveY(appTitle.getLocationY(), 1100f, 0.5f);
        renderableObjectArray.add(appTitle);
    }

    private void initFlagSprite() {
        flag = new SpriteGameObject(game.getResourcesManager().getTexture_flag(), 0, 0)
                .setSpriteBatch(this.batch).enableDrawSprite(true);
        flag.setCenterLocation(540f, 1353f);
        flag.actionScale(0.1f, 1f, 0.5f);
        flag.actionRotate(0, 360, 1f);
        renderableObjectArray.add(flag);
    }

    private void initDistanceNumKm() {
        this.distanceNumKm =
                new SpriteNumber(game.getResourcesManager().getTexture_t152NumArray(), 0, batch);
        setDistanceNumKmNumber(0, 1387f, XDRIVE_DISTANCE_NUM);

        renderableHudArray.add(getDistanceNumKm());
    }

    private void setDistanceNumKmNumber(int number, float orgY) {
        getDistanceNumKm().setNumber(number);
        final float orgX = 540f - distanceNumKm.getSpriteNumWidth() / 2f;
        distanceNumKm.setOrigin(new Position2D(orgX, orgY));
    }

    private void setDistanceNumKmNumber(int number, float orgY, Color numColor) {
        getDistanceNumKm().setNumber(number);
        final float orgX = 540f - distanceNumKm.getSpriteNumWidth() / 2f;
        distanceNumKm.setOrigin(new Position2D(orgX, orgY));
        getDistanceNumKm().setColor(numColor);
    }

    private void setHighScoreNumber(int number, Color numColor) {
        getHighScoreNum().setNumber(number);
        getHighScoreNum().setColor(numColor);
    }

    private void setHighScoreNumber(int number) {
        getHighScoreNum().setNumber(number);
        km.setLocationX(
                getHighScoreNum().getOrigin().getX() + getHighScoreNum().getSpriteNumWidth() + 10f);
    }

    private void setHeartNum(int number) {
        getHeartNum().setNumber(number);
        final float numWidth = getHeartNum().getSpriteNumWidth();
        final float numLocationY = getHeartNum().getOrigin().getY();
        float numLocationX =
                6 * viewport.getWorldWidth() / 7 + 0.5f * (viewport.getWorldWidth() / 7 - numWidth);
        getHeartNum().setOrigin(new Position2D(numLocationX, numLocationY));
    }


    private boolean initSoundMusic() {
        musicBgm = Gdx.audio.newMusic(Gdx.files.internal("Sound/Sunrise_Drive.mp3"));
        musicBgm.setLooping(true);
        return game.getGameConfiguration().getMusicOnOff();
    }

    private void playBgm(boolean musicOnOff) {
        if (musicOnOff) {
            musicBgm.play();
        } else {
            musicBgm.stop();
        }
    }

    public SpriteNumber getDistanceNumKm() {
        return distanceNumKm;
    }

    public SpriteNumber getHighScoreNum() {
        return highScoreNum;
    }

    public SpriteNumber getHeartNum() {
        return heartNum;
    }

    private void saveGame() {

//        if (thisLevel > game.getGameConfiguration().getLastClearedLevel()) {
//            game.getGameConfiguration().putLastClearedLevel(thisLevel);
//        }
//
//        game.getGameConfiguration().putLevelClearedDate(thisLevel, TimeUtils.millis());
//        game.getGameConfiguration().putLevelMoves(thisLevel, topDisplayPanel.getGameMovesNumber());
//        game.getGameConfiguration().putLevelTimes(thisLevel, topDisplayPanel.gameTimeSec);
//
//        game.getGameConfiguration().flushingPreferences();
    }


    private void popUpAskGotoHomeScreen() {
        popUpBackKeyDialog();
    }

    private void disposeMusicBgm() {
        if (musicBgm != null) {
            musicBgm.stop();
            musicBgm.dispose();
        }
    }

    private void loadInterstitialAd() {
        game.getLauncherHandler().loadAdmobInterstital(new AdmobAdListener() {
            @Override
            public void onAdLoaded() {
                Gdx.app.log("GameScreen", "Admob interstitial loaded");
                setAdmobInterstitialAdLoaded(true);
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Gdx.app.log("GameScreen",
                            "Admob interstitial loaded failed : " + String.valueOf(errorCode));
                setAdmobInterstitialAdLoaded(false);
            }

            @Override
            public void onAdOpened() {

            }

            @Override
            public void onAdLeftApplication() {

            }

            @Override
            public void onAdClosed() {

            }

            @Override
            public void onAdClicked() {

            }

            @Override
            public void onAdImpression() {

            }
        });
    }

    public boolean isAdmobInterstitialAdLoaded() {
        return admobInterstitialAdLoaded;
    }

    public void setAdmobInterstitialAdLoaded(boolean admobInterstitialAdLoaded) {
        this.admobInterstitialAdLoaded = admobInterstitialAdLoaded;
    }

    private void showInterstitialAd() {

        game.getLauncherHandler().showAdmobInterstitial();
    }

    private void gotoMenuScreen() {
        disposeMusicBgm();
        game.setScreen(new MenuScreen(game));

    }

    private void replayThisGame() {
        disposeMusicBgm();
        showInterstitialAd();
        game.setScreen(new LoadingXdriverScreen(game));
    }


    private void popUpFailedDialog() {
        if (isDialogShow() & (getDialog() != null)) {
            if (getDialog().getId() == DIALOG_TOMEMU) {
                killDialog();
                return;
            }
        }

        setDialogShow(true);
        ReallySimpleDialog dialog =
                new ReallySimpleDialog(game.getResourcesManager().getTexture_dialog_870x718(), 0, 0,
                                       true,
                                       batch);
        dialog.setCenterLocation(game.getGameConfiguration().getViewportWidth() / 2f,
                                 game.getGameConfiguration().getViewportHeight() / 2f);
        dialog.setId(DIALOG_FAIL);

        SpriteGameObject dialogHat =
                new SpriteGameObject(game.getResourcesManager().getTexture_dialog_hat_770x288(),
                                     50f,
                                     380f).setSpriteBatch(batch);
        dialogHat.getSprite().setColor(GameColor.BUTTON_PINK_NORMAL);
        dialogHat.enableDrawSprite(true);
        dialog.addSpriteGameObject(dialogHat);

        dialog.addGameObject(
                new GameObject(game.getResourcesManager().getTexture_dialog_text_failed(), 338f,
                               455f,
                               true).setSpriteBatch(batch));

        dialog.addGameObject(
                new GameObject(game.getResourcesManager().getTexture_t35_try_again(), 309f, 270f,
                               true)
                        .setSpriteBatch(batch));

        final SpriteButton replayButton =
                new SpriteButton(game.getResourcesManager().getTexture_button_302x105(), 465f, 121f,
                                 batch, viewport) {
                    @Override
                    public void actionTouchDown() {
                        super.actionTouchDown();
                        game.getResourcesManager().getSound_tap().play();
                    }

                    @Override
                    public void actionTap() {
                        super.actionTap();
                        replayThisGame();

                    }
                };
        replayButton.setTopTexture(game.getResourcesManager().getTexture_btn_text_replay());
        replayButton.enableDrawSprite(true);
        replayButton
                .setColorEffect(true, GameColor.BUTTON_PINK_NORMAL, GameColor.BUTTON_PINK_TOUCHDOWN,
                                GameColor.MEMU_START_BUTTON_DIS_NORMAL,
                                GameColor.MEMU_START_BUTTON_DIS_TOUCHDOWN);

        final SpriteButton goHomeButton =
                new SpriteButton(game.getResourcesManager().getTexture_btn_home_105x105(), 103f,
                                 121f,
                                 batch, viewport) {
                    @Override
                    public void actionTouchDown() {
                        super.actionTouchDown();
                        game.getResourcesManager().getSound_tap().play();
                    }

                    @Override
                    public void actionTap() {
                        super.actionTap();
                        gotoMenuScreen();

                    }
                };
        goHomeButton.enableDrawSprite(true);
        goHomeButton.setColorEffect(true, GameColor.BUTTON_BROWN_NORMAL,
                                    GameColor.BUTTON_BROWN_TOUCHDOWN,
                                    GameColor.MEMU_START_BUTTON_DIS_NORMAL,
                                    GameColor.MEMU_START_BUTTON_DIS_TOUCHDOWN);

        dialog.addSpriteButton(goHomeButton);
        dialog.addSpriteButton(replayButton);


        dialog.moveY(game.getGameConfiguration().getViewportHeight(), dialog.getLocationY(), 0.5f);

        dialog.addActionListener(new ObjectActionListener() {
            @Override
            public boolean onMoveCompleted(boolean direction) {
                goHomeButton.updateTouchArea();
                replayButton.updateTouchArea();
                return false;
            }

            @Override
            public boolean onMoveStarted(boolean direction) {
                return false;
            }
        });

        setDialog(dialog);


    }

    private void popUpBackKeyDialog() {

        if (isDialogShow() & (getDialog() != null)) {
            if (getDialog().getId() == DIALOG_TOMEMU) {
                killDialog();
                return;
            }
        } else {
            setDialogShow(true);
            ReallySimpleDialog dialog =
                    new ReallySimpleDialog(game.getResourcesManager().getTexture_dialog_847x406(),
                                           0, 0,
                                           true, batch);
            dialog.setCenterLocation(game.getGameConfiguration().getViewportWidth() / 2f,
                                     game.getGameConfiguration().getViewportHeight() / 2f);
            dialog.addGameObject(
                    new GameObject(game.getResourcesManager().getTexture_text_ask_exit(), 94f, 271f,
                                   true)
                            .setSpriteBatch(batch));
            dialog.setId(DIALOG_TOMEMU);

            final SpriteButton goHomeButton =
                    new SpriteButton(game.getResourcesManager().getTexture_button_302x105(), 94f,
                                     105f,
                                     batch, viewport) {
                        @Override
                        public void actionTouchDown() {
                            super.actionTouchDown();
                            game.getResourcesManager().getSound_tap().play();
                        }

                        @Override
                        public void actionTap() {
                            super.actionTap();
                            gotoMenuScreen();
                        }
                    };
            goHomeButton.setTopTexture(game.getResourcesManager().getTexture_btn_text_home());
            goHomeButton.enableDrawSprite(true);
            goHomeButton
                    .setColorEffect(true, GameColor.BUTTON_BLUE_NORMAL,
                                    GameColor.BUTTON_BLUE_TOUCHDOWN,
                                    GameColor.MEMU_START_BUTTON_DIS_NORMAL,
                                    GameColor.MEMU_START_BUTTON_DIS_TOUCHDOWN);

            final SpriteButton stayButton =
                    new SpriteButton(game.getResourcesManager().getTexture_button_302x105(), 452f,
                                     105f,
                                     batch, viewport) {
                        @Override
                        public void actionTouchDown() {
                            super.actionTouchDown();
                            game.getResourcesManager().getSound_tap().play();
                        }

                        @Override
                        public void actionTap() {
                            super.actionTap();
                            killDialog();
                        }
                    };
            stayButton.setTopTexture(game.getResourcesManager().getTexture_btn_text_stay());
            stayButton.enableDrawSprite(true);
            stayButton.setColorEffect(true, GameColor.BUTTON_PINK_NORMAL,
                                      GameColor.BUTTON_PINK_TOUCHDOWN,
                                      GameColor.MEMU_START_BUTTON_DIS_NORMAL,
                                      GameColor.MEMU_START_BUTTON_DIS_TOUCHDOWN);


            dialog.addSpriteButton(goHomeButton);
            dialog.addSpriteButton(stayButton);


            dialog.moveY(game.getGameConfiguration().getViewportHeight(), dialog.getLocationY(),
                         0.2f);

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

    Position2D getNewTouchPoint(float x, float y) {
        Gdx.app.log("touchdebug", "1.x : " + String.valueOf(x) + ",y : " + String.valueOf(y));
        Vector2 newPoints = new Vector2(x, y);
        newPoints = viewport.unproject(newPoints);
        x = newPoints.x;
        y = newPoints.y;
        Gdx.app.log("touchdebug", "2.x : " + String.valueOf(x) + ",y : " + String.valueOf(y));
        return new Position2D(x, y);
    }

    private void setInputProcessor() {

        InputMultiplexer inputMultiplexer = new InputMultiplexer();

        inputMultiplexer.addProcessor(new GestureDetector(new GameGestureListener() {
            @Override
            public boolean touchDown(float x, float y, int pointer, int button) {
                Position2D newTouchPosition = getNewTouchPoint(x, y);
                x = newTouchPosition.getX();
                y = newTouchPosition.getY();

                if (isDialogShow() & (getDialog() != null)) {
                    getDialog().touchDown(x, y, pointer, button);
                } else {

                }

                return super.touchDown(x, y, pointer, button);
            }

            @Override
            public boolean tap(float x, float y, int count, int button) {
                Position2D newTouchPosition = getNewTouchPoint(x, y);
                x = newTouchPosition.getX();
                y = newTouchPosition.getY();

                if (isDialogShow() & (getDialog() != null)) {
                    getDialog().tap(x, y, count, button);
                } else {

                }
                return super.tap(x, y, count, button);
            }

            @Override
            public boolean longPress(float x, float y) {
                Position2D newTouchPosition = getNewTouchPoint(x, y);
                x = newTouchPosition.getX();
                y = newTouchPosition.getY();

                if (isDialogShow() & (getDialog() != null)) {
                    getDialog().longPress(x, y);
                } else {

                }
                return super.longPress(x, y);
            }

            @Override
            public boolean fling(float velocityX, float velocityY, int button) {

                return super.fling(velocityX, velocityY, button);
            }

            @Override
            public boolean pan(float x, float y, float deltaX, float deltaY) {
                Position2D newTouchPosition = getNewTouchPoint(x, y);
                x = newTouchPosition.getX();
                y = newTouchPosition.getY();

                return super.pan(x, y, deltaX, deltaY);
            }

            @Override
            public boolean panStop(float x, float y, int pointer, int button) {
                Position2D newTouchPosition = getNewTouchPoint(x, y);
                x = newTouchPosition.getX();
                y = newTouchPosition.getY();

                return super.panStop(x, y, pointer, button);
            }

            @Override
            public boolean zoom(float initialDistance, float distance) {
                return super.zoom(initialDistance, distance);
            }

            @Override
            public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1,
                                 Vector2 pointer2) {
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
                Position2D newTouchPosition = getNewTouchPoint(screenX, screenY);
                final float x = newTouchPosition.getX();
                final float y = newTouchPosition.getY();

                Gdx.app.log("xdriverinput",
                            "[touchdown] p=" + String.valueOf(pointer) + ", x=" +
                            String.valueOf(x) +
                            ", y=" + String.valueOf(y) + " , timer= " + String.valueOf(timer));

                if (pointer == 0) {
                    xdriverCar.resetTouchInput(x, y);
                }
                return false;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                return false;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                Position2D newTouchPosition = getNewTouchPoint(screenX, screenY);
                final float x = newTouchPosition.getX();
                final float y = newTouchPosition.getY();

                Gdx.app.log("xdriverinput",
                            "[dragged] p=" + String.valueOf(pointer) + ", x=" + String.valueOf(x) +
                            ", y=" + String.valueOf(y) + " , timer= " + String.valueOf(timer));
                if (pointer == 0) {
                    xdriverCar.moveXdriver(x, y);
                }
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
        if (dialogShow) {
            game.getResourcesManager().getSound_popup().play();
        }
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
        Gdx.gl.glClearColor(69 / 255f, 85 / 255f, 99 / 255f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.getSpriteBatch().setProjectionMatrix(camera.combined);
        game.getSpriteBatch().begin();


        for (Renderable renderable : renderableRoadLineArray) {
            renderable.render(delta);
        }
        for (Renderable renderableObj : renderableObjectArray) {
            renderableObj.render(delta);
        }
        for (Renderable renderable : renderableHudArray) {
            renderable.render(delta);
        }
        if (isDialogShow() & getDialog() != null) {
            getDialog().render(delta);
        }

        game.getSpriteBatch().end();
    }

    private void returnRoadToBank(final GameObject road) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Gdx.app.postRunnable(new Runnable() {
                    @Override
                    public void run() {
                        renderableRoadLineArray.removeValue(road, false);
                        roadLineArrayBank.add(road);
                    }
                });
            }
        }).start();
    }

    private void returnCarToBank(final Car car) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Gdx.app.postRunnable(new Runnable() {
                    @Override
                    public void run() {
                        renderableRoadLineArray.removeValue(car, false);
                        carsArrayBank.add(car);
                    }
                });
            }
        }).start();
    }

    private void checkRoadLineMoving() {
        final GameObject roadLine;
//        Gdx.app.log("xdriver", String.valueOf(roadLineArrayBank.size));
        if (roadLineArrayBank.size != 0) {
            roadLine = roadLineArrayBank.pop();
        } else {
            roadLine = new GameObject(game.getResourcesManager().getTexture_roadline(), 0, 0, true)
                    .setSpriteBatch(this.batch);
        }
        roadLine.moveY(viewport.getWorldHeight(), 0, 4f);
        roadLine.addActionListener(new ObjectActionListener() {
            @Override
            public boolean onMoveCompleted(boolean direction) {
                returnRoadToBank(roadLine);
                return false;
            }

            @Override
            public boolean onMoveStarted(boolean direction) {
                return false;
            }
        });

        renderableRoadLineArray.add(roadLine);
    }

    private void checkNewCarsOnRoad() {
        final float w = viewport.getWorldWidth() / 7f;

        Gdx.app.log("xdriver", String.valueOf(viewport.getWorldWidth()));

        for (int i = 0; i < 7; i++) {
            final Car tempCar;
            if ((float) Math.random() < newCarProbabilityArray[newCarProbabilityIntex]) {
                if (carsArrayBank.size != 0) {
                    tempCar = carsArrayBank.pop();
                } else {
                    tempCar = new Car(game.getResourcesManager()
                                              .getTextureCar(newCarProbabilityIntex), 0, 0, batch,
                                      true);
                }
                tempCar.setCenterLocation(w * i + 0.5f * w, viewport.getWorldHeight() + 300f);
                tempCar.moveY(viewport.getWorldHeight(), -300f, 3f);
                tempCar.addActionListener(new ObjectActionListener() {
                    @Override
                    public boolean onMoveCompleted(boolean direction) {
                        returnCarToBank(tempCar);
                        return false;
                    }

                    @Override
                    public boolean onMoveStarted(boolean direction) {
                        return false;
                    }
                });

                renderableRoadLineArray.add(tempCar);
            } else {//decide to add heart....


            }
            newCarProbabilityIntex = newCarProbabilityIntex < newCarProbabilityArray.length - 1 ?
                    newCarProbabilityIntex + 1 : 0;
        }
    }

    private void onTimerCarUpdate() {
        if (isGameStarted()) {
            checkNewCarsOnRoad();
        }
    }

    private void onTimerRoadUpdate() {
        if (isGameStarted()) {
            checkRoadLineMoving();
        }
    }

    private void onTimer100msec() {
        if (isGameStarted()) {

        }
    }

    private void onTimer1sec() {
        if (!isGameStarted()) {
            checkGameStartCount();
        } else {
        }
    }

    private void checkGameStartCount() {
        setGameStartCountdown(getGameStartCountdown() + 1);
        if (getGameStartCountdown() > GAME_START_COUNT_DONW) {
            setGameStarted(true);
            initGameStart();
        } else {
            setDistanceNumKmNumber(getDistanceNumKm().getNumber() + 1, 1387f, XDRIVE_DISTANCE_NUM);
        }
    }

    private void gameTimer(float delta) {
        this.timer += delta;
        this.timer1Sec += delta;
        this.timer100msec += delta;
        this.timerRoadUpdate += delta;
        this.timerCarUpdate += delta;

        boolean is1secOn = false;
        boolean is100msecOn = false;
        boolean isRoadUpdateOn = false;
        boolean isCarUpdateOn = false;

        if (this.timer1Sec > 0.99f) {
            this.timer1Sec = 0;
            is1secOn = true;
        }
        if (this.timer100msec > 0.090f) {
            this.timer100msec = 0f;
            is100msecOn = true;
        }
        if (this.timerRoadUpdate > 0.25f) {
            this.timerRoadUpdate = 0f;
            isRoadUpdateOn = true;
        }
        if (this.timerCarUpdate > 0.6f) {
            this.timerCarUpdate = 0f;
            isCarUpdateOn = true;
        }

        if (is1secOn) {
            onTimer1sec();
        }
        if (is100msecOn) {
            onTimer100msec();
        }
        if (isRoadUpdateOn) {
            onTimerRoadUpdate();
        }
        if (isCarUpdateOn) {
            onTimerCarUpdate();
        }

    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    public int getGameStartCountdown() {
        return gameStartCountdown;
    }

    public void setGameStartCountdown(int gameStartCountdown) {
        this.gameStartCountdown = gameStartCountdown;
    }

    public XdriverCar getXdriverCar() {
        return xdriverCar;
    }

    @Override
    public void show() {
        renderableObjectArray = new Array<Renderable>();
        renderableHudArray = new Array<Renderable>();
        renderableRoadLineArray = new Array<Renderable>();
        roadLineArrayBank = new Array<GameObject>();
        carsArrayBank = new Array<Car>();
        heartArrayBank = new Array<Heart>();

        loadInterstitialAd();
        initGameObjects();
        setInputProcessor();

    }

    @Override
    public void render(float delta) {
        gameTimer(delta);
        draw(delta);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
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
        if (musicBgm != null) {
            musicBgm.stop();
            musicBgm.dispose();
        }
    }
}