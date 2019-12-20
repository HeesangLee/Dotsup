package dalcoms.game.dotsup;

import com.badlogic.gdx.utils.Array;

public class GameLevel {

    private final static int MAX_LEVEL = 105;
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

    public static Level getLevel(int level) { Level retLevel; switch (level) {
        case 1:retLevel=getLevel_1(level);break;
        case 2:retLevel=getLevel_2(level);break;
        case 3:retLevel=getLevel_3(level);break;
        case 4:retLevel=getLevel_4(level);break;
        case 5:retLevel=getLevel_5(level);break;
        case 6:retLevel=getLevel_6(level);break;
        case 7:retLevel=getLevel_7(level);break;
        case 8:retLevel=getLevel_8(level);break;
        case 9:retLevel=getLevel_9(level);break;
        case 10:retLevel=getLevel_10(level);break;
        case 11:retLevel=getLevel_11(level);break;
        case 12:retLevel=getLevel_12(level);break;
        case 13:retLevel=getLevel_13(level);break;
        case 14:retLevel=getLevel_14(level);break;
        case 15:retLevel=getLevel_15(level);break;
        case 16:retLevel=getLevel_16(level);break;
        case 17:retLevel=getLevel_17(level);break;
        case 18:retLevel=getLevel_18(level);break;
        case 19:retLevel=getLevel_19(level);break;
        case 20:retLevel=getLevel_20(level);break;
        case 21:retLevel=getLevel_21(level);break;
        case 22:retLevel=getLevel_22(level);break;
        case 23:retLevel=getLevel_23(level);break;
        case 24:retLevel=getLevel_24(level);break;
        case 25:retLevel=getLevel_25(level);break;
        case 26:retLevel=getLevel_26(level);break;
        case 27:retLevel=getLevel_27(level);break;
        case 28:retLevel=getLevel_28(level);break;
        case 29:retLevel=getLevel_29(level);break;
        case 30:retLevel=getLevel_30(level);break;
        case 31:retLevel=getLevel_31(level);break;
        case 32:retLevel=getLevel_32(level);break;
        case 33:retLevel=getLevel_33(level);break;
        case 34:retLevel=getLevel_34(level);break;
        case 35:retLevel=getLevel_35(level);break;
        case 36:retLevel=getLevel_36(level);break;
        case 37:retLevel=getLevel_37(level);break;
        case 38:retLevel=getLevel_38(level);break;
        case 39:retLevel=getLevel_39(level);break;
        case 40:retLevel=getLevel_40(level);break;
        case 41:retLevel=getLevel_41(level);break;
        case 42:retLevel=getLevel_42(level);break;
        case 43:retLevel=getLevel_43(level);break;
        case 44:retLevel=getLevel_44(level);break;
        case 45:retLevel=getLevel_45(level);break;
        case 46:retLevel=getLevel_46(level);break;
        case 47:retLevel=getLevel_47(level);break;
        case 48:retLevel=getLevel_48(level);break;
        case 49:retLevel=getLevel_49(level);break;
        case 50:retLevel=getLevel_50(level);break;
        case 51:retLevel=getLevel_51(level);break;
        case 52:retLevel=getLevel_52(level);break;
        case 53:retLevel=getLevel_53(level);break;
        case 54:retLevel=getLevel_54(level);break;
        case 55:retLevel=getLevel_55(level);break;
        case 56:retLevel=getLevel_56(level);break;
        case 57:retLevel=getLevel_57(level);break;
        case 58:retLevel=getLevel_58(level);break;
        case 59:retLevel=getLevel_59(level);break;
        case 60:retLevel=getLevel_60(level);break;
        case 61:retLevel=getLevel_61(level);break;
        case 62:retLevel=getLevel_62(level);break;
        case 63:retLevel=getLevel_63(level);break;
        case 64:retLevel=getLevel_64(level);break;
        case 65:retLevel=getLevel_65(level);break;
        case 66:retLevel=getLevel_66(level);break;
        case 67:retLevel=getLevel_67(level);break;
        case 68:retLevel=getLevel_68(level);break;
        case 69:retLevel=getLevel_69(level);break;
        case 70:retLevel=getLevel_70(level);break;
        case 71:retLevel=getLevel_71(level);break;
        case 72:retLevel=getLevel_72(level);break;
        case 73:retLevel=getLevel_73(level);break;
        case 74:retLevel=getLevel_74(level);break;
        case 75:retLevel=getLevel_75(level);break;
        case 76:retLevel=getLevel_76(level);break;
        case 77:retLevel=getLevel_77(level);break;
        case 78:retLevel=getLevel_78(level);break;
        case 79:retLevel=getLevel_79(level);break;
        case 80:retLevel=getLevel_80(level);break;
        case 81:retLevel=getLevel_81(level);break;
        case 82:retLevel=getLevel_82(level);break;
        case 83:retLevel=getLevel_83(level);break;
        case 84:retLevel=getLevel_84(level);break;
        case 85:retLevel=getLevel_85(level);break;
        case 86:retLevel=getLevel_86(level);break;
        case 87:retLevel=getLevel_87(level);break;
        case 88:retLevel=getLevel_88(level);break;
        case 89:retLevel=getLevel_89(level);break;
        case 90:retLevel=getLevel_90(level);break;
        case 91:retLevel=getLevel_91(level);break;
        case 92:retLevel=getLevel_92(level);break;
        case 93:retLevel=getLevel_93(level);break;
        case 94:retLevel=getLevel_94(level);break;
        case 95:retLevel=getLevel_95(level);break;
        case 96:retLevel=getLevel_96(level);break;
        case 97:retLevel=getLevel_97(level);break;
        case 98:retLevel=getLevel_98(level);break;
        case 99:retLevel=getLevel_99(level);break;
        case 100:retLevel=getLevel_100(level);break;
        case 101:retLevel=getLevel_101(level);break;
        case 102:retLevel=getLevel_102(level);break;
        case 103:retLevel=getLevel_103(level);break;
        case 104:retLevel=getLevel_104(level);break;
        case 105:retLevel=getLevel_105(level);break;



        default: retLevel = getLevel_default(level); break; } return retLevel;}


    private static Level getLevel_default(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=false;board[3][5]=false;board[4][5]=true;board[5][5]=true;board[0][4]=false;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=true;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=false;board[3][3]=false;board[4][3]=true;board[5][3]=true;board[0][2]=true;board[1][2]=true;board[2][2]=false;board[3][2]=false;board[4][2]=true;board[5][2]=true;board[0][1]=false;board[1][1]=true;board[2][1]=true;board[3][1]=true;board[4][1]=true;board[5][1]=false;board[0][0]=true;board[1][0]=true;board[2][0]=false;board[3][0]=false;board[4][0]=true;board[5][0]=true;

        mission.add(new MissionDots(2,2));mission.add(new MissionDots(4,3));mission.add(new MissionDots(6,3));mission.add(new MissionDots(8,1));

        items.add(new GameItem("bomb",3));items.add(new GameItem("magic",3));

        timeLimited=true;timeOfTimeLimited=1800f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}


    private static Level getLevel_1(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=false;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=false;board[3][4]=false;board[4][4]=false;board[5][4]=false;board[0][3]=false;board[1][3]=false;board[2][3]=false;board[3][3]=false;board[4][3]=false;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=false;board[3][2]=false;board[4][2]=false;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(2,1));



        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}


    private static Level getLevel_2(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=true;board[3][4]=false;board[4][4]=false;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=false;board[4][3]=false;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=false;board[3][2]=false;board[4][2]=false;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(2,4));mission.add(new MissionDots(3,4));mission.add(new MissionDots(4,1));



        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_3(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=false;board[2][5]=true;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=true;board[3][4]=false;board[4][4]=false;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=false;board[4][3]=false;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=false;board[3][2]=false;board[4][2]=false;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(2,4));mission.add(new MissionDots(3,4));mission.add(new MissionDots(4,1));

        items.add(new GameItem("bomb",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}


    private static Level getLevel_4(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=true;board[2][5]=true;board[3][5]=true;board[4][5]=true;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=true;board[3][4]=false;board[4][4]=true;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=false;board[3][3]=false;board[4][3]=true;board[5][3]=false;board[0][2]=true;board[1][2]=false;board[2][2]=false;board[3][2]=false;board[4][2]=true;board[5][2]=true;board[0][1]=true;board[1][1]=true;board[2][1]=true;board[3][1]=true;board[4][1]=true;board[5][1]=true;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=true;board[4][0]=true;board[5][0]=false;

        mission.add(new MissionDots(3,4));mission.add(new MissionDots(4,2));mission.add(new MissionDots(5,2));mission.add(new MissionDots(6,1));

        items.add(new GameItem("magic",4));items.add(new GameItem("bomb_a",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}


    private static Level getLevel_5(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=true;board[4][5]=true;board[5][5]=false;board[0][4]=true;board[1][4]=false;board[2][4]=false;board[3][4]=false;board[4][4]=true;board[5][4]=false;board[0][3]=true;board[1][3]=false;board[2][3]=true;board[3][3]=true;board[4][3]=true;board[5][3]=false;board[0][2]=true;board[1][2]=false;board[2][2]=false;board[3][2]=false;board[4][2]=true;board[5][2]=true;board[0][1]=true;board[1][1]=true;board[2][1]=true;board[3][1]=false;board[4][1]=true;board[5][1]=true;board[0][0]=true;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=true;board[5][0]=true;

        mission.add(new MissionDots(3,2));mission.add(new MissionDots(4,3));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,1));

        items.add(new GameItem("bomb",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}


    private static Level getLevel_6(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=false;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=false;board[3][4]=false;board[4][4]=false;board[5][4]=false;board[0][3]=false;board[1][3]=false;board[2][3]=false;board[3][3]=false;board[4][3]=false;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=false;board[3][2]=false;board[4][2]=false;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(2,4));mission.add(new MissionDots(3,2));mission.add(new MissionDots(4,1));



        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}


    private static Level getLevel_7(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=true;board[3][4]=false;board[4][4]=false;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=false;board[4][3]=false;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=false;board[3][2]=false;board[4][2]=false;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(3,3));mission.add(new MissionDots(4,2));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,1));

        items.add(new GameItem("lock",90));items.add(new GameItem("bomb",3));items.add(new GameItem("magic_a",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}


    private static Level getLevel_8(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=true;board[2][5]=false;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=false;board[3][4]=true;board[4][4]=true;board[5][4]=true;board[0][3]=false;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=false;board[5][3]=true;board[0][2]=false;board[1][2]=true;board[2][2]=false;board[3][2]=true;board[4][2]=true;board[5][2]=true;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=true;board[4][1]=false;board[5][1]=true;board[0][0]=false;board[1][0]=true;board[2][0]=true;board[3][0]=true;board[4][0]=true;board[5][0]=true;

        mission.add(new MissionDots(3,4));mission.add(new MissionDots(4,2));mission.add(new MissionDots(5,2));mission.add(new MissionDots(6,1));

        items.add(new GameItem("magic",3));items.add(new GameItem("bomb",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}


    private static Level getLevel_9(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=true;board[2][5]=false;board[3][5]=true;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=true;board[5][4]=false;board[0][3]=false;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=false;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=true;board[3][2]=false;board[4][2]=false;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(4,3));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,2));mission.add(new MissionDots(7,1));

        items.add(new GameItem("magic",3));items.add(new GameItem("bomb",3));items.add(new GameItem("magic_a",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}


    private static Level getLevel_10(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=true;board[4][5]=true;board[5][5]=false;board[0][4]=true;board[1][4]=false;board[2][4]=true;board[3][4]=false;board[4][4]=true;board[5][4]=false;board[0][3]=false;board[1][3]=false;board[2][3]=false;board[3][3]=false;board[4][3]=false;board[5][3]=false;board[0][2]=true;board[1][2]=false;board[2][2]=false;board[3][2]=false;board[4][2]=true;board[5][2]=false;board[0][1]=true;board[1][1]=true;board[2][1]=false;board[3][1]=true;board[4][1]=true;board[5][1]=false;board[0][0]=true;board[1][0]=true;board[2][0]=true;board[3][0]=true;board[4][0]=true;board[5][0]=false;

        mission.add(new MissionDots(3,2));mission.add(new MissionDots(4,4));mission.add(new MissionDots(5,2));mission.add(new MissionDots(6,1));

        items.add(new GameItem("rainbow",0));items.add(new GameItem("lock",15));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}


    private static Level getLevel_11(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=false;board[2][5]=true;board[3][5]=true;board[4][5]=false;board[5][5]=true;board[0][4]=true;board[1][4]=true;board[2][4]=false;board[3][4]=true;board[4][4]=true;board[5][4]=true;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=true;board[5][3]=false;board[0][2]=false;board[1][2]=true;board[2][2]=false;board[3][2]=true;board[4][2]=true;board[5][2]=true;board[0][1]=true;board[1][1]=true;board[2][1]=true;board[3][1]=true;board[4][1]=false;board[5][1]=true;board[0][0]=true;board[1][0]=false;board[2][0]=true;board[3][0]=true;board[4][0]=false;board[5][0]=true;

        mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,3));mission.add(new MissionDots(7,2));mission.add(new MissionDots(8,1));

        items.add(new GameItem("missile",8));items.add(new GameItem("lock",20));items.add(new GameItem("bomb_a",4));items.add(new GameItem("magic_a",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_12(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=true;board[2][5]=false;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=false;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=false;board[5][4]=false;board[0][3]=false;board[1][3]=true;board[2][3]=true;board[3][3]=false;board[4][3]=false;board[5][3]=false;board[0][2]=false;board[1][2]=true;board[2][2]=false;board[3][2]=false;board[4][2]=false;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(3,5));mission.add(new MissionDots(4,3));mission.add(new MissionDots(5,1));

        items.add(new GameItem("magic",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}


    private static Level getLevel_13(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=true;board[4][5]=true;board[5][5]=true;board[0][4]=true;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=true;board[5][4]=true;board[0][3]=false;board[1][3]=false;board[2][3]=false;board[3][3]=false;board[4][3]=false;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=false;board[3][2]=false;board[4][2]=false;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(5,2));mission.add(new MissionDots(6,2));mission.add(new MissionDots(7,3));mission.add(new MissionDots(8,1));

        items.add(new GameItem("magic",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_14(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=true;board[2][5]=false;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=false;board[5][4]=false;board[0][3]=false;board[1][3]=true;board[2][3]=true;board[3][3]=false;board[4][3]=false;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=false;board[3][2]=false;board[4][2]=false;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(2,3));mission.add(new MissionDots(3,3));mission.add(new MissionDots(4,2));mission.add(new MissionDots(5,1));

        items.add(new GameItem("bomb",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_15(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=false;board[4][5]=true;board[5][5]=false;board[0][4]=true;board[1][4]=false;board[2][4]=true;board[3][4]=true;board[4][4]=true;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=false;board[4][3]=true;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=true;board[3][2]=false;board[4][2]=false;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=true;board[3][1]=true;board[4][1]=true;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(3,1));mission.add(new MissionDots(4,4));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,1));

        items.add(new GameItem("rainbow",0));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_16(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=false;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=true;board[5][4]=false;board[0][3]=false;board[1][3]=false;board[2][3]=true;board[3][3]=false;board[4][3]=true;board[5][3]=false;board[0][2]=false;board[1][2]=true;board[2][2]=true;board[3][2]=false;board[4][2]=true;board[5][2]=true;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(3,2));mission.add(new MissionDots(4,4));mission.add(new MissionDots(5,2));mission.add(new MissionDots(6,1));

        items.add(new GameItem("bomb",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_17(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=false;board[3][5]=true;board[4][5]=true;board[5][5]=true;board[0][4]=false;board[1][4]=true;board[2][4]=false;board[3][4]=true;board[4][4]=false;board[5][4]=true;board[0][3]=false;board[1][3]=true;board[2][3]=false;board[3][3]=false;board[4][3]=false;board[5][3]=true;board[0][2]=false;board[1][2]=true;board[2][2]=false;board[3][2]=false;board[4][2]=false;board[5][2]=true;board[0][1]=false;board[1][1]=true;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=true;board[0][0]=true;board[1][0]=true;board[2][0]=true;board[3][0]=true;board[4][0]=true;board[5][0]=true;

        mission.add(new MissionDots(3,3));mission.add(new MissionDots(4,3));mission.add(new MissionDots(5,2));mission.add(new MissionDots(6,1));

        items.add(new GameItem("missile",6));items.add(new GameItem("lock",40));items.add(new GameItem("magic",4));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_18(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=false;board[2][5]=false;board[3][5]=true;board[4][5]=true;board[5][5]=true;board[0][4]=true;board[1][4]=true;board[2][4]=false;board[3][4]=true;board[4][4]=false;board[5][4]=true;board[0][3]=true;board[1][3]=true;board[2][3]=false;board[3][3]=true;board[4][3]=true;board[5][3]=true;board[0][2]=true;board[1][2]=true;board[2][2]=false;board[3][2]=true;board[4][2]=false;board[5][2]=true;board[0][1]=true;board[1][1]=true;board[2][1]=false;board[3][1]=true;board[4][1]=true;board[5][1]=true;board[0][0]=true;board[1][0]=true;board[2][0]=true;board[3][0]=true;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,3));mission.add(new MissionDots(7,2));mission.add(new MissionDots(8,1));

        items.add(new GameItem("bomb",3));items.add(new GameItem("magic_a",3));items.add(new GameItem("dice_missile",23));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_19(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=false;board[2][5]=true;board[3][5]=true;board[4][5]=true;board[5][5]=false;board[0][4]=false;board[1][4]=false;board[2][4]=true;board[3][4]=false;board[4][4]=true;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=false;board[3][3]=true;board[4][3]=true;board[5][3]=false;board[0][2]=true;board[1][2]=false;board[2][2]=true;board[3][2]=false;board[4][2]=true;board[5][2]=false;board[0][1]=true;board[1][1]=true;board[2][1]=true;board[3][1]=true;board[4][1]=true;board[5][1]=true;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=true;board[5][0]=true;

        mission.add(new MissionDots(4,1));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,3));mission.add(new MissionDots(7,1));

        items.add(new GameItem("rainbow",0));items.add(new GameItem("magic",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_20(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=true;board[3][4]=false;board[4][4]=false;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=false;board[4][3]=false;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=false;board[3][2]=true;board[4][2]=true;board[5][2]=true;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=true;board[4][1]=true;board[5][1]=true;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=true;board[4][0]=true;board[5][0]=true;

        mission.add(new MissionDots(4,2));mission.add(new MissionDots(5,5));mission.add(new MissionDots(6,2));

        items.add(new GameItem("lock",30));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_21(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=false;board[1][4]=false;board[2][4]=true;board[3][4]=false;board[4][4]=true;board[5][4]=true;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=false;board[4][3]=true;board[5][3]=true;board[0][2]=true;board[1][2]=false;board[2][2]=false;board[3][2]=false;board[4][2]=true;board[5][2]=true;board[0][1]=true;board[1][1]=true;board[2][1]=true;board[3][1]=true;board[4][1]=true;board[5][1]=true;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(3,3));mission.add(new MissionDots(4,2));mission.add(new MissionDots(5,2));mission.add(new MissionDots(5,2));

        items.add(new GameItem("missile",10));items.add(new GameItem("lock",40));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_22(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=true;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=false;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=false;board[5][3]=false;board[0][2]=true;board[1][2]=true;board[2][2]=true;board[3][2]=true;board[4][2]=false;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,3));mission.add(new MissionDots(7,2));mission.add(new MissionDots(8,1));

        items.add(new GameItem("rainbow",0));items.add(new GameItem("lock",60));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_23(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=false;board[2][5]=false;board[3][5]=true;board[4][5]=true;board[5][5]=false;board[0][4]=true;board[1][4]=false;board[2][4]=true;board[3][4]=true;board[4][4]=true;board[5][4]=false;board[0][3]=true;board[1][3]=false;board[2][3]=true;board[3][3]=true;board[4][3]=true;board[5][3]=false;board[0][2]=true;board[1][2]=true;board[2][2]=true;board[3][2]=false;board[4][2]=true;board[5][2]=true;board[0][1]=true;board[1][1]=true;board[2][1]=true;board[3][1]=false;board[4][1]=true;board[5][1]=true;board[0][0]=false;board[1][0]=true;board[2][0]=true;board[3][0]=false;board[4][0]=true;board[5][0]=false;

        mission.add(new MissionDots(5,2));mission.add(new MissionDots(6,3));mission.add(new MissionDots(7,3));mission.add(new MissionDots(8,1));

        items.add(new GameItem("lock",20));items.add(new GameItem("bomb",3));items.add(new GameItem("magic",3));items.add(new GameItem("bomb_a",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_24(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=true;board[4][5]=true;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=false;board[3][4]=false;board[4][4]=true;board[5][4]=true;board[0][3]=false;board[1][3]=false;board[2][3]=false;board[3][3]=false;board[4][3]=false;board[5][3]=true;board[0][2]=false;board[1][2]=false;board[2][2]=false;board[3][2]=false;board[4][2]=false;board[5][2]=true;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=true;board[5][1]=true;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=true;board[5][0]=true;

        mission.add(new MissionDots(3,1));mission.add(new MissionDots(4,7));mission.add(new MissionDots(5,1));

        items.add(new GameItem("magic",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_25(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=false;board[2][4]=true;board[3][4]=true;board[4][4]=true;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=false;board[4][3]=true;board[5][3]=false;board[0][2]=false;board[1][2]=true;board[2][2]=false;board[3][2]=true;board[4][2]=true;board[5][2]=true;board[0][1]=false;board[1][1]=true;board[2][1]=true;board[3][1]=true;board[4][1]=false;board[5][1]=true;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=true;board[4][0]=true;board[5][0]=true;

        mission.add(new MissionDots(3,2));mission.add(new MissionDots(4,2));mission.add(new MissionDots(5,4));mission.add(new MissionDots(6,1));

        items.add(new GameItem("bomb",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_26(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=false;board[2][5]=true;board[3][5]=true;board[4][5]=false;board[5][5]=false;board[0][4]=false;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=true;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=false;board[3][3]=false;board[4][3]=true;board[5][3]=true;board[0][2]=true;board[1][2]=true;board[2][2]=false;board[3][2]=false;board[4][2]=true;board[5][2]=true;board[0][1]=false;board[1][1]=true;board[2][1]=true;board[3][1]=true;board[4][1]=true;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=true;board[3][0]=true;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(4,2));mission.add(new MissionDots(5,4));mission.add(new MissionDots(6,2));mission.add(new MissionDots(7,1));

        items.add(new GameItem("rainbow",0));items.add(new GameItem("lock",30));items.add(new GameItem("magic",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_27(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=true;board[2][5]=true;board[3][5]=false;board[4][5]=false;board[5][5]=true;board[0][4]=false;board[1][4]=true;board[2][4]=true;board[3][4]=false;board[4][4]=false;board[5][4]=true;board[0][3]=true;board[1][3]=true;board[2][3]=false;board[3][3]=false;board[4][3]=true;board[5][3]=true;board[0][2]=true;board[1][2]=true;board[2][2]=false;board[3][2]=false;board[4][2]=true;board[5][2]=true;board[0][1]=true;board[1][1]=false;board[2][1]=false;board[3][1]=true;board[4][1]=true;board[5][1]=false;board[0][0]=true;board[1][0]=false;board[2][0]=false;board[3][0]=true;board[4][0]=true;board[5][0]=false;

        mission.add(new MissionDots(3,1));mission.add(new MissionDots(4,3));mission.add(new MissionDots(5,4));mission.add(new MissionDots(6,1));

        items.add(new GameItem("rainbow",0));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_28(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=true;board[2][5]=false;board[3][5]=true;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=true;board[5][4]=false;board[0][3]=false;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=false;board[5][3]=false;board[0][2]=true;board[1][2]=true;board[2][2]=true;board[3][2]=true;board[4][2]=true;board[5][2]=false;board[0][1]=false;board[1][1]=true;board[2][1]=false;board[3][1]=true;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(4,2));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,3));mission.add(new MissionDots(7,1));

        items.add(new GameItem("bomb",4));items.add(new GameItem("lock",150));items.add(new GameItem("magic",4));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_29(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=false;board[2][5]=true;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=false;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=false;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=false;board[3][3]=true;board[4][3]=true;board[5][3]=false;board[0][2]=false;board[1][2]=true;board[2][2]=true;board[3][2]=true;board[4][2]=false;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(3,4));mission.add(new MissionDots(4,3));mission.add(new MissionDots(5,2));

        items.add(new GameItem("magic",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_30(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=true;board[4][5]=true;board[5][5]=true;board[0][4]=true;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=true;board[5][4]=true;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=true;board[5][3]=true;board[0][2]=true;board[1][2]=true;board[2][2]=true;board[3][2]=true;board[4][2]=true;board[5][2]=true;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(6,3));mission.add(new MissionDots(7,2));mission.add(new MissionDots(8,2));mission.add(new MissionDots(9,2));

        items.add(new GameItem("rainbow",0));items.add(new GameItem("lock",5));items.add(new GameItem("dice_missile",20));items.add(new GameItem("magic_a",4));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_31(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=false;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=false;board[3][4]=false;board[4][4]=false;board[5][4]=false;board[0][3]=false;board[1][3]=false;board[2][3]=true;board[3][3]=true;board[4][3]=false;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=true;board[3][2]=true;board[4][2]=false;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=true;board[5][1]=true;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=true;board[5][0]=true;

        mission.add(new MissionDots(2,2));mission.add(new MissionDots(3,5));mission.add(new MissionDots(4,2));

        items.add(new GameItem("magic",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_32(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=false;board[2][5]=false;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=false;board[3][4]=false;board[4][4]=false;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=false;board[3][3]=false;board[4][3]=false;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=false;board[3][2]=false;board[4][2]=true;board[5][2]=true;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=true;board[5][1]=true;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=true;

        mission.add(new MissionDots(3,5));mission.add(new MissionDots(4,3));mission.add(new MissionDots(5,1));

        items.add(new GameItem("bomb",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_33(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=false;board[2][5]=false;board[3][5]=false;board[4][5]=false;board[5][5]=true;board[0][4]=true;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=false;board[5][4]=true;board[0][3]=true;board[1][3]=true;board[2][3]=false;board[3][3]=false;board[4][3]=false;board[5][3]=true;board[0][2]=true;board[1][2]=true;board[2][2]=true;board[3][2]=true;board[4][2]=false;board[5][2]=true;board[0][1]=true;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=true;board[0][0]=true;board[1][0]=true;board[2][0]=true;board[3][0]=true;board[4][0]=true;board[5][0]=true;

        mission.add(new MissionDots(4,2));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,3));mission.add(new MissionDots(7,1));

        items.add(new GameItem("magic",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_34(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=false;board[2][5]=false;board[3][5]=true;board[4][5]=true;board[5][5]=true;board[0][4]=true;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=false;board[5][4]=true;board[0][3]=true;board[1][3]=true;board[2][3]=false;board[3][3]=false;board[4][3]=true;board[5][3]=true;board[0][2]=false;board[1][2]=false;board[2][2]=false;board[3][2]=false;board[4][2]=true;board[5][2]=false;board[0][1]=true;board[1][1]=true;board[2][1]=false;board[3][1]=true;board[4][1]=true;board[5][1]=false;board[0][0]=true;board[1][0]=true;board[2][0]=false;board[3][0]=true;board[4][0]=true;board[5][0]=false;

        mission.add(new MissionDots(3,2));mission.add(new MissionDots(4,3));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,1));

        items.add(new GameItem("missile",7));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_35(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=false;board[2][5]=true;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=false;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=false;board[5][4]=false;board[0][3]=false;board[1][3]=true;board[2][3]=false;board[3][3]=true;board[4][3]=true;board[5][3]=true;board[0][2]=true;board[1][2]=true;board[2][2]=true;board[3][2]=true;board[4][2]=false;board[5][2]=true;board[0][1]=true;board[1][1]=false;board[2][1]=true;board[3][1]=false;board[4][1]=false;board[5][1]=true;board[0][0]=true;board[1][0]=true;board[2][0]=true;board[3][0]=true;board[4][0]=true;board[5][0]=true;

        mission.add(new MissionDots(4,2));mission.add(new MissionDots(5,2));mission.add(new MissionDots(6,4));mission.add(new MissionDots(7,1));

        items.add(new GameItem("magic",3));items.add(new GameItem("bomb",3));items.add(new GameItem("magic_a",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_36(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=false;board[2][5]=false;board[3][5]=true;board[4][5]=false;board[5][5]=true;board[0][4]=true;board[1][4]=true;board[2][4]=false;board[3][4]=true;board[4][4]=false;board[5][4]=true;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=true;board[5][3]=true;board[0][2]=true;board[1][2]=true;board[2][2]=false;board[3][2]=false;board[4][2]=false;board[5][2]=true;board[0][1]=true;board[1][1]=true;board[2][1]=false;board[3][1]=true;board[4][1]=false;board[5][1]=true;board[0][0]=true;board[1][0]=true;board[2][0]=false;board[3][0]=true;board[4][0]=false;board[5][0]=true;

        mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,2));mission.add(new MissionDots(7,3));mission.add(new MissionDots(8,1));

        items.add(new GameItem("bomb",3));items.add(new GameItem("lock",200));items.add(new GameItem("magic",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_37(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=true;board[4][5]=true;board[5][5]=true;board[0][4]=true;board[1][4]=false;board[2][4]=false;board[3][4]=false;board[4][4]=false;board[5][4]=true;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=false;board[5][3]=true;board[0][2]=true;board[1][2]=true;board[2][2]=true;board[3][2]=false;board[4][2]=true;board[5][2]=true;board[0][1]=true;board[1][1]=true;board[2][1]=false;board[3][1]=true;board[4][1]=true;board[5][1]=true;board[0][0]=true;board[1][0]=true;board[2][0]=false;board[3][0]=true;board[4][0]=true;board[5][0]=false;

        mission.add(new MissionDots(5,2));mission.add(new MissionDots(6,3));mission.add(new MissionDots(7,3));mission.add(new MissionDots(8,1));

        items.add(new GameItem("lock",250));items.add(new GameItem("magic",3));items.add(new GameItem("bomb",3));items.add(new GameItem("rainbow",0));items.add(new GameItem("bomb_a",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_38(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=false;board[4][5]=false;board[5][5]=true;board[0][4]=false;board[1][4]=false;board[2][4]=true;board[3][4]=false;board[4][4]=false;board[5][4]=true;board[0][3]=false;board[1][3]=true;board[2][3]=true;board[3][3]=false;board[4][3]=false;board[5][3]=true;board[0][2]=false;board[1][2]=false;board[2][2]=true;board[3][2]=false;board[4][2]=true;board[5][2]=true;board[0][1]=true;board[1][1]=true;board[2][1]=true;board[3][1]=true;board[4][1]=true;board[5][1]=true;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(4,2));mission.add(new MissionDots(5,4));mission.add(new MissionDots(6,2));mission.add(new MissionDots(7,1));

        items.add(new GameItem("bomb",3));items.add(new GameItem("lock",78));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_39(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=false;board[1][4]=false;board[2][4]=true;board[3][4]=true;board[4][4]=false;board[5][4]=false;board[0][3]=false;board[1][3]=false;board[2][3]=true;board[3][3]=true;board[4][3]=false;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=false;board[3][2]=false;board[4][2]=false;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(3,5));mission.add(new MissionDots(4,3));mission.add(new MissionDots(5,1));

        items.add(new GameItem("magic",5));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_40(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=false;board[3][5]=true;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=false;board[5][4]=false;board[0][3]=false;board[1][3]=false;board[2][3]=true;board[3][3]=false;board[4][3]=false;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=true;board[3][2]=false;board[4][2]=false;board[5][2]=false;board[0][1]=false;board[1][1]=true;board[2][1]=true;board[3][1]=true;board[4][1]=true;board[5][1]=false;board[0][0]=false;board[1][0]=true;board[2][0]=false;board[3][0]=true;board[4][0]=true;board[5][0]=false;

        mission.add(new MissionDots(3,3));mission.add(new MissionDots(4,2));mission.add(new MissionDots(5,2));mission.add(new MissionDots(6,2));

        items.add(new GameItem("magic",5));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_41(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=true;board[4][5]=true;board[5][5]=true;board[0][4]=true;board[1][4]=false;board[2][4]=false;board[3][4]=true;board[4][4]=true;board[5][4]=true;board[0][3]=false;board[1][3]=false;board[2][3]=false;board[3][3]=false;board[4][3]=false;board[5][3]=true;board[0][2]=false;board[1][2]=false;board[2][2]=false;board[3][2]=false;board[4][2]=false;board[5][2]=true;board[0][1]=true;board[1][1]=false;board[2][1]=false;board[3][1]=true;board[4][1]=true;board[5][1]=true;board[0][0]=true;board[1][0]=true;board[2][0]=true;board[3][0]=true;board[4][0]=true;board[5][0]=true;

        mission.add(new MissionDots(5,4));mission.add(new MissionDots(6,2));mission.add(new MissionDots(7,2));mission.add(new MissionDots(8,1));

        items.add(new GameItem("missile",10));items.add(new GameItem("lock",100));items.add(new GameItem("rainbow",0));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_42(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=false;board[2][5]=true;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=false;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=false;board[5][4]=false;board[0][3]=false;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=false;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=false;board[3][2]=false;board[4][2]=false;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(3,3));mission.add(new MissionDots(4,3));mission.add(new MissionDots(5,2));mission.add(new MissionDots(6,1));

        items.add(new GameItem("bomb",3));items.add(new GameItem("magic",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_43(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=true;board[2][5]=true;board[3][5]=true;board[4][5]=true;board[5][5]=false;board[0][4]=false;board[1][4]=false;board[2][4]=true;board[3][4]=true;board[4][4]=false;board[5][4]=false;board[0][3]=true;board[1][3]=false;board[2][3]=true;board[3][3]=true;board[4][3]=false;board[5][3]=true;board[0][2]=true;board[1][2]=true;board[2][2]=true;board[3][2]=true;board[4][2]=true;board[5][2]=true;board[0][1]=true;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=true;board[0][0]=true;board[1][0]=true;board[2][0]=false;board[3][0]=false;board[4][0]=true;board[5][0]=true;

        mission.add(new MissionDots(5,1));mission.add(new MissionDots(6,2));mission.add(new MissionDots(7,3));mission.add(new MissionDots(8,1));

        items.add(new GameItem("lock",300));items.add(new GameItem("rainbow",0));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_44(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=false;board[3][5]=false;board[4][5]=true;board[5][5]=true;board[0][4]=true;board[1][4]=false;board[2][4]=false;board[3][4]=false;board[4][4]=false;board[5][4]=true;board[0][3]=true;board[1][3]=false;board[2][3]=true;board[3][3]=true;board[4][3]=false;board[5][3]=true;board[0][2]=true;board[1][2]=true;board[2][2]=true;board[3][2]=true;board[4][2]=true;board[5][2]=true;board[0][1]=false;board[1][1]=true;board[2][1]=false;board[3][1]=false;board[4][1]=true;board[5][1]=false;board[0][0]=false;board[1][0]=true;board[2][0]=false;board[3][0]=false;board[4][0]=true;board[5][0]=false;

        mission.add(new MissionDots(3,3));mission.add(new MissionDots(4,2));mission.add(new MissionDots(5,2));mission.add(new MissionDots(6,2));

        items.add(new GameItem("bomb",3));items.add(new GameItem("lock",135));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_45(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=false;board[3][5]=true;board[4][5]=false;board[5][5]=false;board[0][4]=false;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=false;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=false;board[4][3]=false;board[5][3]=false;board[0][2]=true;board[1][2]=false;board[2][2]=true;board[3][2]=true;board[4][2]=false;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(3,2));mission.add(new MissionDots(4,3));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,1));

        items.add(new GameItem("bomb",3));items.add(new GameItem("magic",3));items.add(new GameItem("lock",80));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_46(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=true;board[2][5]=true;board[3][5]=true;board[4][5]=false;board[5][5]=false;board[0][4]=false;board[1][4]=true;board[2][4]=false;board[3][4]=true;board[4][4]=false;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=true;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=true;board[3][2]=false;board[4][2]=false;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(3,1));mission.add(new MissionDots(4,5));mission.add(new MissionDots(5,2));mission.add(new MissionDots(6,1));

        items.add(new GameItem("bomb",3));items.add(new GameItem("magic",3));items.add(new GameItem("lock",80));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_47(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=false;board[2][5]=true;board[3][5]=true;board[4][5]=false;board[5][5]=false;board[0][4]=false;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=true;board[5][4]=false;board[0][3]=false;board[1][3]=true;board[2][3]=false;board[3][3]=false;board[4][3]=true;board[5][3]=false;board[0][2]=false;board[1][2]=true;board[2][2]=true;board[3][2]=true;board[4][2]=true;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(3,4));mission.add(new MissionDots(4,2));mission.add(new MissionDots(5,2));mission.add(new MissionDots(6,1));

        items.add(new GameItem("rainbow",0));items.add(new GameItem("lock",100));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_48(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=true;board[2][5]=true;board[3][5]=true;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=false;board[2][4]=false;board[3][4]=true;board[4][4]=false;board[5][4]=false;board[0][3]=true;board[1][3]=false;board[2][3]=true;board[3][3]=true;board[4][3]=false;board[5][3]=true;board[0][2]=true;board[1][2]=true;board[2][2]=true;board[3][2]=false;board[4][2]=false;board[5][2]=true;board[0][1]=false;board[1][1]=true;board[2][1]=true;board[3][1]=true;board[4][1]=true;board[5][1]=true;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(4,3));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,2));mission.add(new MissionDots(7,1));

        items.add(new GameItem("bomb",3));items.add(new GameItem("lock",120));items.add(new GameItem("rainbow",0));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_49(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=false;board[3][5]=false;board[4][5]=true;board[5][5]=true;board[0][4]=true;board[1][4]=true;board[2][4]=false;board[3][4]=false;board[4][4]=true;board[5][4]=true;board[0][3]=false;board[1][3]=false;board[2][3]=true;board[3][3]=true;board[4][3]=false;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=true;board[3][2]=true;board[4][2]=false;board[5][2]=false;board[0][1]=true;board[1][1]=true;board[2][1]=false;board[3][1]=false;board[4][1]=true;board[5][1]=true;board[0][0]=true;board[1][0]=true;board[2][0]=false;board[3][0]=false;board[4][0]=true;board[5][0]=true;

        mission.add(new MissionDots(3,5));mission.add(new MissionDots(4,4));



        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_50(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=true;board[4][5]=true;board[5][5]=true;board[0][4]=true;board[1][4]=true;board[2][4]=false;board[3][4]=false;board[4][4]=true;board[5][4]=true;board[0][3]=true;board[1][3]=false;board[2][3]=true;board[3][3]=true;board[4][3]=false;board[5][3]=true;board[0][2]=true;board[1][2]=false;board[2][2]=true;board[3][2]=true;board[4][2]=false;board[5][2]=true;board[0][1]=true;board[1][1]=true;board[2][1]=false;board[3][1]=false;board[4][1]=true;board[5][1]=true;board[0][0]=true;board[1][0]=true;board[2][0]=true;board[3][0]=true;board[4][0]=true;board[5][0]=true;

        mission.add(new MissionDots(4,2));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,3));mission.add(new MissionDots(7,1));

        items.add(new GameItem("bomb",3));items.add(new GameItem("lock",270));items.add(new GameItem("rainbow",0));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_51(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=true;board[2][5]=true;board[3][5]=true;board[4][5]=false;board[5][5]=false;board[0][4]=false;board[1][4]=false;board[2][4]=true;board[3][4]=false;board[4][4]=false;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=false;board[3][3]=true;board[4][3]=true;board[5][3]=false;board[0][2]=true;board[1][2]=true;board[2][2]=true;board[3][2]=true;board[4][2]=true;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=true;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=true;board[2][0]=true;board[3][0]=true;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(3,2));mission.add(new MissionDots(4,3));mission.add(new MissionDots(5,2));mission.add(new MissionDots(6,2));

        items.add(new GameItem("bomb",3));items.add(new GameItem("lock",150));items.add(new GameItem("magic",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_52(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=false;board[3][5]=false;board[4][5]=true;board[5][5]=true;board[0][4]=true;board[1][4]=true;board[2][4]=true;board[3][4]=false;board[4][4]=true;board[5][4]=true;board[0][3]=false;board[1][3]=false;board[2][3]=true;board[3][3]=true;board[4][3]=true;board[5][3]=false;board[0][2]=false;board[1][2]=true;board[2][2]=true;board[3][2]=true;board[4][2]=false;board[5][2]=false;board[0][1]=true;board[1][1]=true;board[2][1]=false;board[3][1]=true;board[4][1]=true;board[5][1]=true;board[0][0]=true;board[1][0]=true;board[2][0]=false;board[3][0]=false;board[4][0]=true;board[5][0]=true;

        mission.add(new MissionDots(5,6));mission.add(new MissionDots(6,2));mission.add(new MissionDots(7,1));

        items.add(new GameItem("magic",6));items.add(new GameItem("lock",180));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_53(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=false;board[3][5]=false;board[4][5]=true;board[5][5]=true;board[0][4]=true;board[1][4]=false;board[2][4]=true;board[3][4]=true;board[4][4]=false;board[5][4]=true;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=true;board[5][3]=true;board[0][2]=true;board[1][2]=false;board[2][2]=true;board[3][2]=true;board[4][2]=false;board[5][2]=true;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(4,2));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,3));mission.add(new MissionDots(7,1));

        items.add(new GameItem("bomb",3));items.add(new GameItem("magic",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_54(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=false;board[3][5]=false;board[4][5]=true;board[5][5]=true;board[0][4]=true;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=true;board[5][4]=true;board[0][3]=false;board[1][3]=true;board[2][3]=false;board[3][3]=false;board[4][3]=true;board[5][3]=false;board[0][2]=false;board[1][2]=true;board[2][2]=true;board[3][2]=true;board[4][2]=true;board[5][2]=false;board[0][1]=false;board[1][1]=true;board[2][1]=false;board[3][1]=false;board[4][1]=true;board[5][1]=false;board[0][0]=false;board[1][0]=true;board[2][0]=true;board[3][0]=true;board[4][0]=true;board[5][0]=false;

        mission.add(new MissionDots(6,1));mission.add(new MissionDots(7,5));mission.add(new MissionDots(8,2));mission.add(new MissionDots(9,1));

        items.add(new GameItem("bomb",3));items.add(new GameItem("lock",350));items.add(new GameItem("magic",4));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_55(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=false;board[2][5]=false;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=true;board[3][4]=false;board[4][4]=false;board[5][4]=false;board[0][3]=false;board[1][3]=true;board[2][3]=true;board[3][3]=false;board[4][3]=false;board[5][3]=false;board[0][2]=false;board[1][2]=true;board[2][2]=true;board[3][2]=true;board[4][2]=true;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=true;board[4][1]=true;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=true;board[4][0]=true;board[5][0]=true;

        mission.add(new MissionDots(4,2));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,3));mission.add(new MissionDots(7,1));

        items.add(new GameItem("bomb",3));items.add(new GameItem("rainbow",0));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_56(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=false;board[2][5]=true;board[3][5]=true;board[4][5]=false;board[5][5]=false;board[0][4]=false;board[1][4]=false;board[2][4]=true;board[3][4]=true;board[4][4]=false;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=true;board[5][3]=true;board[0][2]=false;board[1][2]=false;board[2][2]=true;board[3][2]=true;board[4][2]=false;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(4,3));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,2));mission.add(new MissionDots(7,1));

        items.add(new GameItem("magic",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_57(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=false;board[2][5]=false;board[3][5]=true;board[4][5]=true;board[5][5]=true;board[0][4]=true;board[1][4]=false;board[2][4]=true;board[3][4]=true;board[4][4]=false;board[5][4]=true;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=true;board[5][3]=true;board[0][2]=false;board[1][2]=true;board[2][2]=false;board[3][2]=false;board[4][2]=true;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=true;board[3][1]=true;board[4][1]=true;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=true;board[3][0]=true;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(4,2));mission.add(new MissionDots(5,2));mission.add(new MissionDots(6,4));mission.add(new MissionDots(7,1));

        items.add(new GameItem("missile",7));items.add(new GameItem("rainbow",0));items.add(new GameItem("lock",200));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_58(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=false;board[2][5]=false;board[3][5]=false;board[4][5]=false;board[5][5]=true;board[0][4]=true;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=true;board[5][4]=true;board[0][3]=false;board[1][3]=false;board[2][3]=true;board[3][3]=false;board[4][3]=true;board[5][3]=false;board[0][2]=true;board[1][2]=true;board[2][2]=true;board[3][2]=true;board[4][2]=true;board[5][2]=true;board[0][1]=true;board[1][1]=true;board[2][1]=false;board[3][1]=true;board[4][1]=false;board[5][1]=true;board[0][0]=true;board[1][0]=true;board[2][0]=true;board[3][0]=true;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(4,2));mission.add(new MissionDots(5,1));mission.add(new MissionDots(6,4));mission.add(new MissionDots(7,2));

        items.add(new GameItem("lock",280));items.add(new GameItem("rainbow",0));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_59(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=false;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=true;board[3][4]=false;board[4][4]=true;board[5][4]=true;board[0][3]=true;board[1][3]=true;board[2][3]=false;board[3][3]=true;board[4][3]=true;board[5][3]=true;board[0][2]=false;board[1][2]=false;board[2][2]=false;board[3][2]=false;board[4][2]=true;board[5][2]=true;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(3,2));mission.add(new MissionDots(4,2));mission.add(new MissionDots(5,4));mission.add(new MissionDots(6,1));

        items.add(new GameItem("magic",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_60(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=true;board[4][5]=true;board[5][5]=true;board[0][4]=true;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=true;board[5][4]=true;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=true;board[5][3]=true;board[0][2]=true;board[1][2]=true;board[2][2]=true;board[3][2]=true;board[4][2]=true;board[5][2]=true;board[0][1]=true;board[1][1]=true;board[2][1]=true;board[3][1]=true;board[4][1]=true;board[5][1]=true;board[0][0]=true;board[1][0]=true;board[2][0]=true;board[3][0]=true;board[4][0]=true;board[5][0]=true;

        mission.add(new MissionDots(6,2));mission.add(new MissionDots(7,2));mission.add(new MissionDots(8,2));mission.add(new MissionDots(9,2));

        items.add(new GameItem("bomb_a",3));items.add(new GameItem("lock",10));items.add(new GameItem("rainbow_a",0));items.add(new GameItem("magic_a",4));items.add(new GameItem("missile_a",18));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_61(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=false;board[2][5]=true;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=false;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=true;board[5][4]=false;board[0][3]=false;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=false;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=false;board[3][2]=false;board[4][2]=false;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(3,2));mission.add(new MissionDots(4,3));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,1));

        items.add(new GameItem("magic",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_62(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=false;board[2][5]=true;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=false;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=true;board[5][4]=false;board[0][3]=false;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=false;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=false;board[3][2]=true;board[4][2]=false;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(3,2));mission.add(new MissionDots(4,3));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,1));

        items.add(new GameItem("magic",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_63(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=false;board[2][5]=true;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=true;board[5][4]=false;board[0][3]=false;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=false;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=true;board[3][2]=false;board[4][2]=false;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(4,2));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,2));mission.add(new MissionDots(7,1));

        items.add(new GameItem("bomb",3));items.add(new GameItem("magic",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_64(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=true;board[2][5]=true;board[3][5]=true;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=false;board[3][4]=true;board[4][4]=true;board[5][4]=false;board[0][3]=false;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=false;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=false;board[3][2]=false;board[4][2]=false;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(3,2));mission.add(new MissionDots(4,4));mission.add(new MissionDots(5,2));mission.add(new MissionDots(6,1));

        items.add(new GameItem("magic",3));items.add(new GameItem("bomb",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_65(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=true;board[2][5]=false;board[3][5]=true;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=false;board[3][4]=true;board[4][4]=true;board[5][4]=false;board[0][3]=false;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=false;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=true;board[3][2]=false;board[4][2]=false;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(3,4));mission.add(new MissionDots(4,2));mission.add(new MissionDots(5,1));

        items.add(new GameItem("magic",4));items.add(new GameItem("missile",8));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_66(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=false;board[2][5]=false;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=false;board[5][4]=false;board[0][3]=false;board[1][3]=true;board[2][3]=false;board[3][3]=true;board[4][3]=true;board[5][3]=false;board[0][2]=false;board[1][2]=true;board[2][2]=true;board[3][2]=true;board[4][2]=false;board[5][2]=false;board[0][1]=false;board[1][1]=true;board[2][1]=false;board[3][1]=true;board[4][1]=true;board[5][1]=true;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=true;

        mission.add(new MissionDots(4,3));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,2));mission.add(new MissionDots(7,1));

        items.add(new GameItem("bomb",3));items.add(new GameItem("lock",135));items.add(new GameItem("magic",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_67(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=false;board[1][4]=false;board[2][4]=true;board[3][4]=false;board[4][4]=false;board[5][4]=false;board[0][3]=false;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=true;board[5][3]=false;board[0][2]=false;board[1][2]=true;board[2][2]=false;board[3][2]=true;board[4][2]=false;board[5][2]=false;board[0][1]=false;board[1][1]=true;board[2][1]=false;board[3][1]=true;board[4][1]=true;board[5][1]=true;board[0][0]=false;board[1][0]=true;board[2][0]=true;board[3][0]=true;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(3,2));mission.add(new MissionDots(4,2));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,2));

        items.add(new GameItem("bomb",3));items.add(new GameItem("lock",25));items.add(new GameItem("magic",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_68(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=true;board[4][5]=true;board[5][5]=true;board[0][4]=true;board[1][4]=true;board[2][4]=false;board[3][4]=false;board[4][4]=false;board[5][4]=true;board[0][3]=false;board[1][3]=true;board[2][3]=false;board[3][3]=true;board[4][3]=true;board[5][3]=true;board[0][2]=false;board[1][2]=true;board[2][2]=false;board[3][2]=false;board[4][2]=false;board[5][2]=true;board[0][1]=false;board[1][1]=true;board[2][1]=true;board[3][1]=true;board[4][1]=false;board[5][1]=true;board[0][0]=false;board[1][0]=true;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=true;

        mission.add(new MissionDots(4,2));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,3));mission.add(new MissionDots(7,1));

        items.add(new GameItem("rainbow",0));items.add(new GameItem("bomb",3));items.add(new GameItem("lock",200));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_69(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=false;board[2][5]=true;board[3][5]=true;board[4][5]=true;board[5][5]=true;board[0][4]=true;board[1][4]=false;board[2][4]=true;board[3][4]=false;board[4][4]=true;board[5][4]=true;board[0][3]=true;board[1][3]=false;board[2][3]=true;board[3][3]=false;board[4][3]=true;board[5][3]=true;board[0][2]=true;board[1][2]=true;board[2][2]=true;board[3][2]=false;board[4][2]=false;board[5][2]=false;board[0][1]=true;board[1][1]=false;board[2][1]=true;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=true;board[1][0]=true;board[2][0]=true;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(4,3));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,2));mission.add(new MissionDots(7,1));

        items.add(new GameItem("bomb",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_70(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=false;board[2][5]=false;board[3][5]=true;board[4][5]=true;board[5][5]=true;board[0][4]=true;board[1][4]=true;board[2][4]=false;board[3][4]=true;board[4][4]=false;board[5][4]=true;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=false;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=true;board[3][2]=true;board[4][2]=true;board[5][2]=true;board[0][1]=true;board[1][1]=false;board[2][1]=true;board[3][1]=false;board[4][1]=true;board[5][1]=true;board[0][0]=true;board[1][0]=true;board[2][0]=true;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(4,2));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,3));mission.add(new MissionDots(7,1));

        items.add(new GameItem("bomb",3));items.add(new GameItem("lock",160));items.add(new GameItem("magic",4));items.add(new GameItem("missile",10));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_71(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=true;board[2][5]=true;board[3][5]=false;board[4][5]=true;board[5][5]=true;board[0][4]=false;board[1][4]=true;board[2][4]=true;board[3][4]=false;board[4][4]=true;board[5][4]=true;board[0][3]=false;board[1][3]=false;board[2][3]=true;board[3][3]=false;board[4][3]=false;board[5][3]=true;board[0][2]=false;board[1][2]=false;board[2][2]=true;board[3][2]=true;board[4][2]=true;board[5][2]=true;board[0][1]=true;board[1][1]=false;board[2][1]=true;board[3][1]=false;board[4][1]=true;board[5][1]=false;board[0][0]=true;board[1][0]=true;board[2][0]=true;board[3][0]=true;board[4][0]=true;board[5][0]=false;

        mission.add(new MissionDots(4,2));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,3));mission.add(new MissionDots(7,1));

        items.add(new GameItem("bomb",3));items.add(new GameItem("rainbow",0));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_72(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=true;board[4][5]=true;board[5][5]=true;board[0][4]=true;board[1][4]=false;board[2][4]=false;board[3][4]=false;board[4][4]=false;board[5][4]=true;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=false;board[5][3]=true;board[0][2]=true;board[1][2]=true;board[2][2]=false;board[3][2]=true;board[4][2]=false;board[5][2]=true;board[0][1]=true;board[1][1]=true;board[2][1]=false;board[3][1]=true;board[4][1]=true;board[5][1]=true;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(5,6));mission.add(new MissionDots(6,2));mission.add(new MissionDots(7,1));

        items.add(new GameItem("bomb",3));items.add(new GameItem("lock",160));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_73(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=true;board[2][5]=true;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=true;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=false;board[3][3]=false;board[4][3]=true;board[5][3]=false;board[0][2]=false;board[1][2]=true;board[2][2]=false;board[3][2]=false;board[4][2]=true;board[5][2]=true;board[0][1]=false;board[1][1]=true;board[2][1]=true;board[3][1]=true;board[4][1]=true;board[5][1]=true;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=true;board[4][0]=true;board[5][0]=false;

        mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,3));mission.add(new MissionDots(7,2));mission.add(new MissionDots(8,1));

        items.add(new GameItem("bomb",3));items.add(new GameItem("magic",3));items.add(new GameItem("bomb",3));items.add(new GameItem("lock",60));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_74(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=false;board[2][5]=false;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=true;board[3][4]=false;board[4][4]=false;board[5][4]=false;board[0][3]=false;board[1][3]=false;board[2][3]=true;board[3][3]=true;board[4][3]=true;board[5][3]=true;board[0][2]=false;board[1][2]=true;board[2][2]=true;board[3][2]=false;board[4][2]=false;board[5][2]=true;board[0][1]=true;board[1][1]=true;board[2][1]=true;board[3][1]=false;board[4][1]=false;board[5][1]=true;board[0][0]=false;board[1][0]=false;board[2][0]=true;board[3][0]=true;board[4][0]=true;board[5][0]=true;

        mission.add(new MissionDots(4,3));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,2));mission.add(new MissionDots(7,1));

        items.add(new GameItem("magic",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_75(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=true;board[2][5]=true;board[3][5]=true;board[4][5]=true;board[5][5]=false;board[0][4]=false;board[1][4]=true;board[2][4]=false;board[3][4]=false;board[4][4]=true;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=true;board[5][3]=true;board[0][2]=true;board[1][2]=false;board[2][2]=true;board[3][2]=true;board[4][2]=false;board[5][2]=true;board[0][1]=true;board[1][1]=true;board[2][1]=true;board[3][1]=true;board[4][1]=true;board[5][1]=true;board[0][0]=false;board[1][0]=true;board[2][0]=false;board[3][0]=false;board[4][0]=true;board[5][0]=false;

        mission.add(new MissionDots(6,2));mission.add(new MissionDots(7,3));mission.add(new MissionDots(8,2));mission.add(new MissionDots(9,1));

        items.add(new GameItem("bomb",3));items.add(new GameItem("lock",360));items.add(new GameItem("magic",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_76(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=true;board[2][5]=false;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=true;board[3][4]=false;board[4][4]=false;board[5][4]=false;board[0][3]=false;board[1][3]=false;board[2][3]=true;board[3][3]=true;board[4][3]=true;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=true;board[3][2]=true;board[4][2]=true;board[5][2]=false;board[0][1]=true;board[1][1]=true;board[2][1]=true;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=true;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(4,4));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,2));

        items.add(new GameItem("lock",80));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_77(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=false;board[2][5]=false;board[3][5]=false;board[4][5]=false;board[5][5]=true;board[0][4]=true;board[1][4]=false;board[2][4]=true;board[3][4]=true;board[4][4]=false;board[5][4]=true;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=true;board[5][3]=true;board[0][2]=false;board[1][2]=true;board[2][2]=false;board[3][2]=false;board[4][2]=true;board[5][2]=false;board[0][1]=false;board[1][1]=true;board[2][1]=false;board[3][1]=false;board[4][1]=true;board[5][1]=false;board[0][0]=false;board[1][0]=true;board[2][0]=true;board[3][0]=false;board[4][0]=true;board[5][0]=true;

        mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,2));mission.add(new MissionDots(7,2));mission.add(new MissionDots(8,1));

        items.add(new GameItem("lock",3));items.add(new GameItem("bomb",3));items.add(new GameItem("rainbow",0));items.add(new GameItem("missile",10));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_78(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=true;board[3][4]=false;board[4][4]=false;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=false;board[4][3]=false;board[5][3]=false;board[0][2]=true;board[1][2]=true;board[2][2]=true;board[3][2]=false;board[4][2]=false;board[5][2]=false;board[0][1]=true;board[1][1]=true;board[2][1]=true;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=true;board[1][0]=true;board[2][0]=true;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(6,2));mission.add(new MissionDots(7,2));mission.add(new MissionDots(8,4));mission.add(new MissionDots(9,1));

        items.add(new GameItem("rainbow",0));items.add(new GameItem("lock",18));items.add(new GameItem("bomb",4));items.add(new GameItem("magic",4));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_79(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=false;board[2][5]=true;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=false;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=true;board[5][4]=false;board[0][3]=false;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=false;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=true;board[3][2]=false;board[4][2]=false;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(3,2));mission.add(new MissionDots(4,2));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,2));

        items.add(new GameItem("lock",10));items.add(new GameItem("bomb_a",3));items.add(new GameItem("bomb",3));items.add(new GameItem("magic_a",3));items.add(new GameItem("magic",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_80(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=true;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=false;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=false;board[5][3]=false;board[0][2]=true;board[1][2]=true;board[2][2]=true;board[3][2]=true;board[4][2]=false;board[5][2]=false;board[0][1]=true;board[1][1]=true;board[2][1]=true;board[3][1]=true;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(6,2));mission.add(new MissionDots(7,2));mission.add(new MissionDots(8,2));mission.add(new MissionDots(9,3));

        items.add(new GameItem("magic_a",3));items.add(new GameItem("lock",150));items.add(new GameItem("bomb_a",3));items.add(new GameItem("bomb",3));items.add(new GameItem("magic",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_81(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=true;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=false;board[2][4]=true;board[3][4]=true;board[4][4]=true;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=false;board[3][3]=true;board[4][3]=true;board[5][3]=true;board[0][2]=true;board[1][2]=true;board[2][2]=true;board[3][2]=false;board[4][2]=true;board[5][2]=true;board[0][1]=false;board[1][1]=true;board[2][1]=true;board[3][1]=true;board[4][1]=false;board[5][1]=true;board[0][0]=false;board[1][0]=false;board[2][0]=true;board[3][0]=true;board[4][0]=true;board[5][0]=true;

        mission.add(new MissionDots(5,2));mission.add(new MissionDots(6,3));mission.add(new MissionDots(7,3));mission.add(new MissionDots(8,1));

        items.add(new GameItem("dice_missile",60));items.add(new GameItem("lock",50));items.add(new GameItem("bomb",4));items.add(new GameItem("magic_a",4));items.add(new GameItem("rainbow",0));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_82(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=false;board[2][5]=false;board[3][5]=true;board[4][5]=false;board[5][5]=false;board[0][4]=false;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=true;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=false;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=false;board[3][2]=false;board[4][2]=false;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(4,3));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,2));mission.add(new MissionDots(7,1));

        items.add(new GameItem("lock",3));items.add(new GameItem("bomb_a",3));items.add(new GameItem("magic",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_83(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=true;board[2][5]=false;board[3][5]=true;board[4][5]=false;board[5][5]=false;board[0][4]=false;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=true;board[5][4]=false;board[0][3]=false;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=false;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=false;board[3][2]=false;board[4][2]=false;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(3,2));mission.add(new MissionDots(4,3));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,1));



        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_84(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=true;board[4][5]=true;board[5][5]=true;board[0][4]=true;board[1][4]=false;board[2][4]=false;board[3][4]=false;board[4][4]=false;board[5][4]=true;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=false;board[5][3]=true;board[0][2]=false;board[1][2]=false;board[2][2]=true;board[3][2]=true;board[4][2]=true;board[5][2]=true;board[0][1]=true;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=true;board[5][1]=false;board[0][0]=true;board[1][0]=true;board[2][0]=true;board[3][0]=true;board[4][0]=true;board[5][0]=false;

        mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,3));mission.add(new MissionDots(7,2));mission.add(new MissionDots(8,1));

        items.add(new GameItem("lock",24));items.add(new GameItem("dice_missile",50));items.add(new GameItem("bomb",3));items.add(new GameItem("magic",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_85(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=true;board[2][5]=false;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=false;board[1][4]=true;board[2][4]=false;board[3][4]=false;board[4][4]=false;board[5][4]=false;board[0][3]=false;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=true;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=false;board[3][2]=true;board[4][2]=true;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=true;board[3][1]=true;board[4][1]=false;board[5][1]=false;board[0][0]=true;board[1][0]=true;board[2][0]=true;board[3][0]=true;board[4][0]=true;board[5][0]=true;

        mission.add(new MissionDots(4,3));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,2));mission.add(new MissionDots(7,1));



        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_86(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=true;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=false;board[2][4]=false;board[3][4]=true;board[4][4]=false;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=false;board[5][3]=false;board[0][2]=true;board[1][2]=false;board[2][2]=false;board[3][2]=true;board[4][2]=true;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=true;board[4][1]=true;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(4,3));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,2));mission.add(new MissionDots(7,1));

        items.add(new GameItem("magic",3));items.add(new GameItem("magic",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_87(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=true;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=false;board[3][4]=true;board[4][4]=true;board[5][4]=false;board[0][3]=false;board[1][3]=false;board[2][3]=false;board[3][3]=false;board[4][3]=true;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=true;board[3][2]=true;board[4][2]=true;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=true;board[3][1]=true;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(4,2));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,3));mission.add(new MissionDots(7,1));

        items.add(new GameItem("bomb",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_88(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=false;board[2][5]=false;board[3][5]=false;board[4][5]=true;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=false;board[3][4]=true;board[4][4]=true;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=false;board[3][3]=true;board[4][3]=true;board[5][3]=false;board[0][2]=false;board[1][2]=true;board[2][2]=false;board[3][2]=true;board[4][2]=false;board[5][2]=false;board[0][1]=false;board[1][1]=true;board[2][1]=false;board[3][1]=true;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=true;board[2][0]=true;board[3][0]=true;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(4,2));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,3));mission.add(new MissionDots(7,1));

        items.add(new GameItem("rainbow",0));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_89(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=true;board[2][5]=false;board[3][5]=false;board[4][5]=true;board[5][5]=false;board[0][4]=false;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=true;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=false;board[3][3]=false;board[4][3]=true;board[5][3]=true;board[0][2]=true;board[1][2]=true;board[2][2]=false;board[3][2]=false;board[4][2]=true;board[5][2]=true;board[0][1]=false;board[1][1]=true;board[2][1]=true;board[3][1]=true;board[4][1]=true;board[5][1]=false;board[0][0]=false;board[1][0]=true;board[2][0]=false;board[3][0]=false;board[4][0]=true;board[5][0]=false;

        mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,3));mission.add(new MissionDots(7,2));mission.add(new MissionDots(8,1));

        items.add(new GameItem("dice_missile",20));items.add(new GameItem("magic",3));items.add(new GameItem("bomb_a",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_90(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=true;board[3][4]=false;board[4][4]=false;board[5][4]=false;board[0][3]=false;board[1][3]=false;board[2][3]=true;board[3][3]=true;board[4][3]=true;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=true;board[3][2]=true;board[4][2]=true;board[5][2]=false;board[0][1]=true;board[1][1]=true;board[2][1]=true;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=true;board[1][0]=true;board[2][0]=true;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(5,2));mission.add(new MissionDots(6,2));mission.add(new MissionDots(7,3));mission.add(new MissionDots(8,2));

        items.add(new GameItem("bomb",3));items.add(new GameItem("magic",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_91(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=false;board[2][4]=false;board[3][4]=true;board[4][4]=true;board[5][4]=true;board[0][3]=true;board[1][3]=false;board[2][3]=true;board[3][3]=true;board[4][3]=false;board[5][3]=true;board[0][2]=true;board[1][2]=false;board[2][2]=true;board[3][2]=true;board[4][2]=false;board[5][2]=true;board[0][1]=true;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=true;board[0][0]=true;board[1][0]=true;board[2][0]=true;board[3][0]=true;board[4][0]=true;board[5][0]=true;

        mission.add(new MissionDots(4,2));mission.add(new MissionDots(5,2));mission.add(new MissionDots(6,4));mission.add(new MissionDots(7,1));

        items.add(new GameItem("bomb",3));items.add(new GameItem("rainbow",0));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_92(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=true;board[3][4]=false;board[4][4]=false;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=false;board[4][3]=false;board[5][3]=false;board[0][2]=false;board[1][2]=true;board[2][2]=false;board[3][2]=false;board[4][2]=false;board[5][2]=false;board[0][1]=false;board[1][1]=true;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=true;board[2][0]=true;board[3][0]=true;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(5,1));mission.add(new MissionDots(6,5));mission.add(new MissionDots(7,2));mission.add(new MissionDots(8,1));

        items.add(new GameItem("magic",3));items.add(new GameItem("bomb_a",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_93(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=true;board[4][5]=true;board[5][5]=false;board[0][4]=true;board[1][4]=false;board[2][4]=true;board[3][4]=false;board[4][4]=true;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=false;board[4][3]=true;board[5][3]=false;board[0][2]=true;board[1][2]=false;board[2][2]=false;board[3][2]=true;board[4][2]=true;board[5][2]=true;board[0][1]=true;board[1][1]=true;board[2][1]=true;board[3][1]=true;board[4][1]=false;board[5][1]=true;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=true;board[4][0]=true;board[5][0]=true;

        mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,2));mission.add(new MissionDots(7,3));mission.add(new MissionDots(8,1));

        items.add(new GameItem("bomb",3));items.add(new GameItem("magic_a",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_94(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=false;board[3][4]=false;board[4][4]=false;board[5][4]=false;board[0][3]=true;board[1][3]=false;board[2][3]=true;board[3][3]=true;board[4][3]=false;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=true;board[3][2]=true;board[4][2]=false;board[5][2]=true;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=true;board[5][1]=true;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=true;board[4][0]=true;board[5][0]=true;

        mission.add(new MissionDots(4,4));mission.add(new MissionDots(5,4));mission.add(new MissionDots(6,1));

        items.add(new GameItem("magic",3));items.add(new GameItem("bomb",3));items.add(new GameItem("magic_a",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_95(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=false;board[2][5]=false;board[3][5]=true;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=false;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=false;board[5][3]=false;board[0][2]=true;board[1][2]=true;board[2][2]=true;board[3][2]=true;board[4][2]=false;board[5][2]=false;board[0][1]=false;board[1][1]=true;board[2][1]=true;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(7,3));mission.add(new MissionDots(8,2));mission.add(new MissionDots(9,4));

        items.add(new GameItem("dice_missile",50));items.add(new GameItem("lock",48));items.add(new GameItem("rainbow",0));items.add(new GameItem("magic_a",4));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_96(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=false;board[2][5]=false;board[3][5]=true;board[4][5]=false;board[5][5]=false;board[0][4]=false;board[1][4]=false;board[2][4]=false;board[3][4]=true;board[4][4]=false;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=false;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=true;board[3][2]=true;board[4][2]=true;board[5][2]=true;board[0][1]=false;board[1][1]=false;board[2][1]=true;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=true;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,3));mission.add(new MissionDots(7,2));mission.add(new MissionDots(8,1));

        items.add(new GameItem("bomb",4));items.add(new GameItem("rainbow",0));items.add(new GameItem("magic_a",4));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_97(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=true;board[2][5]=true;board[3][5]=true;board[4][5]=false;board[5][5]=false;board[0][4]=false;board[1][4]=true;board[2][4]=false;board[3][4]=true;board[4][4]=true;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=false;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=true;board[3][2]=true;board[4][2]=true;board[5][2]=true;board[0][1]=false;board[1][1]=true;board[2][1]=true;board[3][1]=false;board[4][1]=true;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=true;board[3][0]=true;board[4][0]=true;board[5][0]=false;

        mission.add(new MissionDots(5,4));mission.add(new MissionDots(6,2));mission.add(new MissionDots(7,2));mission.add(new MissionDots(8,1));

        items.add(new GameItem("bomb",3));items.add(new GameItem("magic",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_98(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=false;board[2][5]=true;board[3][5]=true;board[4][5]=true;board[5][5]=true;board[0][4]=true;board[1][4]=true;board[2][4]=false;board[3][4]=false;board[4][4]=true;board[5][4]=true;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=true;board[5][3]=true;board[0][2]=true;board[1][2]=true;board[2][2]=true;board[3][2]=true;board[4][2]=true;board[5][2]=true;board[0][1]=true;board[1][1]=true;board[2][1]=false;board[3][1]=false;board[4][1]=true;board[5][1]=true;board[0][0]=true;board[1][0]=true;board[2][0]=true;board[3][0]=true;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(6,1));mission.add(new MissionDots(7,2));mission.add(new MissionDots(8,2));mission.add(new MissionDots(9,4));

        items.add(new GameItem("lock",160));items.add(new GameItem("dice_missile",150));items.add(new GameItem("rainbow",0));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_99(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=false;board[2][5]=false;board[3][5]=false;board[4][5]=false;board[5][5]=true;board[0][4]=false;board[1][4]=true;board[2][4]=false;board[3][4]=false;board[4][4]=false;board[5][4]=true;board[0][3]=true;board[1][3]=true;board[2][3]=false;board[3][3]=false;board[4][3]=true;board[5][3]=true;board[0][2]=true;board[1][2]=true;board[2][2]=true;board[3][2]=true;board[4][2]=true;board[5][2]=true;board[0][1]=true;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=true;board[5][1]=false;board[0][0]=true;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(4,3));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,2));mission.add(new MissionDots(7,1));

        items.add(new GameItem("magic_a",3));items.add(new GameItem("bomb",3));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_100(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=true;board[4][5]=true;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=true;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=true;board[5][3]=false;board[0][2]=true;board[1][2]=false;board[2][2]=false;board[3][2]=false;board[4][2]=true;board[5][2]=false;board[0][1]=true;board[1][1]=true;board[2][1]=true;board[3][1]=true;board[4][1]=true;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(6,1));mission.add(new MissionDots(7,1));mission.add(new MissionDots(8,3));mission.add(new MissionDots(9,4));

        items.add(new GameItem("lock",300));items.add(new GameItem("dice_missile",400));items.add(new GameItem("rainbow",0));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}

    private static Level getLevel_101(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=false;board[1][5]=false;board[2][5]=true;board[3][5]=true;board[4][5]=true;board[5][5]=true;board[0][4]=true;board[1][4]=true;board[2][4]=false;board[3][4]=false;board[4][4]=true;board[5][4]=true;board[0][3]=true;board[1][3]=false;board[2][3]=true;board[3][3]=true;board[4][3]=false;board[5][3]=true;board[0][2]=true;board[1][2]=true;board[2][2]=false;board[3][2]=true;board[4][2]=true;board[5][2]=true;board[0][1]=false;board[1][1]=true;board[2][1]=true;board[3][1]=true;board[4][1]=false;board[5][1]=true;board[0][0]=false;board[1][0]=true;board[2][0]=false;board[3][0]=true;board[4][0]=true;board[5][0]=true;

        mission.add(new MissionDots(4,3));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,2));mission.add(new MissionDots(7,1));

        items.add(new GameItem("magic_a",4));items.add(new GameItem("bomb",3));items.add(new GameItem("dice_missile",100));items.add(new GameItem("lock",10));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}


    private static Level getLevel_102(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=false;board[2][5]=true;board[3][5]=true;board[4][5]=true;board[5][5]=true;board[0][4]=true;board[1][4]=false;board[2][4]=true;board[3][4]=false;board[4][4]=false;board[5][4]=true;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=false;board[5][3]=false;board[0][2]=false;board[1][2]=true;board[2][2]=true;board[3][2]=true;board[4][2]=false;board[5][2]=false;board[0][1]=true;board[1][1]=true;board[2][1]=false;board[3][1]=true;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=true;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(4,2));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,3));mission.add(new MissionDots(7,1));

        items.add(new GameItem("rainbow",0));items.add(new GameItem("missile_a",6));items.add(new GameItem("dice_missile",20));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}


    private static Level getLevel_103(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=true;board[3][5]=false;board[4][5]=false;board[5][5]=false;board[0][4]=true;board[1][4]=true;board[2][4]=true;board[3][4]=false;board[4][4]=false;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=false;board[4][3]=false;board[5][3]=false;board[0][2]=false;board[1][2]=false;board[2][2]=false;board[3][2]=false;board[4][2]=false;board[5][2]=false;board[0][1]=false;board[1][1]=false;board[2][1]=false;board[3][1]=false;board[4][1]=false;board[5][1]=false;board[0][0]=false;board[1][0]=false;board[2][0]=false;board[3][0]=false;board[4][0]=false;board[5][0]=false;

        mission.add(new MissionDots(4,3));mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,2));mission.add(new MissionDots(7,1));

        items.add(new GameItem("lock",200));items.add(new GameItem("bomb",3));items.add(new GameItem("magic_a",4));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}


    private static Level getLevel_104(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=false;board[2][5]=true;board[3][5]=false;board[4][5]=true;board[5][5]=false;board[0][4]=true;board[1][4]=false;board[2][4]=true;board[3][4]=false;board[4][4]=true;board[5][4]=false;board[0][3]=true;board[1][3]=true;board[2][3]=true;board[3][3]=true;board[4][3]=true;board[5][3]=true;board[0][2]=true;board[1][2]=true;board[2][2]=true;board[3][2]=true;board[4][2]=true;board[5][2]=true;board[0][1]=false;board[1][1]=true;board[2][1]=false;board[3][1]=true;board[4][1]=false;board[5][1]=true;board[0][0]=false;board[1][0]=true;board[2][0]=false;board[3][0]=true;board[4][0]=false;board[5][0]=true;

        mission.add(new MissionDots(5,3));mission.add(new MissionDots(6,3));mission.add(new MissionDots(7,2));mission.add(new MissionDots(8,1));

        items.add(new GameItem("lock",10));items.add(new GameItem("dice_missile",20));items.add(new GameItem("missile_a",6));items.add(new GameItem("magic",4));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}


    private static Level getLevel_105(int level) {Level retLevel;boolean[][] board = new boolean[6][6];Array<MissionDots> mission = new Array<MissionDots>();Array<GameItem> items = new Array<GameItem>();boolean timeLimited = false;float timeOfTimeLimited = 0f;
        retLevel = new Level(level);

        board[0][5]=true;board[1][5]=true;board[2][5]=false;board[3][5]=false;board[4][5]=true;board[5][5]=true;board[0][4]=false;board[1][4]=true;board[2][4]=true;board[3][4]=true;board[4][4]=true;board[5][4]=false;board[0][3]=false;board[1][3]=true;board[2][3]=false;board[3][3]=false;board[4][3]=true;board[5][3]=false;board[0][2]=false;board[1][2]=true;board[2][2]=true;board[3][2]=true;board[4][2]=true;board[5][2]=false;board[0][1]=true;board[1][1]=true;board[2][1]=true;board[3][1]=true;board[4][1]=true;board[5][1]=true;board[0][0]=false;board[1][0]=true;board[2][0]=true;board[3][0]=true;board[4][0]=true;board[5][0]=false;

        mission.add(new MissionDots(6,3));mission.add(new MissionDots(7,2));mission.add(new MissionDots(8,2));mission.add(new MissionDots(9,1));

        items.add(new GameItem("bomb_a",3));items.add(new GameItem("rainbow",0));items.add(new GameItem("lock",50));

        timeLimited=false;timeOfTimeLimited=0f;

        retLevel.setBoard(board);retLevel.setMission(mission);retLevel.setItems(items);retLevel.setTimeLimited(timeLimited, timeOfTimeLimited);return retLevel;}
}
