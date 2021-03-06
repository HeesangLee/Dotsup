package dalcoms.game.dotsup;

public interface AdmobAdListener {
    void onAdLoaded();

    void onAdFailedToLoad(int errorCode);

    void onAdOpened();

    void onAdLeftApplication();

    void onAdClosed();

    void onAdClicked();

    void onAdImpression();
}
