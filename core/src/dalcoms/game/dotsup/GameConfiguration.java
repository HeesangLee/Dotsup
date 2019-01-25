package dalcoms.game.dotsup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

import java.util.Date;

public class GameConfiguration {
    Preferences preferences = Gdx.app.getPreferences("DotsupGamePreferences");
    private final String prefKey_LastClearedLevel = "LastClearedLevel";
    private final String prefKey_Date = "Date_";
    private final String prefKey_Moves = "Moves_";
    private final String prefKey_Times = "Times_";
    private final String prefKey_MusicOnOff = "MusicOnOff";

    private static GameConfiguration instance = new GameConfiguration();

    private float viewportWidth = 1080f;
    private float viewportHeight = 1920f;

    private int gamePlayCount = 0;

    public static GameConfiguration getInstance() {
        return instance;
    }

    public float getViewportWidth() {
        return this.viewportWidth;
    }

    public float getViewportHeight() {
        return this.viewportHeight;
    }


    public int getLastClearedLevel() {
        return preferences.getInteger(prefKey_LastClearedLevel, 0);
    }
//    public int getLastClearedLevel() {
//        return GameLevel.getMaxLevel();
//    }


    public void putLastClearedLevel(int level) {
        preferences.putInteger(prefKey_LastClearedLevel, level);
    }

    public Date getLevelClearedDate(int level) {
        long dateLong = preferences.getLong(prefKey_Date + String.valueOf(level), 0);
        //milliseconds
        return new Date(dateLong);
    }

    public void putLevelClearedDate(int level, long dateMilliseconds) {
        preferences.putLong(prefKey_Date + String.valueOf(level), dateMilliseconds);
    }

    public int getLevelMoves(int level) {
        return preferences.getInteger(prefKey_Moves + String.valueOf(level), 0);
    }

    public void putLevelMoves(int level, int moves) {
        preferences.putInteger(prefKey_Moves + String.valueOf(level), moves);
    }

    public int getLevelTimes(int level) {
        return preferences.getInteger(prefKey_Times + String.valueOf(level), 0);
    }

    public void putLevelTimes(int level, int time) {
        preferences.putInteger(prefKey_Times + String.valueOf(level), time);
    }

    public boolean getMusicOnOff() {
        return preferences.getBoolean(prefKey_MusicOnOff, true);
    }

    public void putMusicOnOff(boolean onoff) {
        preferences.putBoolean(prefKey_MusicOnOff, onoff);
    }

    public void flushingPreferences() {
        preferences.flush();
    }

    public int getGamePlayCount() {
        return gamePlayCount;
    }

    public void setGamePlayCount(int gamePlayCount) {
        this.gamePlayCount = gamePlayCount;
    }

    public int increaseGamePlayCount() {
        setGamePlayCount(getGamePlayCount() + 1);
        return getGamePlayCount();
    }
}
