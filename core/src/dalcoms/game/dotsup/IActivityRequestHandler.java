package dalcoms.game.dotsup;


public interface IActivityRequestHandler {
    void showAdmobBanner(boolean show);

    void loadAdmobInterstital(AdmobAdListener admobAdListener);

    void showAdmobInterstitial();

    void loadAdmobReward(AdmobRewardedVideoAdListener rewardedVideoAdListener);

    void showAdmobReward();

    void toastMessage(String message);

    void actionMoreMyApp();

    void actionShareMyApp();

    void actionReviewMyApp();
}
