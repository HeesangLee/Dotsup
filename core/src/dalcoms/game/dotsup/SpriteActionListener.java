package dalcoms.game.dotsup;

/**
 * Actions
 * - Scale : setSize
 * - Alpha : setAlpha
 * - Rotation : setRotation
 */
public interface SpriteActionListener {
    public void onActionScaleStarted();

    public void onActionScaleCompleted();


    public void onActionAlphaStarted();

    public void onActionAlphaCompleted();

    public void onActionRotateStarted();

    public void onActionRotateCompleted();
}
