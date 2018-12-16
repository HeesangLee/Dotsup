package dalcoms.game.dotsup;

public class MissionDots {
    private int missionDots;
    private int missionCount;

    public MissionDots(int missionDots, int missionCount) {
        this.missionDots = missionDots;
        this.missionCount = missionCount;
    }

    public int getMissionDots() {
        return missionDots;
    }

    public void setMissionDots(int missionDots) {
        this.missionDots = missionDots;
    }

    public int getMissionCount() {
        return missionCount;
    }

    public void setMissionCount(int missionCount) {
        this.missionCount = missionCount;
    }
}
