package dalcoms.game.dotsup;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import java.util.Calendar;

public class AndroidLauncher extends AndroidApplication
        implements IActivityRequestHandler {

    //    private final String APP_ID = "ca-app-pub-3940256099942544~3347511713";
    private final String APP_ID = "";
    private final String UNIT_ID_BANNER = "ca-app-pub-0894410772194388/4792545924";
    private final String UNIT_ID_INTERSTITIAL = "ca-app-pub-0894410772194388/2505170222";
    private final String UNIT_ID_REWARD = "ca-app-pub-3940256099942544/5224354917"; //Not created yet

    protected AdView adView;
    private InterstitialAd mInterstitialAd;
    private RewardedVideoAd mRewardedVideoAd;
    private AdmobRewardedVideoAdListener rewardedVideoAdListener;
    private AdmobAdListener admobAdListener;

    private final int SHOW_AD_BANNER = 0;
    private final int HIDE_AD_BANNER = 1;
    private final int LOAD_AD_INTERSTITIAL = 3;
    private final int SHOW_AD_INTERSTITIAL = 4;
    private final int LOAD_AD_REWARD = 5;
    private final int SHOW_AD_REWARD = 6;
    private final int TOAST_MSG = 7;
    private final int MORE_MYAPP = 8;
    private final int SHARE_MYAPP = 9;
    private final int REVIEW_MYAPP = 10;

    private String stringToast = "";

    protected Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SHOW_AD_BANNER:
                    adView.setVisibility(View.VISIBLE);
                    break;

                case HIDE_AD_BANNER:
                    adView.setVisibility(View.GONE);
                    break;

                case LOAD_AD_INTERSTITIAL:
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                    break;

                case SHOW_AD_INTERSTITIAL:
                    if (mInterstitialAd.isLoaded()) {
                        mInterstitialAd.show();
                    }
                    break;
                case LOAD_AD_REWARD:
                    mRewardedVideoAd.loadAd(UNIT_ID_REWARD, new AdRequest.Builder().build());
                    break;
                case SHOW_AD_REWARD:
                    if (mRewardedVideoAd.isLoaded()) {
                        mRewardedVideoAd.show();
                    }
                    break;
                case TOAST_MSG:
                    doToastMsg();
                    break;
                case MORE_MYAPP:
                    doMoreMyApp();
                    break;
                case SHARE_MYAPP:
                    doShareMayApp();
                    break;
                case REVIEW_MYAPP:
                    doReviewMyApp();
                    break;

            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create the layout
        RelativeLayout layout = getLayout();

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

        View gameView = createGameView();
        adView = createAdView(UNIT_ID_BANNER);

        layout.addView(gameView, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        layout.addView(adView);

        setContentView(layout);

        MobileAds.initialize(this, APP_ID);

        loadAdmobBanner(adView);

        initAdmobInterstitial();

        initAdmobReward();
    }


    private RelativeLayout getLayout() {
        RelativeLayout layout = new RelativeLayout(this);
        RelativeLayout.LayoutParams params =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT);

        return layout;
    }

    private AdView createAdView(String unitId) {
        adView = new AdView(this);

        RelativeLayout.LayoutParams adParams =
                new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);

        adParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        adParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

        adView.setAdSize(getAdmobBannerSize());
        adView.setAdUnitId(unitId);
        adView.setBackgroundColor(Color.TRANSPARENT);

        adView.setVisibility(View.GONE);

        adView.setLayoutParams(adParams);

        return adView;
    }

    private AdSize getAdmobBannerSize() {
        AdSize ret = AdSize.BANNER;
        switch (Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) {
            case 2:
            case 8:
            case 13:
            case 17:
            case 22:
            case 24:
                ret = AdSize.SMART_BANNER;
                break;
        }
        return ret;
    }

    private View createGameView() {
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        config.useAccelerometer = false;
        config.useCompass = false;
        config.useWakelock = true;

        View gameView = initializeForView(new Dotsup(this), config);

        return gameView;
    }

    private void loadAdmobBanner(final AdView adView) {
        adView.loadAd(new AdRequest.Builder().build());
    }

    private void initAdmobInterstitial() {
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(UNIT_ID_INTERSTITIAL);
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                if (admobAdListener != null) {
                    admobAdListener.onAdClosed();
                }
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                if (admobAdListener != null) {
                    admobAdListener.onAdFailedToLoad(i);
                }
            }

            @Override
            public void onAdLeftApplication() {
                super.onAdLeftApplication();
                if (admobAdListener != null) {
                    admobAdListener.onAdLeftApplication();
                }
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
                if (admobAdListener != null) {
                    admobAdListener.onAdOpened();
                }
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                if (admobAdListener != null) {
                    admobAdListener.onAdLoaded();
                }
            }

            @Override
            public void onAdClicked() {
                super.onAdClicked();
                if (admobAdListener != null) {
                    admobAdListener.onAdClicked();
                }
            }

            @Override
            public void onAdImpression() {
                super.onAdImpression();
                if (admobAdListener != null) {
                    admobAdListener.onAdImpression();
                }
            }
        });
    }

    private void initAdmobReward() {
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(new RewardedVideoAdListener() {
            @Override
            public void onRewardedVideoAdLoaded() {
                Gdx.app.log("reward", "loaded");
                if (rewardedVideoAdListener != null) {
                    rewardedVideoAdListener.onRewardedVideoAdLoaded();
                }
            }

            @Override
            public void onRewardedVideoAdOpened() {
                Gdx.app.log("reward", "opened");
                if (rewardedVideoAdListener != null) {
                    rewardedVideoAdListener.onRewardedVideoAdOpened();
                }

            }

            @Override
            public void onRewardedVideoStarted() {
                Gdx.app.log("reward", "started");
                if (rewardedVideoAdListener != null) {
                    rewardedVideoAdListener.onRewardedVideoStarted();
                }

            }

            @Override
            public void onRewardedVideoAdClosed() {
                Gdx.app.log("reward", "cloased");
                if (rewardedVideoAdListener != null) {
                    rewardedVideoAdListener.onRewardedVideoAdClosed();
                }

            }

            @Override
            public void onRewarded(RewardItem rewardItem) {
                Gdx.app.log("reward", rewardItem.toString());
            }

            @Override
            public void onRewardedVideoAdLeftApplication() {
                Gdx.app.log("reward", "leftApplication");
                if (rewardedVideoAdListener != null) {
                    rewardedVideoAdListener.onRewardedVideoAdLeftApplication();
                }

            }

            @Override
            public void onRewardedVideoAdFailedToLoad(int i) {
                Gdx.app.log("reward", "failed : " + String.valueOf(i));

            }

            @Override
            public void onRewardedVideoCompleted() {
                Gdx.app.log("reward", "completed");
                if (rewardedVideoAdListener != null) {
                    rewardedVideoAdListener.onRewardedVideoCompleted();
                }

            }
        });

    }


    @Override
    public void showAdmobBanner(boolean show) {
        handler.sendEmptyMessage(show ? SHOW_AD_BANNER : HIDE_AD_BANNER);

    }

    @Override
    public void loadAdmobInterstital(AdmobAdListener admobAdListener) {
        this.admobAdListener = admobAdListener;
        handler.sendEmptyMessage(LOAD_AD_INTERSTITIAL);
    }

    @Override
    public void showAdmobInterstitial() {
        handler.sendEmptyMessage(SHOW_AD_INTERSTITIAL);
    }

    @Override
    public void loadAdmobReward(AdmobRewardedVideoAdListener listener) {
        this.rewardedVideoAdListener = rewardedVideoAdListener;

        handler.sendEmptyMessage(LOAD_AD_REWARD);
    }


    @Override
    public void showAdmobReward() {
        handler.sendEmptyMessage(SHOW_AD_REWARD);
    }

    @Override
    public void toastMessage(String message) {
        handler.sendEmptyMessage(TOAST_MSG);
        this.stringToast = message;
    }

    @Override
    public void actionMoreMyApp() {
        handler.sendEmptyMessage(MORE_MYAPP);
    }

    @Override
    public void actionShareMyApp() {
        handler.sendEmptyMessage(SHARE_MYAPP);
    }

    @Override
    public void actionReviewMyApp() {
        handler.sendEmptyMessage(REVIEW_MYAPP);
    }

    private void doMoreMyApp() {

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(
                "https://play.google.com/store/apps/developer?id=Dalcoms"));
        intent.setPackage("com.android.vending");
        startActivity(intent);
    }

    private void doShareMayApp() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,
                "Let's dotsup\n\rhttps://play.google.com/store/apps/details?id=dalcoms.game.dotsup");
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "dotsup");
        sendIntent.putExtra(Intent.EXTRA_EMAIL, "");
        sendIntent.putExtra(Intent.EXTRA_CC, "");
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, "Share dotsup"));
    }

    private void doReviewMyApp() {

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(
                "https://play.google.com/store/apps/details?id=dalcoms.game.dotsup"));
        intent.setPackage("com.android.vending");
        startActivity(intent);
    }

    private void doToastMsg() {
        Toast.makeText(this, this.stringToast, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {

        if (adView != null) {
            adView.pause();
        }
        if (mRewardedVideoAd != null) {
            mRewardedVideoAd.pause(this);
        }
        super.onPause();
    }

    @Override
    protected void onResume() {

        if (adView != null) {
            adView.resume();
        }
        if (mRewardedVideoAd != null) {
            mRewardedVideoAd.resume(this);
        }
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        if (mRewardedVideoAd != null) {
            mRewardedVideoAd.destroy(this);
        }
        super.onDestroy();
    }
}
