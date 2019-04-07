package dalcoms.game.dotsup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.HashMap;

import dalcoms.game.dotsup.xdriver.LoadingXdriverScreen;

public class MenuScreen implements Screen {
    final Dotsup game;
    Viewport viewport;
    OrthographicCamera camera;
    private SpriteBatch batch;
    private Array<Renderable> renderableObjectArray;
    private Array<GestureDetectableButton> gestureDetectableButtonArray;
    private GameObject levelBg, levelLocked;
    private SpriteButton startButton;
    private MenuLevelSelectButtonGroup levelSelectButtonGroup;
    private SimpleBoard levelBoardPreview;
    private MenuMissionView menuMissionView;
    private MenuLevelInfo menuLevelInfo;
    private boolean dialogShow = false;
    private ReallySimpleDialog dialog;
    Music musicBgm;
    private boolean musicOnOff;


    public MenuScreen(final Dotsup game) {

        this.game = game;
        this.camera = new OrthographicCamera();

        this.batch = game.getSpriteBatch();

        camera.setToOrtho(false, game.getGameConfiguration().getViewportWidth(),
                game.getGameConfiguration().getViewportHeight());

        this.viewport = new FitViewport(game.getGameConfiguration().getViewportWidth(),
                game.getGameConfiguration().getViewportHeight(),
                camera);
//        this.viewport = new ExtendViewport(game.getGameConfiguration().getViewportWidth(),
//                game.getGameConfiguration().getViewportHeight(),
//                camera);
        Gdx.input.setCatchBackKey(true);
    }

    @Override
    public void show() {
        renderableObjectArray = new Array<Renderable>();
        gestureDetectableButtonArray = new Array<GestureDetectableButton>();

        initGameObjects();
        setInputProcessor();


        game.getLauncherHandler().showAdmobBanner(true);
    }

    private boolean initSoundMusic() {
        musicBgm = Gdx.audio.newMusic(Gdx.files.internal("Sound/Path_to_Follow.mp3"));
        musicBgm.setLooping(true);
        return game.getGameConfiguration().getMusicOnOff();
    }


    private void initGameObjects() {
        levelBg = new GameObject(game.getResourcesManager().getTexture_menu_level_bg(), 57.138f, -823f)
                .setSpriteBatch(batch)
                .enableDrawTexture(true);
        levelBg.moveY(levelBg.getLocationY(), 0f, 0.3f);
        levelBg.addActionListener(new ObjectActionListener() {
            @Override
            public boolean onMoveCompleted(boolean direction) {
                renderableObjectArray.add(levelBoardPreview);
                renderableObjectArray.add(levelLocked);

                gestureDetectableButtonArray.add(levelSelectButtonGroup);
                gestureDetectableButtonArray.add(startButton);

                menuMissionView
                        .setMission(GameLevel.getLevel(levelSelectButtonGroup.getFocusingButton()).getMission())
                        .setShow(true);

                levelSelectButtonGroup.setShow(true);

                menuLevelInfo.setShow(true);
                menuLevelInfo.setInfo(levelSelectButtonGroup.getLevelStatus()
                        , game.getGameConfiguration().getLevelMoves(levelSelectButtonGroup.getFocusingButton())
                        , game.getGameConfiguration().getLevelTimes(levelSelectButtonGroup.getFocusingButton()));


                return false;
            }

            @Override
            public boolean onMoveStarted(boolean direction) {
                return false;
            }
        });

        levelLocked = new GameObject(game.getResourcesManager().getTexture_level_lock(), 0, 0)
                .setSpriteBatch(batch);

        startButton = new SpriteButton(game.getResourcesManager().getTexture_roundRect_468x148(),
                306, 1015, game.getSpriteBatch(), viewport) {
            @Override
            public void actionTouchDown() {
                game.getResourcesManager().getSound_tap().play();
            }

            @Override
            public void actionTap() {
                if ((levelSelectButtonGroup != null) & (startButton.getButtonState() == SpriteButton.STATE_EN)) {
                    startGame();
                }
            }

            @Override
            public void render(float delta) {
                super.render(delta);
            }

            @Override
            public void actionLongPress() {
                if ((levelSelectButtonGroup != null) & (startButton.getButtonState() == SpriteButton.STATE_EN)) {
                    startGame();
                }
            }
        };
        startButton.setTopTexture(game.getResourcesManager().getTexture_text_start());
        startButton.setColorEffect(true,
                GameColor.MEMU_START_BUTTON_EN_NORMAL, GameColor.MEMU_START_BUTTON_EN_TOUCHDOWN,
                GameColor.MEMU_START_BUTTON_DIS_NORMAL, GameColor.MEMU_START_BUTTON_DIS_TOUCHDOWN);


        levelSelectButtonGroup = new MenuLevelSelectButtonGroup(levelBg.getLocationX(), 548f,
                (float) levelBg.getWidth(), (float) 220, this.batch, this.game,
                game.getResourcesManager().getTexture_t35NumArray(),
                game.getResourcesManager().getTexture_level_sel_arrow_left(),
                game.getResourcesManager().getTexture_level_sel_arrow_right(),
                game.getResourcesManager().getTexture_level_selected_circle(),
                game.getGameConfiguration().getLastClearedLevel() < GameLevel.getMaxLevel()
                        ? game.getGameConfiguration().getLastClearedLevel() + 1
                        : GameLevel.getMaxLevel(),
                false) {
            @Override
            public void isFocusingChanged() {
                super.isFocusingChanged();
                if (levelBoardPreview != null) {
                    levelBoardPreview.calcBoardCenter(
                            GameLevel.getLevel(levelSelectButtonGroup.getFocusingButton()).getBoard());
                    levelBoardPreview.updateBoard(
                            GameLevel.getLevel(levelSelectButtonGroup.getFocusingButton()).getBoard());
                }
                if (levelLocked != null) {
                    levelLocked.setShow(isLockedLevel());
                }
                if (menuMissionView != null) {
                    menuMissionView
                            .setMission(GameLevel.getLevel(levelSelectButtonGroup.getFocusingButton()).getMission());
                }

                if (startButton != null) {
                    startButton.setButtonState(isLockedLevel());
                }

                if (menuLevelInfo != null) {
                    menuLevelInfo.setInfo(levelSelectButtonGroup.getLevelStatus()
                            , game.getGameConfiguration().getLevelMoves(levelSelectButtonGroup.getFocusingButton())
                            , game.getGameConfiguration().getLevelTimes(levelSelectButtonGroup.getFocusingButton()));
                }

            }
        };

        levelBoardPreview = new SimpleBoard(game.getResourcesManager().getTexture_level_board_rect(),
                230f, 395f,
                GameLevel.getLevel(levelSelectButtonGroup.getFocusingButton()).getBoard(),
                batch,
                true
        );//.setDisabledCellTexture(game.getResourcesManager().getTexture_level_board_rect_disabled(), true);

        levelLocked.setCenterLocation(levelBoardPreview.getCenterPosition().getX(),
                levelBoardPreview.getCenterPosition().getY());

        menuMissionView = new MenuMissionView(game.getResourcesManager().getTexture_menu_dotsArray()
                , game.getResourcesManager().getTexture_t35NumArray()
                , game.getResourcesManager().getTexture_t35_x()
                , 444f, 324f
                , false, batch);

        menuLevelInfo = new MenuLevelInfo(game.getResourcesManager().getTexture_t35NumArray()
                , new HashMap<String, Texture>() {
            {
                put(MenuLevelInfo.KEY_S, game.getResourcesManager().getTexture_t35_s());
                put(MenuLevelInfo.KEY_M, game.getResourcesManager().getTexture_t35_m());
                put(MenuLevelInfo.KEY_TIME, game.getResourcesManager().getTexture_t19_time());
                put(MenuLevelInfo.KEY_MOVES, game.getResourcesManager().getTexture_t19_moves());
                put(MenuLevelInfo.KEY_CLEARED, game.getResourcesManager().getTexture_t52_cleared());
                put(MenuLevelInfo.KEY_LOCKED, game.getResourcesManager().getTexture_t52_locked());
                put(MenuLevelInfo.KEY_NEW, game.getResourcesManager().getTexture_t52_new());

            }
        }
                , false, batch);

        renderableObjectArray.add(levelBg);
        renderableObjectArray.add(startButton);
        renderableObjectArray.add(levelSelectButtonGroup);
        renderableObjectArray.add(menuMissionView);
        renderableObjectArray.add(menuLevelInfo);

        initMusicOnOffButton();
        initMarketShareStarButtons();
        initExtraGameButtons();
    }

    private void initExtraGameButtons() {
//        todo : dotsup 업그레이드에 우선 집중 → 나중에 하자.
//        initXdriverButton();
    }

    private void initXdriverButton() {
        SpriteButton xdriverButton =
                new SpriteButton(game.getResourcesManager().getTexture_circle_200x200(),
                        880, 1520, game.getSpriteBatch(), viewport) {

                    @Override
                    public void actionTap() {
                        startXdriver();
                    }

                };

        xdriverButton.setTopTexture(game.getResourcesManager().getTexture_ico_xdriver());
        xdriverButton.setColorEffect(true,
                GameColor.GAME_HOME_BUTTON_EN_NORMAL, GameColor.GAME_HOME_BUTTON_EN_TOUCHDOWN,
                GameColor.GAME_HOME_BUTTON_EN_NORMAL, GameColor.GAME_HOME_BUTTON_EN_TOUCHDOWN);
        renderableObjectArray.add(xdriverButton);
        gestureDetectableButtonArray.add(xdriverButton);
    }

    private void initMarketShareStarButtons() {
        initMarketButton();
        initShareButton();
        initReviewButton();
    }

    private void initMarketButton() {
        SpriteButton marketButton =
                new SpriteButton(game.getResourcesManager().getTexture_circle_200x200(),
                        480, 1720, game.getSpriteBatch(), viewport) {

                    @Override
                    public void actionTap() {
                        game.getLauncherHandler().actionMoreMyApp();
                    }

                };

        marketButton.setTopTexture(game.getResourcesManager().getTexture_button_more());
        marketButton.setColorEffect(true,
                GameColor.GAME_HOME_BUTTON_EN_NORMAL, GameColor.GAME_HOME_BUTTON_EN_TOUCHDOWN,
                GameColor.GAME_HOME_BUTTON_EN_NORMAL, GameColor.GAME_HOME_BUTTON_EN_TOUCHDOWN);
        renderableObjectArray.add(marketButton);
        gestureDetectableButtonArray.add(marketButton);
    }

    private void initShareButton() {
        SpriteButton shareButton =
                new SpriteButton(game.getResourcesManager().getTexture_circle_200x200(),
                        680, 1720, game.getSpriteBatch(), viewport) {

                    @Override
                    public void actionTap() {
                        game.getLauncherHandler().actionShareMyApp();
                    }

                };

        shareButton.setTopTexture(game.getResourcesManager().getTexture_button_share());
        shareButton.setColorEffect(true,
                GameColor.GAME_HOME_BUTTON_EN_NORMAL, GameColor.GAME_HOME_BUTTON_EN_TOUCHDOWN,
                GameColor.GAME_HOME_BUTTON_EN_NORMAL, GameColor.GAME_HOME_BUTTON_EN_TOUCHDOWN);
        renderableObjectArray.add(shareButton);
        gestureDetectableButtonArray.add(shareButton);
    }

    private void initReviewButton() {
        SpriteButton reviewButton =
                new SpriteButton(game.getResourcesManager().getTexture_circle_200x200(),
                        880, 1720, game.getSpriteBatch(), viewport) {

                    @Override
                    public void actionTap() {
                        game.getLauncherHandler().actionReviewMyApp();
                    }

                };

        reviewButton.setTopTexture(game.getResourcesManager().getTexture_button_review());
        reviewButton.setColorEffect(true,
                GameColor.GAME_HOME_BUTTON_EN_NORMAL, GameColor.GAME_HOME_BUTTON_EN_TOUCHDOWN,
                GameColor.GAME_HOME_BUTTON_EN_NORMAL, GameColor.GAME_HOME_BUTTON_EN_TOUCHDOWN);
        renderableObjectArray.add(reviewButton);
        gestureDetectableButtonArray.add(reviewButton);
    }

    private void initMusicOnOffButton() {

        setMusicOnOff(initSoundMusic());

        SpriteButton musicOnOffButton =
                new SpriteButton(game.getResourcesManager().getTexture_circle_200x200(),
                        0, 1720, game.getSpriteBatch(), viewport) {
                    private void setTopTextureByState() {
                        if (getButtonState() == STATE_EN) {
                            setButtonState(STATE_DIS);
                            setMusicOnOff(false);
                            setTopTexture(game.getResourcesManager().getTexture_music_off());
                        } else {
                            setButtonState(STATE_EN);
                            setMusicOnOff(true);
                            setTopTexture(game.getResourcesManager().getTexture_music_on());
                        }
                    }

                    @Override
                    public void actionTouchDown() {
                        game.getResourcesManager().getSound_tap().play();
                    }

                    @Override
                    public void actionTap() {
                        setTopTextureByState();
                    }

                };

        musicOnOffButton.setTopTexture(isMusicOnOff() ?
                game.getResourcesManager().getTexture_music_on() :
                game.getResourcesManager().getTexture_music_off());
        musicOnOffButton.setColorEffect(true,
                GameColor.GAME_HOME_BUTTON_EN_NORMAL, GameColor.GAME_HOME_BUTTON_EN_TOUCHDOWN,
                GameColor.GAME_HOME_BUTTON_EN_NORMAL, GameColor.GAME_HOME_BUTTON_EN_TOUCHDOWN);

        musicOnOffButton.setButtonState(isMusicOnOff() ? SpriteButton.STATE_EN : SpriteButton.STATE_DIS);

        renderableObjectArray.add(musicOnOffButton);
        gestureDetectableButtonArray.add(musicOnOffButton);
    }

    public boolean isMusicOnOff() {
        return musicOnOff;
    }

    public void setMusicOnOff(boolean musicOnOff) {
        this.musicOnOff = musicOnOff;
        if (musicOnOff) {
            musicBgm.play();
        } else {
            musicBgm.pause();
        }
    }

    private void startGame() {
        if (musicBgm != null) {
            musicBgm.stop();
            musicBgm.dispose();
        }
        game.getGameConfiguration().putMusicOnOff(isMusicOnOff());
        game.getGameConfiguration().flushingPreferences();

        game.setScreen(new LoadingScreen(game, levelSelectButtonGroup.getFocusingButton()));
    }

    private void startXdriver() {
        if (musicBgm != null) {
            musicBgm.stop();
            musicBgm.dispose();
        }
        game.getGameConfiguration().putMusicOnOff(isMusicOnOff());
        game.getGameConfiguration().flushingPreferences();

        game.setScreen(new LoadingXdriverScreen(game));
    }


    @Override
    public void render(float delta) {
        draw(delta);
    }

    private void draw(float delta) {
        Gdx.gl.glClearColor(7 / 255f, 38 / 255f, 59 / 255f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.getSpriteBatch().setProjectionMatrix(camera.combined);
        game.getSpriteBatch().begin();

        this.batch.draw(game.getResourcesManager().getTexture_menu_background_circles(), 72f, 1190f);
        this.batch.draw(game.getResourcesManager().getTexture_title_menu(), 203f, 1373f);

        for (Renderable renderableObj : renderableObjectArray) {
            renderableObj.render(delta);
        }
        if (isDialogShow() & getDialog() != null) {
            getDialog().render(delta);
        }

        game.getSpriteBatch().end();
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

        game.getResourcesManager().disposeMenuScreenResources();
    }

    Position2D getNewTouchPoint(float x, float y) {
        Gdx.app.log("touchdebug", "1.x : " + String.valueOf(x) + ",y : " + String.valueOf(y));
        Vector2 newPoints = new Vector2(x, y);
        newPoints = viewport.unproject(newPoints);
        x = newPoints.x;
        y = newPoints.y;
//        y = viewport.getScreenHeight() - newPoints.y;//

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
                    for (GestureDetectableButton btn : gestureDetectableButtonArray) {
                        btn.touchDown(x, y, pointer, button);
                    }
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
                    for (GestureDetectableButton btn : gestureDetectableButtonArray) {
                        btn.tap(x, y, count, button);
                    }
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

            final SpriteButton exitButton = new SpriteButton(game.getResourcesManager().getTexture_button_302x105()
                    , 94f, 105f, batch, viewport) {
                @Override
                public void actionTouchDown() {
                    super.actionTouchDown();
                    game.getResourcesManager().getSound_tap().play();
                }

                @Override
                public void actionTap() {
                    super.actionTap();
                    game.getGameConfiguration().putMusicOnOff(isMusicOnOff());
                    game.getGameConfiguration().flushingPreferences();

                    Gdx.app.exit();
                }
            };
            exitButton.setTopTexture(game.getResourcesManager().getTexture_btn_text_exit());
            exitButton.enableDrawSprite(true);
            exitButton.setColorEffect(true,
                    GameColor.BUTTON_BLUE_NORMAL, GameColor.BUTTON_BLUE_TOUCHDOWN,
                    GameColor.MEMU_START_BUTTON_DIS_NORMAL, GameColor.MEMU_START_BUTTON_DIS_TOUCHDOWN);

            final SpriteButton stayButton = new SpriteButton(game.getResourcesManager().getTexture_button_302x105()
                    , 452f, 105f, batch, viewport) {
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
            stayButton.setColorEffect(true,
                    GameColor.BUTTON_PINK_NORMAL, GameColor.BUTTON_PINK_TOUCHDOWN,
                    GameColor.MEMU_START_BUTTON_DIS_NORMAL, GameColor.MEMU_START_BUTTON_DIS_TOUCHDOWN);


            dialog.addSpriteButton(exitButton);
            dialog.addSpriteButton(stayButton);


            dialog.moveY(game.getGameConfiguration().getViewportHeight(),
                    dialog.getLocationY(), 0.2f);

            dialog.addActionListener(new ObjectActionListener() {
                @Override
                public boolean onMoveCompleted(boolean direction) {
                    exitButton.updateTouchArea();
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
}
