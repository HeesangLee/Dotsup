package dalcoms.game.dotsup;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Dotsup extends Game {
    private SpriteBatch batch;
    private GameConfiguration gameConfiguration;
    private ResourcesManager resourcesManager;

    private IActivityRequestHandler launcherHandler;

    public Dotsup(){

    }

    public Dotsup(IActivityRequestHandler handler) {
        this.launcherHandler = handler;
    }

    @Override
    public void create() {
        gameConfiguration = GameConfiguration.getInstance();
        resourcesManager = ResourcesManager.getInstance();

        gameConfiguration
                .setHperW((float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth());

        Gdx.app.log("screen", String.valueOf(
                (float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth()));
        resourcesManager.loadResources();

        batch = new SpriteBatch();

        setScreen(new SplashScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
        getResourcesManager().disposeSoundResources();
    }

    public SpriteBatch getSpriteBatch() {
        return this.batch;
    }


    public GameConfiguration getGameConfiguration() {
        return gameConfiguration;
    }

    public ResourcesManager getResourcesManager() {
        return resourcesManager;
    }

    public IActivityRequestHandler getLauncherHandler() {
        return launcherHandler;
    }
}
