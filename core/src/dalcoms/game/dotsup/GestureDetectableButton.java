package dalcoms.game.dotsup;

public interface GestureDetectableButton {

    public void touchDown(float x, float y, int pointer, int button);

    public void tap(float x, float y, int count, int button);

    public void longPress(float x, float y);

    public void fling(float velocityX, float velocityY, int button);
}
