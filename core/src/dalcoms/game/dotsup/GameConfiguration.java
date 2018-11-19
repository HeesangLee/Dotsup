package dalcoms.game.dotsup;

public class GameConfiguration {
    private static GameConfiguration instance = new GameConfiguration();

    private float viewportWidth = 1080f;
    private float viewportHeight = 1920f;

    public static GameConfiguration getInstance() {
        return instance;
    }

    public float getViewportWidth() {
        return this.viewportWidth;
    }

    public float getViewportHeight() {
        return this.viewportHeight;
    }
}
