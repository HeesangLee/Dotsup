package dalcoms.game.dotsup.xdriver;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import dalcoms.game.dotsup.Dotsup;
import dalcoms.game.dotsup.GameColor;
import dalcoms.game.dotsup.Renderable;
import dalcoms.game.dotsup.SpriteGameObject;

public class LoadingXdriverScreen implements Screen {
    final Dotsup game;
    OrthographicCamera camera;
    Viewport viewport;
    private SpriteBatch batch;
    private Array<Renderable> renderableObjectArray;

    private Array<SpriteGameObject> circleEffects;
    private SpriteGameObject loadingText;
    private float timerTime = 0;
    private int screenTimerTime = 0;

    public LoadingXdriverScreen(final Dotsup game) {
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
        final float CENTER_Y = 1091f;
        int i = 0;

        circleEffects = new Array<SpriteGameObject>() {
            {
                add(new SpriteGameObject(game.getResourcesManager().getTexture_circle_661x661(), 0, 0));
                add(new SpriteGameObject(game.getResourcesManager().getTexture_circle_661x661(), 0, 0));
                add(new SpriteGameObject(game.getResourcesManager().getTexture_circle_661x661(), 0, 0));
                add(new SpriteGameObject(game.getResourcesManager().getTexture_circle_661x661(), 0, 0));
            }
        };
        for (SpriteGameObject circle : circleEffects) {
            circle.setSpriteBatch(batch)
                    .setCenterLocation(game.getGameConfiguration().getViewportWidth() / 2f, CENTER_Y);
            circle.getSprite().setColor(GameColor.LOADING_CIRCLE_EFFECT_XDRIVER);
            circle.getSprite().setScale((float) ++i / (float) circleEffects.size);
        }

        loadingText = new SpriteGameObject(game.getResourcesManager().getTexture_t35_Loading(), 0, 0);
        loadingText.setSpriteBatch(batch)
                .setCenterLocation(game.getGameConfiguration().getViewportWidth() / 2f, CENTER_Y);
        loadingText.enableDrawSprite(true);


        renderableObjectArray.add(loadingText);

        SpriteGameObject tireFootprint =
                new SpriteGameObject(game.getResourcesManager().getTexture_tire_footprint(), 304f, 800f)
                        .setSpriteBatch(batch).enableDrawSprite(true);
        tireFootprint.actionAlpha(0.1f, 1f, 0.6f);
        tireFootprint.actionScale(0.1f, 1f, 0.6f);

        renderableObjectArray.add(tireFootprint);

    }

    private boolean checkTimer(float delta, float timerTime) {
        this.timerTime += delta;

        if (this.timerTime >= timerTime) {
            this.timerTime = 0;
            return true;
        } else {
            return false;
        }
    }

    private void screenTimer() {

        if (screenTimerTime < circleEffects.size) {
            circleEffects.get(screenTimerTime).enableDrawSprite(true);
            circleEffects.get(screenTimerTime).actionAlpha(0.01f, 0.35f, 0.20f);
            renderableObjectArray.insert(screenTimerTime, circleEffects.get(screenTimerTime));
        } else {
            game.setScreen(new GameXdriverScreen(game));
        }
        this.screenTimerTime++;
    }

    private void draw(float delta) {
        Gdx.gl.glClearColor(69 / 255f, 85 / 255f, 99 / 255f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.getSpriteBatch().setProjectionMatrix(camera.combined);
        game.getSpriteBatch().begin();

        for (Renderable renderableObj : renderableObjectArray) {
            renderableObj.render(delta);
        }

        game.getSpriteBatch().end();
    }

    @Override
    public void show() {
        renderableObjectArray = new Array<Renderable>();
        initGameObjects();
    }

    @Override
    public void render(float delta) {
        if (checkTimer(delta, 0.20f)) {
            screenTimer();
        }
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

    }
}
