package dalcoms.game.dotsup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class MenuScreen implements Screen {
    final Dotsup game;
    OrthographicCamera camera;
    private SpriteBatch batch;
    private Array<Renderable> renderableObjectArray;
    private Array<GestureDetectableButton> gestureDetectableButtonArray;
    private GameObject levelBg, levelLocked;
    private SpriteButton startButton;
    private MenuLevelSelectButtonGroup levelSelectButtonGroup;
    private SimpleBoard levelBoardPreview;
    private MenuMissionView menuMissionView;


    public MenuScreen(final Dotsup game) {

        this.game = game;
        this.camera = new OrthographicCamera();
        this.batch = game.getSpriteBatch();

        camera.setToOrtho(false, game.getGameConfiguration().getViewportWidth(),
                game.getGameConfiguration().getViewportHeight());

        Gdx.input.setCatchBackKey(true);
    }

    @Override
    public void show() {
        renderableObjectArray = new Array<Renderable>();
        gestureDetectableButtonArray = new Array<GestureDetectableButton>();

        initGameObjects();
        setInputProcessor();
    }


    private void initGameObjects() {
        levelBg = new GameObject(game.getResourcesManager().getTexture_menu_level_bg(), 57.138f, -823f)
                .setSpriteBatch(batch)
                .enableDrawTexture(true);
        levelBg.moveY(levelBg.getLocationY(), 0f, 0.5f);
        levelBg.addActionListener(new ObjectActionListener() {
            @Override
            public boolean onMoveCompleted(boolean direction) {
                renderableObjectArray.add(levelSelectButtonGroup);
                renderableObjectArray.add(levelBoardPreview);
                renderableObjectArray.add(levelLocked);

                gestureDetectableButtonArray.add(levelSelectButtonGroup);
                gestureDetectableButtonArray.add(startButton);

                menuMissionView
                        .setMission(GameLevel.getLevel(levelSelectButtonGroup.getFocusingButton()).getMission())
                        .setShow(true);


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
                306, 1015, game.getSpriteBatch());
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
                game.getGameConfiguration().getLastClearedLevel() + 1) {
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
//                    levelLocked.setShow(getFocusingButton() > game.getGameConfiguration().getLastClearedLevel() + 1);
                    levelLocked.setShow(isLockedLevel());
                }
                if (menuMissionView != null) {
                    menuMissionView
                            .setMission(GameLevel.getLevel(levelSelectButtonGroup.getFocusingButton()).getMission());
                }

                if (isLockedLevel()) {

                }
                if (startButton != null) {
                    startButton.setButtonState(isLockedLevel());
                }

            }
        };

        levelBoardPreview = new SimpleBoard(game.getResourcesManager().getTexture_level_board_rect(),
                230f, 395f,
                GameLevel.getLevel(levelSelectButtonGroup.getFocusingButton()).getBoard(),
                batch,
                true
        );

        levelLocked.setCenterLocation(levelBoardPreview.getCenterPosition().getX(),
                levelBoardPreview.getCenterPosition().getY());

        menuMissionView = new MenuMissionView(game.getResourcesManager().getTexture_menu_dotsArray()
                , game.getResourcesManager().getTexture_t35NumArray()
                , game.getResourcesManager().getTexture_t35_x()
                , 444f, 324f
                , false, batch);

        renderableObjectArray.add(levelBg);
        renderableObjectArray.add(startButton);
        renderableObjectArray.add(menuMissionView);

    }

    private void updateMissonOfLevel() {

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

        this.batch.draw(game.getResourcesManager().getTexture_menu_background_circles(), 51f, 1206f);
        this.batch.draw(game.getResourcesManager().getTexture_title_menu(), 203f, 1373f);

        for (Renderable renderableObj : renderableObjectArray) {
            renderableObj.render(delta);
        }

        game.getSpriteBatch().end();
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
        game.getResourcesManager().disposeMenuScreenResources();
    }

    private void setInputProcessor() {
        Gdx.input.setInputProcessor(new GestureDetector(new GameGestureListener() {
            @Override
            public boolean touchDown(float x, float y, int pointer, int button) {
                for (GestureDetectableButton btn : gestureDetectableButtonArray) {
                    btn.touchDown(x, y, pointer, button);
                }
                return super.touchDown(x, y, pointer, button);
            }

            @Override
            public boolean tap(float x, float y, int count, int button) {
                for (GestureDetectableButton btn : gestureDetectableButtonArray) {
                    btn.tap(x, y, count, button);
                }
                return super.tap(x, y, count, button);
            }

            @Override
            public boolean longPress(float x, float y) {
                for (GestureDetectableButton btn : gestureDetectableButtonArray) {
                    btn.longPress(x, y);
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
    }


}
