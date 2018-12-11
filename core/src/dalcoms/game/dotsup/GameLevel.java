package dalcoms.game.dotsup;

import java.util.HashMap;
import java.util.Map;

public class GameLevel {

    private final static int MAX_LEVEL = 100;
    public final static int RANGE_MIN = 0;
    public final static int RANGE_MAX = 1;


    public GameLevel() {

    }

    public static int getMaxLevel() {
        return MAX_LEVEL;
    }

    public static int[] getLevelViewRange(int levelIncluded) {
        final int NumOfLevel = 5;
        int[] ret = new int[2];
        int levelPage = levelIncluded % NumOfLevel == 0 ? levelIncluded / NumOfLevel : levelIncluded / NumOfLevel + 1;
        ret[RANGE_MAX] = levelPage * NumOfLevel;
        ret[RANGE_MIN] = ret[RANGE_MAX] - 4;
        return ret;
    }

    public static Level getLevel(int level) {
        Level retLevel;
        switch (level) {
            case 1:
                retLevel = getLevel_1();
                break;
            case 2:
                retLevel = getLevel_2();
                break;
            default:
                retLevel = getLevel_default();
                break;

        }
        return retLevel;
    }

    private static Level getLevel_default() {
        Level retLevel;
        boolean[][] board = new boolean[6][6];
        Map<Integer, Integer> mission = new HashMap<Integer, Integer>();
        Map<String, Integer> items = new HashMap<String, Integer>();
        boolean timeLimited = false;
        float timeOfTimeLimited = 0f;

        retLevel = new Level(1);

        board[0][0] = true;
        board[0][1] = true;
        board[0][2] = false;
        board[0][3] = false;
        board[0][4] = true;
        board[0][5] = true;
        board[1][0] = false;
        board[1][1] = true;
        board[1][2] = true;
        board[1][3] = true;
        board[1][4] = true;
        board[1][5] = false;
        board[2][0] = true;
        board[2][1] = true;
        board[2][2] = false;
        board[2][3] = false;
        board[2][4] = true;
        board[2][5] = true;
        board[3][0] = true;
        board[3][1] = true;
        board[3][2] = false;
        board[3][3] = false;
        board[3][4] = true;
        board[3][5] = true;
        board[4][0] = false;
        board[4][1] = true;
        board[4][2] = true;
        board[4][3] = true;
        board[4][4] = true;
        board[4][5] = false;
        board[5][0] = true;
        board[5][1] = true;
        board[5][2] = false;
        board[5][3] = false;
        board[5][4] = true;
        board[5][5] = true;

        mission.put(2, 2);
        mission.put(4, 3);
        mission.put(6, 3);
        mission.put(8, 1);

        items.put("rainbow", 2);
        items.put("lock", 2);
        items.put("blakchall", 3);

        timeLimited = true;
        timeOfTimeLimited = 1200f;

        retLevel.setBoard(board);
        retLevel.setMission(mission);
        retLevel.setItems(items);
        retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);

        return retLevel;
    }

    private static Level getLevel_1() {
        Level retLevel;
        boolean[][] board = new boolean[6][6];
        Map<Integer, Integer> mission = new HashMap<Integer, Integer>();
        Map<String, Integer> items = new HashMap<String, Integer>();
        boolean timeLimited = false;
        float timeOfTimeLimited = 0f;
        retLevel = new Level(1);

        board[0][0] = false;
        board[0][1] = false;
        board[0][2] = false;
        board[0][3] = false;
        board[0][4] = false;
        board[0][5] = false;
        board[1][0] = false;
        board[1][1] = true;
        board[1][2] = true;
        board[1][3] = true;
        board[1][4] = true;
        board[1][5] = false;
        board[2][0] = false;
        board[2][1] = true;
        board[2][2] = true;
        board[2][3] = true;
        board[2][4] = true;
        board[2][5] = false;
        board[3][0] = false;
        board[3][1] = true;
        board[3][2] = true;
        board[3][3] = true;
        board[3][4] = true;
        board[3][5] = false;
        board[4][0] = false;
        board[4][1] = true;
        board[4][2] = true;
        board[4][3] = true;
        board[4][4] = true;
        board[4][5] = false;
        board[5][0] = false;
        board[5][1] = false;
        board[5][2] = false;
        board[5][3] = false;
        board[5][4] = false;
        board[5][5] = false;

        mission.put(2, 1);


        timeLimited = false;
        timeOfTimeLimited = 0f;

        retLevel.setBoard(board);
        retLevel.setMission(mission);
        retLevel.setItems(items);
        retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);
        return retLevel;
    }

    private static Level getLevel_2() {
        Level retLevel;
        boolean[][] board = new boolean[6][6];
        Map<Integer, Integer> mission = new HashMap<Integer, Integer>();
        Map<String, Integer> items = new HashMap<String, Integer>();
        boolean timeLimited = false;
        float timeOfTimeLimited = 0f;
        retLevel = new Level(2);

        board[0][0] = false;
        board[0][1] = false;
        board[0][2] = false;
        board[0][3] = false;
        board[0][4] = false;
        board[0][5] = false;
        board[1][0] = false;
        board[1][1] = true;
        board[1][2] = true;
        board[1][3] = true;
        board[1][4] = true;
        board[1][5] = false;
        board[2][0] = false;
        board[2][1] = true;
        board[2][2] = true;
        board[2][3] = true;
        board[2][4] = true;
        board[2][5] = false;
        board[3][0] = false;
        board[3][1] = true;
        board[3][2] = true;
        board[3][3] = true;
        board[3][4] = true;
        board[3][5] = false;
        board[4][0] = false;
        board[4][1] = true;
        board[4][2] = true;
        board[4][3] = true;
        board[4][4] = true;
        board[4][5] = false;
        board[5][0] = false;
        board[5][1] = false;
        board[5][2] = false;
        board[5][3] = false;
        board[5][4] = false;
        board[5][5] = false;

        mission.put(2, 4);
        mission.put(3, 4);
        mission.put(4, 1);


        timeLimited = false;
        timeOfTimeLimited = 0f;

        retLevel.setBoard(board);
        retLevel.setMission(mission);
        retLevel.setItems(items);
        retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);
        return retLevel;
    }


}
