package dalcoms.game.dotsup;

import com.badlogic.gdx.graphics.Color;

public class GameColor {
    public static final Color MEMU_START_BUTTON_EN_NORMAL = new Color(0xff397fff);
    public static final Color MEMU_START_BUTTON_EN_TOUCHDOWN = new Color(0x940034ff);
    public static final Color MEMU_START_BUTTON_DIS_NORMAL = new Color(0x4d4d4dff);
    public static final Color MEMU_START_BUTTON_DIS_TOUCHDOWN = new Color(0x373737ff);
    public static final Color WHITE = new Color(0xffffffff);
    public static final Color MENU_LEVEL_SELECT_ACTIVE = new Color(0xff397fff);

    public static final Color BUTTON_BLUE_NORMAL = new Color(0x00aad4ff);
    public static final Color BUTTON_BLUE_TOUCHDOWN = new Color(0x006179ff);
    public static final Color BUTTON_PINK_NORMAL = new Color(0xff397fff);
    public static final Color BUTTON_PINK_TOUCHDOWN = new Color(0x940034ff);
    public static final Color BUTTON_BROWN_NORMAL = new Color(0x94846dff);
    public static final Color BUTTON_BROWN_TOUCHDOWN = new Color(0x3d362dff);
    public static final Color BUTTON_GREEN_NORMAL = new Color(0x338000ff);
    public static final Color BUTTON_GREEN_TOUCHDOWN = new Color(0x225500ff);

    public static final Color LOADING_CIRCLE_EFFECT = new Color(0xff397f80);
    public static final Color LOADING_CIRCLE_EFFECT_XDRIVER = new Color(0x37abc880);

    public static final Color GAME_HOME_BUTTON_EN_NORMAL = new Color(0xffffff00);
    public static final Color GAME_HOME_BUTTON_EN_TOUCHDOWN = new Color(0xffffff3b);
    public static final Color GAME_HOME_BUTTON_DIS_NORMAL = new Color(0xffffff00);
    public static final Color GAME_HOME_BUTTON_DIS_TOUCHDOWN = new Color(0xffffff3b);

    public static final Color GAME_TIME_PROGRESS_ON = new Color(0x9dffecff);
    public static final Color GAME_TIME_PROGRESS_OFF = new Color(0x9dffec29);

    public static final Color GAME_MISSION_CLEARED_DOTS = new Color(0xff397fff);
    public static final Color GAME_MISSION_DOTS = new Color(0xffffff3c);
    public static final Color XDRIVE_DISTANCE_NUM = new Color(0xffd42aff);


    public GameColor() {

    }

    public static Color getDotsColor(int dotNum) {
        Color ret;
        switch (dotNum) {
            case 1:
                ret = new Color(0xffcc00ff);
                break;
            case 2:
                ret = new Color(0x55d400ff);
                break;
            case 3:
                ret = new Color(0x14d0ffff);
                break;
            case 4:
                ret = new Color(0xcc00ffff);
                break;
            case 5:
                ret = new Color(0xff0000ff);
                break;
            case 6:
                ret = new Color(0xff6600ff);
                break;
            case 7:
                ret = new Color(0xff0066ff);
                break;
            case 8:
                ret = new Color(0xccff00ff);
                break;
            case 9:
                ret = new Color(0x5599ffff);
                break;
            default:
                ret = new Color(0xffcc00ff);
                break;


        }
        return ret;
    }
}
