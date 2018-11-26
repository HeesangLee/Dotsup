package dalcoms.game.dotsup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.Array;

public class MenuScreen implements Screen {
    final Dotsup game;
    OrthographicCamera camera;
    private Array<Renderable> renderableObjectArray;

    public MenuScreen(final Dotsup game) {

        this.game = game;
        this.camera = new OrthographicCamera();
        camera.setToOrtho(false, game.getGameConfiguration().getViewportWidth(),
                game.getGameConfiguration().getViewportHeight());

        Gdx.input.setCatchBackKey(true);
    }

    @Override
    public void show() {
        renderableObjectArray = new Array<Renderable>();

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


}
