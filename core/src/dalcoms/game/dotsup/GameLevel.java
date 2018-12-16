package dalcoms.game.dotsup;

import com.badlogic.gdx.utils.Array;

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
                retLevel = getLevel_1(level);
                break;
            case 2:
                retLevel = getLevel_2(level);
                break;
            case 3:
                retLevel = getLevel_3(level);
                break;
//            case 4:
//                retLevel = getLevel_4(level);
//                break;
//            case 5:
//                retLevel = getLevel_5(level);
//                break;
            default:
                retLevel = getLevel_default(level);
                break;

        }
        return retLevel;
    }

    private static Level getLevel_default(int level) {
        Level retLevel;
        boolean[][] board = new boolean[6][6];
        Array<MissionDots> mission = new Array<MissionDots>();
        Map<String, Integer> items = new HashMap<String, Integer>();
        boolean timeLimited = false;
        float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5] = true;
        board[1][5] = true;
        board[2][5] = false;
        board[3][5] = false;
        board[4][5] = true;
        board[5][5] = true;
        board[0][4] = false;
        board[1][4] = true;
        board[2][4] = true;
        board[3][4] = true;
        board[4][4] = true;
        board[5][4] = false;
        board[0][3] = true;
        board[1][3] = true;
        board[2][3] = false;
        board[3][3] = false;
        board[4][3] = true;
        board[5][3] = true;
        board[0][2] = true;
        board[1][2] = true;
        board[2][2] = false;
        board[3][2] = false;
        board[4][2] = true;
        board[5][2] = true;
        board[0][1] = false;
        board[1][1] = true;
        board[2][1] = true;
        board[3][1] = true;
        board[4][1] = true;
        board[5][1] = false;
        board[0][0] = true;
        board[1][0] = true;
        board[2][0] = false;
        board[3][0] = false;
        board[4][0] = true;
        board[5][0] = true;

        mission.add(new MissionDots(2, 2));
        mission.add(new MissionDots(4, 3));
        mission.add(new MissionDots(6, 3));
        mission.add(new MissionDots(8, 1));

        items.put("rainbow", 2);
        items.put("lock", 2);
        items.put("blakchall", 3);

        timeLimited = true;
        timeOfTimeLimited = 1800f;

        retLevel.setBoard(board);
        retLevel.setMission(mission);
        retLevel.setItems(items);
        retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);
        return retLevel;
    }


    private static Level getLevel_1(int level) {
        Level retLevel;
        boolean[][] board = new boolean[6][6];
        Array<MissionDots> mission = new Array<MissionDots>();
        Map<String, Integer> items = new HashMap<String, Integer>();
        boolean timeLimited = false;
        float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5] = false;
        board[1][5] = false;
        board[2][5] = false;
        board[3][5] = false;
        board[4][5] = false;
        board[5][5] = false;
        board[0][4] = false;
        board[1][4] = true;
        board[2][4] = true;
        board[3][4] = true;
        board[4][4] = true;
        board[5][4] = false;
        board[0][3] = false;
        board[1][3] = true;
        board[2][3] = true;
        board[3][3] = true;
        board[4][3] = true;
        board[5][3] = false;
        board[0][2] = false;
        board[1][2] = true;
        board[2][2] = true;
        board[3][2] = true;
        board[4][2] = true;
        board[5][2] = false;
        board[0][1] = false;
        board[1][1] = true;
        board[2][1] = true;
        board[3][1] = true;
        board[4][1] = true;
        board[5][1] = false;
        board[0][0] = false;
        board[1][0] = false;
        board[2][0] = false;
        board[3][0] = false;
        board[4][0] = false;
        board[5][0] = false;

        mission.add(new MissionDots(2, 1));


        timeLimited = false;
        timeOfTimeLimited = 0f;

        retLevel.setBoard(board);
        retLevel.setMission(mission);
        retLevel.setItems(items);
        retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);
        return retLevel;
    }


    private static Level getLevel_2(int level) {
        Level retLevel;
        boolean[][] board = new boolean[6][6];
        Array<MissionDots> mission = new Array<MissionDots>();
        Map<String, Integer> items = new HashMap<String, Integer>();
        boolean timeLimited = false;
        float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5] = false;
        board[1][5] = false;
        board[2][5] = false;
        board[3][5] = false;
        board[4][5] = false;
        board[5][5] = false;
        board[0][4] = false;
        board[1][4] = true;
        board[2][4] = true;
        board[3][4] = true;
        board[4][4] = true;
        board[5][4] = false;
        board[0][3] = false;
        board[1][3] = true;
        board[2][3] = true;
        board[3][3] = true;
        board[4][3] = true;
        board[5][3] = false;
        board[0][2] = false;
        board[1][2] = true;
        board[2][2] = true;
        board[3][2] = true;
        board[4][2] = true;
        board[5][2] = false;
        board[0][1] = false;
        board[1][1] = true;
        board[2][1] = true;
        board[3][1] = true;
        board[4][1] = true;
        board[5][1] = false;
        board[0][0] = false;
        board[1][0] = false;
        board[2][0] = false;
        board[3][0] = false;
        board[4][0] = false;
        board[5][0] = false;

        mission.add(new MissionDots(2, 4));
        mission.add(new MissionDots(3, 4));
        mission.add(new MissionDots(4, 1));


        timeLimited = false;
        timeOfTimeLimited = 0f;

        retLevel.setBoard(board);
        retLevel.setMission(mission);
        retLevel.setItems(items);
        retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);
        return retLevel;
    }


    private static Level getLevel_3(int level) {
        Level retLevel;
        boolean[][] board = new boolean[6][6];
        Array<MissionDots> mission = new Array<MissionDots>();
        Map<String, Integer> items = new HashMap<String, Integer>();
        boolean timeLimited = false;
        float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5] = true;
        board[1][5] = true;
        board[2][5] = true;
        board[3][5] = true;
        board[4][5] = true;
        board[5][5] = false;
        board[0][4] = false;
        board[1][4] = false;
        board[2][4] = false;
        board[3][4] = true;
        board[4][4] = true;
        board[5][4] = false;
        board[0][3] = false;
        board[1][3] = true;
        board[2][3] = true;
        board[3][3] = true;
        board[4][3] = true;
        board[5][3] = false;
        board[0][2] = false;
        board[1][2] = true;
        board[2][2] = true;
        board[3][2] = true;
        board[4][2] = true;
        board[5][2] = false;
        board[0][1] = false;
        board[1][1] = false;
        board[2][1] = false;
        board[3][1] = true;
        board[4][1] = true;
        board[5][1] = false;
        board[0][0] = true;
        board[1][0] = true;
        board[2][0] = true;
        board[3][0] = true;
        board[4][0] = true;
        board[5][0] = false;

        mission.add(new MissionDots(3, 1));
        mission.add(new MissionDots(4, 3));
        mission.add(new MissionDots(5, 2));


        timeLimited = false;
        timeOfTimeLimited = 0f;

        retLevel.setBoard(board);
        retLevel.setMission(mission);
        retLevel.setItems(items);
        retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);
        return retLevel;
    }


}
