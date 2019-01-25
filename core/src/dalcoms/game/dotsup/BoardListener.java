package dalcoms.game.dotsup;

public interface BoardListener {
    int LEFT = 0;
    int RIGHT = 1;
    int UP = 2;
    int DOWN = 3;

    void dotsMoved(int direction);
    void boardFull(boolean isPossibleToMoveDots);
    void dotsNew();
}
