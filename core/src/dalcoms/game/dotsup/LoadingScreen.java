package dalcoms.game.dotsup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class LoadingScreen implements Screen {

    final Dotsup game;
    OrthographicCamera camera;
    private SpriteBatch batch;
    private Array<Renderable> renderableObjectArray;

    private Array<SpriteGameObject> circleEffects;
    private SpriteGameObject loadingText;
    private float timerTime = 0;
    private int screenTimerTime = 0;
    private int loadingLevel;

    public LoadingScreen(final Dotsup game, int loadingLevel) {
        this.game = game;
        this.camera = new OrthographicCamera();
        this.batch = game.getSpriteBatch();
        this.loadingLevel = loadingLevel;

        camera.setToOrtho(false, game.getGameConfiguration().getViewportWidth(),
                game.getGameConfiguration().getViewportHeight());

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
            circle.getSprite().setColor(GameColor.LOADING_CIRCLE_EFFECT);
            circle.getSprite().setScale((float) ++i / (float) circleEffects.size);
        }

        loadingText = new SpriteGameObject(game.getResourcesManager().getTexture_t35_Loading(), 0, 0);
        loadingText.setSpriteBatch(batch)
                .setCenterLocation(game.getGameConfiguration().getViewportWidth() / 2f, CENTER_Y);
        loadingText.enableDrawSprite(true);


        renderableObjectArray.add(loadingText);

        initDots();

    }

    private void initDots() {
        final float GAP = 25f;

        char[] charNum = String.valueOf(this.loadingLevel).toCharArray();
        final float dotsWidth = (float) game.getResourcesManager().getTexture_dotsArray().get(0).getWidth();
        final float WIDTH = dotsWidth * charNum.length + GAP * (charNum.length - 1);
        final float startX = (game.getGameConfiguration().getViewportWidth() - WIDTH) / 2f;

        int dotsNum;

        for (int i = 0; i < charNum.length; i++) {
            Gdx.app.log("loadingscreen", String.valueOf(charNum[i]));
            dotsNum = Character.getNumericValue(charNum[i]);
            if (dotsNum == 0) {
                dotsNum = Dots.DOTS_ZERO;
            }

            Dots dot = new Dots(game.getResourcesManager().getTexture_dotsArray()
                    , startX + (dotsWidth + GAP) * i, 1500f
                    , dotsNum)
                    .setSpriteBatch(batch);
            dot.actionScale(0.1f, 1f, 0.5f);
            dot.actionAlpha(0.1f, 1f, 0.5f);

            renderableObjectArray.add(dot);

        }
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
            game.setScreen(new GameScreen(game, getLoadingLevel()));
        }
        this.screenTimerTime++;
    }

    public int getLoadingLevel() {
        return loadingLevel;
    }

    public void setLoadingLevel(int loadingLevel) {
        this.loadingLevel = loadingLevel;
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

    private void draw(float delta) {
        Gdx.gl.glClearColor(7 / 255f, 38 / 255f, 59 / 255f, 1f);
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
}
