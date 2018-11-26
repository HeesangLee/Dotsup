package dalcoms.game.dotsup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.Array;


public class SplashScreen implements Screen {

    final Dotsup game;
    OrthographicCamera camera;

    private GameObject title, text_dalcoms;
    private Array<Renderable> renderableObjectArray;
    private Array<Dots> dotsArray;
    private Dots dots;

    public SplashScreen(final Dotsup game) {
        this.game = game;
        this.camera = new OrthographicCamera();
        camera.setToOrtho(false, game.getGameConfiguration().getViewportWidth(),
                game.getGameConfiguration().getViewportHeight());

        Gdx.input.setCatchBackKey(true);
        /*
        Default back key press on Android is killing app processor
        Enabling setCatchBackKey enables catching and no input process coding make this screen has no effect for back key press.
         */
    }

    @Override
    public void show() {
        renderableObjectArray = new Array<Renderable>();
        initGameObjects();
    }

    @Override
    public void render(float delta) {

        draw(delta);
    }

    /*
    Draw and render game objects at here
     */
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
        game.getResourcesManager().disposeSplashScreenResources();

    }

    private void initGameObjects() {
        dots = new Dots(game.getResourcesManager().getTexture_dotsArray(),
                (game.getGameConfiguration().getViewportWidth() - 134f) / 2,
                1000f, 1)
                .setSpriteBatch(game.getSpriteBatch());
        dots.addSpriteActionListener(new SpriteActionListener() {
            @Override
            public void onActionScaleStarted() {

            }

            @Override
            public void onActionScaleCompleted() {
                if (dots.getDotsNum() < 3) {
                    dots.setDotsNum(dots.getDotsNum() + 1);
                    dots.actionScale(0.1f, 1f, 0.5f);
                    dots.actionRotate(0f, 360, 0.3f);
                }else{
                    game.setScreen(new MenuScreen(game));
                    dispose();
                }
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
        dots.actionScale(0.1f, 1f, 0.5f);
        dots.actionRotate(0f, 360, 0.3f);

        title = new GameObject(game.getResourcesManager().getTexture_title_splash(), 0, 0)
                .setSpriteBatch(game.getSpriteBatch())
                .enableDrawTexture(true);
        title.setCenterLocation(1080f / 2f, 1204f);

        renderableObjectArray.add(dots);
//        renderableObjectArray.add(title);
    }

    private void initDotsArray() {
        int numOfDots = 6;
        float[] xPositionOfDots = calcPositions(6,
                134f,
                906f,
                87f);

        dotsArray = new Array<Dots>();
        for (int i = 0; i < numOfDots; i++) {
            dotsArray.add(new Dots(game.getResourcesManager().getTexture_dotsArray(),
                    xPositionOfDots[i], 1000f, i + 1)
                    .setSpriteBatch(game.getSpriteBatch()));

        }
    }

    /*
     * @param numOfObject number of objects
     * @param objectLength length of object
     * @param innerLength inner length (float) including objects
     * @param offset offset is added to positions
     * @return Center positions  of objects
     */
    private float[] calcCenterPositions(int numOfObject, float objectLength, float innerLength, float offset) {
        float[] centerPoistionArray = new float[numOfObject];
        float gap = (innerLength - objectLength * numOfObject) / (numOfObject - 1);
        for (int i = 0; i < numOfObject; i++) {
            centerPoistionArray[i] = offset + objectLength / 2f + i * (objectLength + gap);
        }
        return centerPoistionArray;
    }

    private float[] calcPositions(int numOfObject, float objectLength, float innerLength, float offset) {
        float[] PostionArray = new float[numOfObject];
        float gap = (innerLength - objectLength * numOfObject) / (numOfObject - 1);
        for (int i = 0; i < numOfObject; i++) {
            PostionArray[i] = offset + i * (objectLength + gap);
        }
        return PostionArray;
    }

}
