package dalcoms.game.dotsup;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Dotsup extends Game {
    private SpriteBatch batch;
    private GameConfiguration gameConfiguration;
    private ResourcesManager resourcesManager;

    @Override
    public void create() {
        gameConfiguration = GameConfiguration.getInstance();
        resourcesManager = ResourcesManager.getInstance();

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
}
