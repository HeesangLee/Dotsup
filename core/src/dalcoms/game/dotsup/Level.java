package dalcoms.game.dotsup;

import com.badlogic.gdx.utils.Array;

import java.util.HashMap;
import java.util.Map;

public class Level {
    private int level = 0;
    private boolean[][] board = new boolean[6][6];
    //    private Map<Integer, Integer> mission = new HashMap<Integer, Integer>();
    private Array<MissionDots> mission = new Array<MissionDots>();
    private Map<String, Integer> items = new HashMap<String, Integer>();
    private boolean timeLimited = false;
    private float timeOfTimeLimited;//sec

    public Level(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public boolean[][] getBoard() {
        return board;
    }

    public void setBoard(boolean[][] board) {
        this.board = board;
    }

    public Array<MissionDots> getMission() {
        return mission;
    }

    public void setMission(Array<MissionDots> mission) {
        this.mission = mission;
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public void setItems(Map<String, Integer> items) {
        this.items = items;
    }

    public boolean isTimeLimited() {
        return timeLimited;
    }

    public float getTimeOfTimeLimited() {
        return timeOfTimeLimited;
    }

    public void setTimeLimited(boolean timeLimited, float timeOfTimeLimited) {
        this.timeLimited = timeLimited;
        this.timeOfTimeLimited = timeOfTimeLimited;
    }
}
