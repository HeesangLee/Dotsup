package dalcoms.game.dotsup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;

public class GameScreen implements Screen {

    final Dotsup game;
    OrthographicCamera camera;
    private SpriteBatch batch;
    private Array<Renderable> renderableObjectArray;
    private Array<GestureDetectableButton> gestureDetectableButtonArray;

    private SpriteButton homeButton;
    private boolean dialogShow = false;
    private ReallySimpleDialog dialog;
    private TopDisplayPanel topDisplayPanel;
    protected int gameLevel;
    private MissionPanel missionPanel;
    private GameBoard gameBoard;

    private final int DIALOG_TOMEMU = 0;
    private final int DIALOG_SUCCESS = 1;
    private final int DIALOG_FAIL = 2;

    private final int INTERSTITAL_AD_COUNT = 10;
    private final int ITEM_ADD_COUNT = 4;

    private boolean admobInterstitialAdLoaded = false, admobRewardedLoaded = false;

    private final int ITEM_BOMB = 0;
    private final int ITEM_MAGIC = 1;
    private final int ITEM_MISSILE = 2;
    private final int ITEM_RAINBOW = 3;
    private final int ITEM_LOCK = 4;
    private final int ITEM_BOMB_A = 5;
    private final int ITEM_MAGIC_A = 6;
    private final int ITEM_MISSILE_A = 7;
    private final int ITEM_RAINBOW_A = 8;


    private int itemLockMovesCondition = -1;

    private Array<SpriteButton> gameItemArray;

    Music musicBgm;

    public GameScreen(final Dotsup game, int gameLevel) {
        this.game = game;
        this.camera = new OrthographicCamera();
        this.batch = game.getSpriteBatch();
        camera.setToOrtho(false, game.getGameConfiguration().getViewportWidth(),
                game.getGameConfiguration().getViewportHeight());
        this.gameLevel = gameLevel;
        Gdx.input.setCatchBackKey(true);
    }


    private void initGameObjects() {
        renderableObjectArray.add(new GameObject(game.getResourcesManager().getTexture_game_bottom(),
                0, 0, true).setSpriteBatch(batch));

        playBgm(initSoundMusic());
        createHomeButton(-34f, 1744f);
        createDisplayPanel(183f, 1723f);
        createMissionPanel(1540f);
        createGameBoard(game.getGameConfiguration().getViewportWidth() / 2f,
                game.getGameConfiguration().getViewportHeight() / 2f);

        checkAddGameItem();
    }

    private boolean initSoundMusic() {
        musicBgm = Gdx.audio.newMusic(Gdx.files.internal("Sound/Indigo.mp3"));
        musicBgm.setLooping(true);
        return game.getGameConfiguration().getMusicOnOff();
    }

    private void playBgm(boolean musicOnOff) {
        if (musicOnOff) {
            musicBgm.play();
        } else {
            musicBgm.stop();
        }
    }

    private void checkMissionClear(int mergedDotsNum) {
        if (missionPanel.checkMissionClear(mergedDotsNum)) {
            game.getResourcesManager().getSound_missionClear().play();

            if (missionPanel.isMissionAllCleared()) {
                //Mission clear --> pop up dialog to ask whether go to next or replay
                saveGame();
                if (getGameLevel() < GameLevel.getMaxLevel()) {
                    popUpSuccessDialog();
                } else {
                    popUpAllClearDialog();
                }
            }
        }
    }

    private void saveGame() {
        final int thisLevel = getGameLevel();

        if (thisLevel > game.getGameConfiguration().getLastClearedLevel()) {
            game.getGameConfiguration().putLastClearedLevel(thisLevel);
        }

        game.getGameConfiguration().putLevelClearedDate(thisLevel, TimeUtils.millis());
        game.getGameConfiguration().putLevelMoves(thisLevel, topDisplayPanel.getGameMovesNumber());
        game.getGameConfiguration().putLevelTimes(thisLevel, topDisplayPanel.gameTimeSec);

        game.getGameConfiguration().flushingPreferences();
    }

    private void checkAddGameItem() {
        int itemInt;
        boolean isItemAdd = false;
        Array<GameItem> gameItems = GameLevel.getLevel(getGameLevel()).getItems();
        isItemAdd = game.getGameConfiguration().getGamePlayCount() % ITEM_ADD_COUNT == ITEM_ADD_COUNT-1;

        Gdx.app.log("isAlwaysItem", "itemAdd" + String.valueOf(isItemAdd));
        for (GameItem gameItem : gameItems) {
            itemInt = getItemInt(gameItem.getItemName());
            if ((itemInt != -1) & (isItemAdd | isAlawysItem(itemInt))) {
                addGameItem(itemInt, gameItem.getCondition());
            }
        }
    }

    private int getItemInt(String itemName) {
        if (itemName.equals("bomb")) {
            return ITEM_BOMB;
        } else if (itemName.equals("magic")) {
            return ITEM_MAGIC;
        } else if (itemName.equals("missile")) {
            return ITEM_MISSILE;
        } else if (itemName.equals("rainbow")) {
            return ITEM_RAINBOW;
        } else if (itemName.equals("lock")) {
            return ITEM_LOCK;
        } else if (itemName.equals("bomb_a")) {
            return ITEM_BOMB_A;
        } else if (itemName.equals("magic_a")) {
            return ITEM_MAGIC_A;
        } else if (itemName.equals("missile_a")) {
            return ITEM_MISSILE_A;
        } else if (itemName.equals("rainbow_a")) {
            return ITEM_RAINBOW_A;
        }
        return -1;
    }

    private boolean isAlawysItem(int itemInt) {
        boolean ret = false;
        switch (itemInt) {
            case ITEM_LOCK:
            case ITEM_BOMB_A:
            case ITEM_MAGIC_A:
            case ITEM_MISSILE_A:
            case ITEM_RAINBOW_A:
                ret = true;
                break;
        }
        Gdx.app.log("isAlwaysItem", String.valueOf(ret));
        return ret;
    }

    private void addGameItem(int gameItem, int condition) {
        final float locationY = 256f;
        final float[] loacationX = {84f, 320f, 556f, 792f};

        if (gameItemArray.size > 3) {
            Gdx.app.log("GameScreen", "addGameItem : exceed max item");
            return;
        }

        Texture itemTexture = null;
        switch (gameItem) {
            case ITEM_BOMB:
            case ITEM_BOMB_A:
                itemTexture = game.getResourcesManager().getTexture_item_bomb();
                break;
            case ITEM_MAGIC:
            case ITEM_MAGIC_A:
                itemTexture = game.getResourcesManager().getTexture_item_magic();
                break;
            case ITEM_MISSILE:
            case ITEM_MISSILE_A:
                itemTexture = game.getResourcesManager().getTexture_item_missile();
                break;
            case ITEM_RAINBOW:
            case ITEM_RAINBOW_A:
                itemTexture = game.getResourcesManager().getTexture_item_rainbow();
                break;
            case ITEM_LOCK:
                setItemLockMovesCondition(condition);
                return;
            default:
                return;
        }
        SpriteButton itemButton =
                new SpriteButton(game.getResourcesManager().getTexture_circle_200x200(),
                        loacationX[gameItemArray.size], locationY, game.getSpriteBatch()) {
                    @Override
                    public void actionTap() {
                        Gdx.app.log("GameScreen", "item tap" + String.valueOf(getId()));
                        onItemAction(this, getId(), getStateInt());
                    }
                };

        if (itemTexture != null) {
            itemButton.setTopTexture(itemTexture);
        }
        itemButton.setColorEffect(true,
                GameColor.GAME_HOME_BUTTON_EN_NORMAL, GameColor.GAME_HOME_BUTTON_EN_TOUCHDOWN,
                GameColor.GAME_HOME_BUTTON_EN_NORMAL, GameColor.GAME_HOME_BUTTON_EN_TOUCHDOWN);
        itemButton.setId(gameItem);
        itemButton.setStateInt(condition);

        gameItemArray.add(itemButton);
    }

    private void onItemAction(SpriteButton button, int gameItem, int conditon) {
        gameItemArray.removeValue(button, false);
        switch (gameItem) {
            case ITEM_BOMB:
            case ITEM_BOMB_A:
                onItemActionBomb(conditon);
                break;
            case ITEM_MAGIC:
            case ITEM_MAGIC_A:
                onItemActionMagic(conditon);
                break;
            case ITEM_MISSILE:
            case ITEM_MISSILE_A:
                onItemActionMissile(conditon);
                break;
            case ITEM_RAINBOW:
            case ITEM_RAINBOW_A:
                onItemActionRainbow();
                break;
        }
    }

    private void showItemEffect(Array<BoardPosition2D> effectPositions, int effectNum) {
        Texture textureEffect;
        switch (effectNum) {
            case 1:
                textureEffect = game.getResourcesManager().getTexture_item_effect_1();
                break;
            case 2:
                textureEffect = game.getResourcesManager().getTexture_item_effect_2();
                break;
            default:
                textureEffect = game.getResourcesManager().getTexture_item_effect_1();
                break;
        }
        for (BoardPosition2D pos : effectPositions) {


            GameItemEffectSpriteGameObject effect
                    = new GameItemEffectSpriteGameObject(textureEffect
                    , gameBoard.getCell(pos.getX(), pos.getY()).getCenterLocation()
                    , batch) {
                @Override
                public void onEffectCompleted() {
                    super.onEffectCompleted();
                    renderableObjectArray.removeValue(this, false);
                }
            };
            effect.show();
            renderableObjectArray.add(effect);
        }
    }

    private void onItemActionBomb(int condition) {
        game.getLauncherHandler().toastMessage("Bomb");
        showItemEffect(getGameBoard().actionItemBomb(condition), 1);
    }

    private void onItemActionMagic(int condition) {
        game.getLauncherHandler().toastMessage("Magic");
        showItemEffect(getGameBoard().actionItemMagic(condition), 1);
    }

    private void onItemActionMissile(int condition) {
        game.getLauncherHandler().toastMessage("Missle");
        showItemEffect(getGameBoard().actionItemMissile(condition), 1);
    }

    private void onItemActionRainbow() {
        game.getLauncherHandler().toastMessage("Rainbow");
        showItemEffect(getGameBoard().actionItemRainbow(), 1);
    }

    private void checkAddItemLock() {
        if (getItemLockMovesCondition() == topDisplayPanel.getGameMovesNumber()) {
            setItemLockMovesCondition(-1);
            getGameBoard().actionItemLock();
        }
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    private void createGameBoard(float centerX, float centerY) {
        gameBoard = new GameBoard(game.getResourcesManager().getTexture_game_cell_134x134(),
                game.getResourcesManager().getTexture_dotsArray(),
                centerX, centerY,
                GameLevel.getLevel(getGameLevel()).getBoard(),
                batch, true);

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                gameBoard.start();
                topDisplayPanel.setTimerStart(true);
            }
        }, 0.1f);

        gameBoard.addGameBoardListener(new GameBoardListener() {

            @Override
            public void dotsMerged(int mergedDotsNum, String tag) {
                super.dotsMerged(mergedDotsNum, tag);
                Gdx.app.log("GameScreen", tag + "is merged to" + String.valueOf(mergedDotsNum));
                game.getResourcesManager().getSound_merge().play();

                checkMissionClear(mergedDotsNum);
            }

            @Override
            public void dotsMoved(int direction) {
                super.dotsMoved(direction);
                topDisplayPanel.increaseGameMovesNumber(1);
                checkAddItemLock();
            }

            @Override
            public void boardFull(boolean isPossibleToMoveDots) {
                super.boardFull(isPossibleToMoveDots);

                if (isPossibleToMoveDots) {
                    Gdx.app.log("GameScreen", "boardFull but you can move more~~~~");
                } else {
                    popUpFailedDialog();
                }
            }

            @Override
            public void dotsNew() {
                super.dotsNew();
                game.getResourcesManager().getSound_dotsNew().play();
            }
        });

        renderableObjectArray.add(gameBoard);
    }

    private void createMissionPanel(float locationY) {
        missionPanel = new MissionPanel(locationY);
        renderableObjectArray.add(missionPanel);
    }

    private void createDisplayPanel(float x, float y) {
        this.topDisplayPanel = new TopDisplayPanel(this.gameLevel, x, y);
        renderableObjectArray.add(topDisplayPanel);
    }

    private void createHomeButton(float x, float y) {
        this.homeButton = new SpriteButton(game.getResourcesManager().getTexture_circle_200x200(),
                x, y, batch) {
            @Override
            public void actionTouchDown() {
                game.getResourcesManager().getSound_tap().play();
            }

            @Override
            public void actionTap() {
                super.actionTap();
                popUpAskGotoHomeScreen();
            }

            @Override
            public void actionLongPress() {
                super.actionLongPress();
                popUpAskGotoHomeScreen();
            }
        };
        homeButton.setTopTexture(game.getResourcesManager().getTexture_game_home_btn());
        homeButton.setColorEffect(true,
                GameColor.GAME_HOME_BUTTON_EN_NORMAL, GameColor.GAME_HOME_BUTTON_EN_TOUCHDOWN,
                GameColor.GAME_HOME_BUTTON_DIS_NORMAL, GameColor.GAME_HOME_BUTTON_DIS_TOUCHDOWN);

        renderableObjectArray.add(homeButton);
        gestureDetectableButtonArray.addAll(homeButton);

    }

    private void popUpAskGotoHomeScreen() {
        popUpBackKeyDialog();
    }

    private void disposeMusicBgm() {
        if (musicBgm != null) {
            musicBgm.stop();
            musicBgm.dispose();
        }
    }

    private void checkInterstitialAd() {
        if (game.getGameConfiguration().getGamePlayCount() % INTERSTITAL_AD_COUNT
                == INTERSTITAL_AD_COUNT - 1) {
//            game.getGameConfiguration().setGamePlayCount(0);
            game.getLauncherHandler().loadAdmobInterstital(new AdmobAdListener() {
                @Override
                public void onAdLoaded() {
                    Gdx.app.log("GameScreen", "Admob interstitial loaded");
                    setAdmobInterstitialAdLoaded(true);
                }

                @Override
                public void onAdFailedToLoad(int errorCode) {
                    Gdx.app.log("GameScreen", "Admob interstitial loaded failed : "
                            + String.valueOf(errorCode));
                    setAdmobInterstitialAdLoaded(false);
                }

                @Override
                public void onAdOpened() {

                }

                @Override
                public void onAdLeftApplication() {

                }

                @Override
                public void onAdClosed() {

                }

                @Override
                public void onAdClicked() {

                }

                @Override
                public void onAdImpression() {

                }
            });
        }
    }

    public boolean isAdmobInterstitialAdLoaded() {
        return admobInterstitialAdLoaded;
    }

    public void setAdmobInterstitialAdLoaded(boolean admobInterstitialAdLoaded) {
        this.admobInterstitialAdLoaded = admobInterstitialAdLoaded;
    }

    public boolean isAdmobRewardedLoaded() {
        return admobRewardedLoaded;
    }

    public void setAdmobRewardedLoaded(boolean admobRewardedLoaded) {
        this.admobRewardedLoaded = admobRewardedLoaded;
    }

    private void loadAdmobRewardedVideoAd() {
        game.getLauncherHandler().loadAdmobReward(new AdmobRewardedVideoAdListener() {
            @Override
            public void onRewardedVideoAdLoaded() {
                Gdx.app.log("GameScreen", "Admob rewarded loaded");
                setAdmobRewardedLoaded(true);
            }

            @Override
            public void onRewardedVideoAdOpened() {

            }

            @Override
            public void onRewardedVideoStarted() {

            }

            @Override
            public void onRewardedVideoAdClosed() {

            }

            @Override
            public void onRewardedVideoAdLeftApplication() {

            }

            @Override
            public void onRewardedVideoCompleted() {
                Gdx.app.log("GameScreen", "Admob rewarded completed");
                onAdmobRewardedVideoCompleted();
            }
        });
    }

    private void onAdmobRewardedVideoCompleted() {

    }

    private void showInterstitialAd() {

        game.getLauncherHandler().showAdmobInterstitial();
    }

    private void gotoMenuScreen() {
        disposeMusicBgm();
        game.setScreen(new MenuScreen(game));

    }

    private void replayThiLevel() {
        disposeMusicBgm();
        game.getGameConfiguration().increaseGamePlayCount();
        showInterstitialAd();
        game.setScreen(new LoadingScreen(game, gameLevel));
    }

    private void goNextLevel() {
        disposeMusicBgm();
        game.getGameConfiguration().increaseGamePlayCount();
        showInterstitialAd();
        game.setScreen(new LoadingScreen(game, gameLevel < GameLevel.getMaxLevel() ? gameLevel + 1 : gameLevel));
    }

    private void popUpSuccessDialog() {
        if (isDialogShow() & (getDialog() != null)) {
            if (getDialog().getId() == DIALOG_TOMEMU) {
                killDialog();
                return;
            }
        }

        setDialogShow(true);
        ReallySimpleDialog dialog = new ReallySimpleDialog(game.getResourcesManager().getTexture_dialog_870x718()
                , 0, 0, true, batch);
        dialog.setCenterLocation(game.getGameConfiguration().getViewportWidth() / 2f
                , game.getGameConfiguration().getViewportHeight() / 2f);
        dialog.setId(DIALOG_SUCCESS);

        SpriteGameObject dialogHat = new SpriteGameObject(game.getResourcesManager().getTexture_dialog_hat_770x288(),
                50f, 380f).setSpriteBatch(batch);
        dialogHat.getSprite().setColor(GameColor.BUTTON_BLUE_NORMAL);
        dialogHat.enableDrawSprite(true);
        dialog.addSpriteGameObject(dialogHat);

        dialog.addGameObject(new GameObject(game.getResourcesManager().getTexture_dialog_text_success()
                , 321f, 455f, true)
                .setSpriteBatch(batch));

        dialog.addGameObject(new GameObject(game.getResourcesManager().getTexture_t35_challenage_next_level()
                , 183f, 270f, true)
                .setSpriteBatch(batch));

        final SpriteButton nextButton = new SpriteButton(game.getResourcesManager().getTexture_button_302x105()
                , 465f, 121f, batch) {
            @Override
            public void actionTouchDown() {
                super.actionTouchDown();
                game.getResourcesManager().getSound_tap().play();
            }

            @Override
            public void actionTap() {
                super.actionTap();
                goNextLevel();

            }
        };
        nextButton.setTopTexture(game.getResourcesManager().getTexture_btn_text_next());
        nextButton.enableDrawSprite(true);
        nextButton.setColorEffect(true,
                GameColor.BUTTON_BLUE_NORMAL, GameColor.BUTTON_BLUE_TOUCHDOWN,
                GameColor.MEMU_START_BUTTON_DIS_NORMAL, GameColor.MEMU_START_BUTTON_DIS_TOUCHDOWN);

        final SpriteButton replayButton = new SpriteButton(game.getResourcesManager().getTexture_btn_replay_105x105()
                , 4273f, 121f, batch) {
            @Override
            public void actionTouchDown() {
                super.actionTouchDown();
                game.getResourcesManager().getSound_tap().play();
            }

            @Override
            public void actionTap() {
                super.actionTap();
                replayThiLevel();

            }
        };
        replayButton.enableDrawSprite(true);
        replayButton.setColorEffect(true,
                GameColor.BUTTON_BROWN_NORMAL, GameColor.BUTTON_BROWN_TOUCHDOWN,
                GameColor.MEMU_START_BUTTON_DIS_NORMAL, GameColor.MEMU_START_BUTTON_DIS_TOUCHDOWN);

        final SpriteButton goHomeButton = new SpriteButton(game.getResourcesManager().getTexture_btn_home_105x105()
                , 103f, 121f, batch) {
            @Override
            public void actionTap() {
                super.actionTap();
                gotoMenuScreen();

            }
        };
        goHomeButton.enableDrawSprite(true);
        goHomeButton.setColorEffect(true,
                GameColor.BUTTON_BROWN_NORMAL, GameColor.BUTTON_BROWN_TOUCHDOWN,
                GameColor.MEMU_START_BUTTON_DIS_NORMAL, GameColor.MEMU_START_BUTTON_DIS_TOUCHDOWN);

        dialog.addSpriteButton(goHomeButton);
        dialog.addSpriteButton(replayButton);
        dialog.addSpriteButton(nextButton);


        dialog.moveY(game.getGameConfiguration().getViewportHeight(),
                dialog.getLocationY(), 0.5f);

        dialog.addActionListener(new ObjectActionListener() {
            @Override
            public boolean onMoveCompleted(boolean direction) {
                goHomeButton.updateTouchArea();
                replayButton.updateTouchArea();
                nextButton.updateTouchArea();
                return false;
            }

            @Override
            public boolean onMoveStarted(boolean direction) {
                return false;
            }
        });

        setDialog(dialog);


    }

    private void popUpAllClearDialog() {
        if (isDialogShow() & (getDialog() != null)) {
            if (getDialog().getId() == DIALOG_TOMEMU) {
                killDialog();
                return;
            }
        }

        setDialogShow(true);
        ReallySimpleDialog dialog = new ReallySimpleDialog(game.getResourcesManager().getTexture_dialog_870x718()
                , 0, 0, true, batch);
        dialog.setCenterLocation(game.getGameConfiguration().getViewportWidth() / 2f
                , game.getGameConfiguration().getViewportHeight() / 2f);
        dialog.setId(DIALOG_SUCCESS);

        SpriteGameObject dialogHat = new SpriteGameObject(game.getResourcesManager().getTexture_dialog_hat_770x288(),
                50f, 380f).setSpriteBatch(batch);
        dialogHat.getSprite().setColor(GameColor.BUTTON_GREEN_NORMAL);
        dialogHat.enableDrawSprite(true);
        dialog.addSpriteGameObject(dialogHat);

        dialog.addGameObject(new GameObject(game.getResourcesManager().getTexture_dialog_text_clear_all()
                , 158f, 455f, true)
                .setSpriteBatch(batch));

        dialog.addGameObject(new GameObject(game.getResourcesManager().getTexture_t35_you_are_the_best()
                , 232f, 270f, true)
                .setSpriteBatch(batch));

        final SpriteButton replayButton = new SpriteButton(game.getResourcesManager().getTexture_button_302x105()
                , 465f, 121f, batch) {
            @Override
            public void actionTouchDown() {
                super.actionTouchDown();
                game.getResourcesManager().getSound_tap().play();
            }

            @Override
            public void actionTap() {
                super.actionTap();
                replayThiLevel();

            }
        };
        replayButton.setTopTexture(game.getResourcesManager().getTexture_btn_text_replay());
        replayButton.enableDrawSprite(true);
        replayButton.setColorEffect(true,
                GameColor.BUTTON_GREEN_NORMAL, GameColor.BUTTON_GREEN_TOUCHDOWN,
                GameColor.MEMU_START_BUTTON_DIS_NORMAL, GameColor.MEMU_START_BUTTON_DIS_TOUCHDOWN);

        final SpriteButton goHomeButton = new SpriteButton(game.getResourcesManager().getTexture_btn_home_105x105()
                , 103f, 121f, batch) {
            @Override
            public void actionTouchDown() {
                super.actionTouchDown();
                game.getResourcesManager().getSound_tap().play();
            }

            @Override
            public void actionTap() {
                super.actionTap();
                gotoMenuScreen();

            }
        };
        goHomeButton.enableDrawSprite(true);
        goHomeButton.setColorEffect(true,
                GameColor.BUTTON_BROWN_NORMAL, GameColor.BUTTON_BROWN_TOUCHDOWN,
                GameColor.MEMU_START_BUTTON_DIS_NORMAL, GameColor.MEMU_START_BUTTON_DIS_TOUCHDOWN);

        dialog.addSpriteButton(goHomeButton);
        dialog.addSpriteButton(replayButton);


        dialog.moveY(game.getGameConfiguration().getViewportHeight(),
                dialog.getLocationY(), 0.5f);

        dialog.addActionListener(new ObjectActionListener() {
            @Override
            public boolean onMoveCompleted(boolean direction) {
                goHomeButton.updateTouchArea();
                replayButton.updateTouchArea();
                return false;
            }

            @Override
            public boolean onMoveStarted(boolean direction) {
                return false;
            }
        });

        setDialog(dialog);

    }


    private void popUpFailedDialog() {
        if (isDialogShow() & (getDialog() != null)) {
            if (getDialog().getId() == DIALOG_TOMEMU) {
                killDialog();
                return;
            }
        }
        //=======================
        //game level debug.
        String strDotsNumsOnBoard = "";
        for (Integer dotsNumOnBoard : gameBoard.getDotsNumsOnBoard()) {
            strDotsNumsOnBoard += " , " + String.valueOf(dotsNumOnBoard);
        }
        Gdx.app.log("dotsonboard", "Level " + String.valueOf(getGameLevel()) +
                " : moves=" + String.valueOf(topDisplayPanel.getGameMovesNumber())
                + "times=" + String.valueOf(topDisplayPanel.getGameTimeSec())
                + "dots on board=" + strDotsNumsOnBoard);
        //=======================

        setDialogShow(true);
        ReallySimpleDialog dialog = new ReallySimpleDialog(game.getResourcesManager().getTexture_dialog_870x718()
                , 0, 0, true, batch);
        dialog.setCenterLocation(game.getGameConfiguration().getViewportWidth() / 2f
                , game.getGameConfiguration().getViewportHeight() / 2f);
        dialog.setId(DIALOG_FAIL);

        SpriteGameObject dialogHat = new SpriteGameObject(game.getResourcesManager().getTexture_dialog_hat_770x288(),
                50f, 380f).setSpriteBatch(batch);
        dialogHat.getSprite().setColor(GameColor.BUTTON_PINK_NORMAL);
        dialogHat.enableDrawSprite(true);
        dialog.addSpriteGameObject(dialogHat);

        dialog.addGameObject(new GameObject(game.getResourcesManager().getTexture_dialog_text_failed()
                , 338f, 455f, true)
                .setSpriteBatch(batch));

        dialog.addGameObject(new GameObject(game.getResourcesManager().getTexture_t35_try_again()
                , 309f, 270f, true)
                .setSpriteBatch(batch));

        final SpriteButton replayButton = new SpriteButton(game.getResourcesManager().getTexture_button_302x105()
                , 465f, 121f, batch) {
            @Override
            public void actionTouchDown() {
                super.actionTouchDown();
                game.getResourcesManager().getSound_tap().play();
            }

            @Override
            public void actionTap() {
                super.actionTap();
                replayThiLevel();

            }
        };
        replayButton.setTopTexture(game.getResourcesManager().getTexture_btn_text_replay());
        replayButton.enableDrawSprite(true);
        replayButton.setColorEffect(true,
                GameColor.BUTTON_PINK_NORMAL, GameColor.BUTTON_PINK_TOUCHDOWN,
                GameColor.MEMU_START_BUTTON_DIS_NORMAL, GameColor.MEMU_START_BUTTON_DIS_TOUCHDOWN);

        final SpriteButton goHomeButton = new SpriteButton(game.getResourcesManager().getTexture_btn_home_105x105()
                , 103f, 121f, batch) {
            @Override
            public void actionTouchDown() {
                super.actionTouchDown();
                game.getResourcesManager().getSound_tap().play();
            }

            @Override
            public void actionTap() {
                super.actionTap();
                gotoMenuScreen();

            }
        };
        goHomeButton.enableDrawSprite(true);
        goHomeButton.setColorEffect(true,
                GameColor.BUTTON_BROWN_NORMAL, GameColor.BUTTON_BROWN_TOUCHDOWN,
                GameColor.MEMU_START_BUTTON_DIS_NORMAL, GameColor.MEMU_START_BUTTON_DIS_TOUCHDOWN);

        dialog.addSpriteButton(goHomeButton);
        dialog.addSpriteButton(replayButton);


        dialog.moveY(game.getGameConfiguration().getViewportHeight(),
                dialog.getLocationY(), 0.5f);

        dialog.addActionListener(new ObjectActionListener() {
            @Override
            public boolean onMoveCompleted(boolean direction) {
                goHomeButton.updateTouchArea();
                replayButton.updateTouchArea();
                return false;
            }

            @Override
            public boolean onMoveStarted(boolean direction) {
                return false;
            }
        });

        setDialog(dialog);


    }

    private void popUpBackKeyDialog() {

        if (isDialogShow() & (getDialog() != null)) {
            if (getDialog().getId() == DIALOG_TOMEMU) {
                killDialog();
                return;
            }
        } else {
            setDialogShow(true);
            ReallySimpleDialog dialog = new ReallySimpleDialog(game.getResourcesManager().getTexture_dialog_847x406()
                    , 0, 0, true, batch);
            dialog.setCenterLocation(game.getGameConfiguration().getViewportWidth() / 2f
                    , game.getGameConfiguration().getViewportHeight() / 2f);
            dialog.addGameObject(new GameObject(game.getResourcesManager().getTexture_text_ask_exit()
                    , 94f, 271f, true)
                    .setSpriteBatch(batch));
            dialog.setId(DIALOG_TOMEMU);

            final SpriteButton goHomeButton = new SpriteButton(game.getResourcesManager().getTexture_button_302x105()
                    , 94f, 105f, batch) {
                @Override
                public void actionTouchDown() {
                    super.actionTouchDown();
                    game.getResourcesManager().getSound_tap().play();
                }

                @Override
                public void actionTap() {
                    super.actionTap();
                    gotoMenuScreen();
                }
            };
            goHomeButton.setTopTexture(game.getResourcesManager().getTexture_btn_text_home());
            goHomeButton.enableDrawSprite(true);
            goHomeButton.setColorEffect(true,
                    GameColor.BUTTON_BLUE_NORMAL, GameColor.BUTTON_BLUE_TOUCHDOWN,
                    GameColor.MEMU_START_BUTTON_DIS_NORMAL, GameColor.MEMU_START_BUTTON_DIS_TOUCHDOWN);

            final SpriteButton stayButton = new SpriteButton(game.getResourcesManager().getTexture_button_302x105()
                    , 452f, 105f, batch) {
                @Override
                public void actionTouchDown() {
                    super.actionTouchDown();
                    game.getResourcesManager().getSound_tap().play();
                }

                @Override
                public void actionTap() {
                    super.actionTap();
                    killDialog();
                }
            };
            stayButton.setTopTexture(game.getResourcesManager().getTexture_btn_text_stay());
            stayButton.enableDrawSprite(true);
            stayButton.setColorEffect(true,
                    GameColor.BUTTON_PINK_NORMAL, GameColor.BUTTON_PINK_TOUCHDOWN,
                    GameColor.MEMU_START_BUTTON_DIS_NORMAL, GameColor.MEMU_START_BUTTON_DIS_TOUCHDOWN);


            dialog.addSpriteButton(goHomeButton);
            dialog.addSpriteButton(stayButton);


            dialog.moveY(game.getGameConfiguration().getViewportHeight(),
                    dialog.getLocationY(), 0.2f);

            dialog.addActionListener(new ObjectActionListener() {
                @Override
                public boolean onMoveCompleted(boolean direction) {
                    goHomeButton.updateTouchArea();
                    stayButton.updateTouchArea();
                    return false;
                }

                @Override
                public boolean onMoveStarted(boolean direction) {
                    return false;
                }
            });

            setDialog(dialog);
        }
    }

    private void setInputProcessor() {

        InputMultiplexer inputMultiplexer = new InputMultiplexer();

        inputMultiplexer.addProcessor(new GestureDetector(new GameGestureListener() {
            @Override
            public boolean touchDown(float x, float y, int pointer, int button) {
                if (isDialogShow() & (getDialog() != null)) {
                    getDialog().touchDown(x, y, pointer, button);
                } else {
                    for (GestureDetectableButton btn : gestureDetectableButtonArray) {
                        btn.touchDown(x, y, pointer, button);
                    }
                    for (GestureDetectableButton item : gameItemArray) {
                        item.touchDown(x, y, pointer, button);
                    }
                }

                return super.touchDown(x, y, pointer, button);
            }

            @Override
            public boolean tap(float x, float y, int count, int button) {
                if (isDialogShow() & (getDialog() != null)) {
                    getDialog().tap(x, y, count, button);
                } else {
                    for (GestureDetectableButton btn : gestureDetectableButtonArray) {
                        btn.tap(x, y, count, button);
                    }
                    for (GestureDetectableButton item : gameItemArray) {
                        item.tap(x, y, count, button);
                    }
                }
                return super.tap(x, y, count, button);
            }

            @Override
            public boolean longPress(float x, float y) {

                if (isDialogShow() & (getDialog() != null)) {
                    getDialog().longPress(x, y);
                } else {
                    for (GestureDetectableButton btn : gestureDetectableButtonArray) {
                        btn.longPress(x, y);
                    }
                    for (GestureDetectableButton item : gameItemArray) {
                        item.longPress(x, y);
                    }
                }
                return super.longPress(x, y);
            }

            @Override
            public boolean fling(float velocityX, float velocityY, int button) {
                for (GestureDetectableButton btn : gestureDetectableButtonArray) {
                    btn.fling(velocityX, velocityY, button);
                }
                if ((gameBoard != null) & !isDialogShow()) {
                    gameBoard.fling(velocityX, velocityY, button);
                }
                return super.fling(velocityX, velocityY, button);
            }

            @Override
            public boolean pan(float x, float y, float deltaX, float deltaY) {
                return super.pan(x, y, deltaX, deltaY);
            }

            @Override
            public boolean panStop(float x, float y, int pointer, int button) {
                return super.panStop(x, y, pointer, button);
            }

            @Override
            public boolean zoom(float initialDistance, float distance) {
                return super.zoom(initialDistance, distance);
            }

            @Override
            public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
                return super.pinch(initialPointer1, initialPointer2, pointer1, pointer2);
            }

            @Override
            public void pinchStop() {
                super.pinchStop();
            }
        }));

        inputMultiplexer.addProcessor(new InputProcessor() {
            @Override
            public boolean keyDown(int keycode) {
                if (keycode == Input.Keys.BACK) {
                    popUpBackKeyDialog();
                    return true;
                }
                return false;
            }

            @Override
            public boolean keyUp(int keycode) {
                return false;
            }

            @Override
            public boolean keyTyped(char character) {
                return false;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                return false;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                return false;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                return false;
            }

            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                return false;
            }

            @Override
            public boolean scrolled(int amount) {
                return false;
            }
        });

        Gdx.input.setInputProcessor(inputMultiplexer);

    }

    public boolean isDialogShow() {
        return dialogShow;
    }

    public void setDialogShow(boolean dialogShow) {
        if (dialogShow) {
            game.getResourcesManager().getSound_popup().play();
        }
        this.dialogShow = dialogShow;
    }

    public ReallySimpleDialog getDialog() {
        return dialog;
    }

    public void setDialog(ReallySimpleDialog dialog) {
        this.dialog = dialog;
    }

    private void killDialog() {
        setDialogShow(false);
        this.dialog = null;
    }


    private void draw(float delta) {
        Gdx.gl.glClearColor(7 / 255f, 38 / 255f, 59 / 255f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.getSpriteBatch().setProjectionMatrix(camera.combined);
        game.getSpriteBatch().begin();


        for (Renderable renderableObj : renderableObjectArray) {
            renderableObj.render(delta);
        }

        for (Renderable itemObj : gameItemArray) {
            itemObj.render(delta);
        }
        if (isDialogShow() & getDialog() != null) {
            getDialog().render(delta);
        }

        game.getSpriteBatch().end();
    }

    @Override
    public void show() {
        renderableObjectArray = new Array<Renderable>();
        gestureDetectableButtonArray = new Array<GestureDetectableButton>();
        gameItemArray = new Array<SpriteButton>();

        checkInterstitialAd();
        loadAdmobRewardedVideoAd();
        initGameObjects();
        setInputProcessor();

    }

    @Override
    public void render(float delta) {
        draw(delta);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        if (musicBgm != null) {
            musicBgm.stop();
            musicBgm.dispose();
        }
    }

    public int getGameLevel() {
        return gameLevel;
    }

    public int getItemLockMovesCondition() {
        return itemLockMovesCondition;
    }

    public void setItemLockMovesCondition(int itemLockMovesCondition) {
        this.itemLockMovesCondition = itemLockMovesCondition;
    }

    public class MissionPanel implements Renderable {
        private float locationY;
        private float locationX = 0f;
        private Position2D[] missionDotsPositions;
        private Array<DotsOfMission> dotsOfMissions;


        public MissionPanel(float locationY) {
            this.locationY = locationY;
            dotsOfMissions = new Array<DotsOfMission>();

            initThis();
        }

        private void initThis() {
            calcLocationX();
            calcDotsPositions();
        }

        private void loadMissions() {
            Array<MissionDots> missionDots = GameLevel.getLevel(gameLevel).getMission();
            int index = 0;
            for (MissionDots mission : missionDots) {
                for (int i = 0; i < mission.getMissionCount(); i++) {
                    DotsOfMission dotsMission = new DotsOfMission(
                            game.getResourcesManager().getTexture_menu_dotsArray().get(mission.getMissionDots() - 1),
                            missionDotsPositions[index].getX(), missionDotsPositions[index].getY(),
                            mission.getMissionDots());
                    dotsMission.setSpriteBatch(batch);
                    dotsMission.actionRotate(0, 360, 0.3f);

                    dotsOfMissions.add(dotsMission);
                    index++;
                }
            }
        }

        private void calcLocationX() {
            this.locationX = (game.getGameConfiguration().getViewportWidth()
                    - game.getResourcesManager().getTexture_game_mission_info_bg().getWidth()) / 2f;
        }

        private void calcDotsPositions() {
            final int MISSION_COUNT = 9;
            final float OFFSET_X = 25f;
            final float DOTS_SIZE = (float) game.getResourcesManager().getTexture_rect_90x90().getHeight();

            final float POSITION_Y
                    = ((float) game.getResourcesManager().getTexture_game_mission_info_bg().getHeight()
                    - DOTS_SIZE) / 2f;
            final float DOTS_GAP
                    = (game.getResourcesManager().getTexture_game_mission_info_bg().getWidth()
                    - DOTS_SIZE * MISSION_COUNT - 2 * OFFSET_X) / 8f;

            missionDotsPositions = new Position2D[MISSION_COUNT];

            for (int i = 0; i < MISSION_COUNT; i++) {
                missionDotsPositions[i] = new Position2D(locationX + OFFSET_X + (DOTS_SIZE + DOTS_GAP) * i,
                        locationY + POSITION_Y);
            }

            loadMissions();
        }

        @Override
        public void render(float delta) {
            batch.draw(game.getResourcesManager().getTexture_game_mission_info_bg(), locationX, locationY);

            for (DotsOfMission mission : dotsOfMissions) {
                mission.render(delta);
            }

        }


        public boolean checkMissionClear(int mergedDotsNum) {
            for (DotsOfMission mission : dotsOfMissions) {
                if (!mission.isMissionCleared() & mission.getDotNum() == mergedDotsNum) {
                    mission.setMissionCleared(true);
                    game.getLauncherHandler().toastMessage(mergedDotsNum % 2 == 0 ? "Wow" : "Nice");
                    return true;
                }
            }
            return false;
        }

        public int getNotClearedMissionNum() {
            int ret = 0;
            for (DotsOfMission mission : dotsOfMissions) {
                if (!mission.isMissionCleared()) {
                    ret++;
                }
            }
            return ret;
        }

        public boolean isMissionAllCleared() {
            return getNotClearedMissionNum() == 0;
        }

        public class DotsOfMission extends SpriteGameObject {
            private boolean missionCleared = false;
            private int dotNum;

            public DotsOfMission(Texture texture, float locationX, float locationY, int dotNum) {
                super(texture, locationX, locationY);
                this.dotNum = dotNum;
            }


            public boolean isMissionCleared() {
                return missionCleared;
            }

            public void setMissionCleared(boolean missionCleared) {
                if (this.missionCleared != missionCleared) {
                    actionRotate(0, 360, 0.34f);
                }
                this.missionCleared = missionCleared;
            }

            @Override
            public void render(float delta) {
                super.render(delta);
                if (isMissionCleared()) {
                    batch.draw(game.getResourcesManager().getTexture_level_selected_circle(),
                            getCenterX() - game.getResourcesManager().getTexture_level_selected_circle().getWidth() / 2f,
                            getCenterY() - game.getResourcesManager().getTexture_level_selected_circle().getHeight() / 2f);
                }
                getSprite().setPosition(getLocationFollowingLeaderX(), getLocationFollowingLeaderY());
                getSprite().draw(batch);
            }


            public int getDotNum() {
                return dotNum;
            }

            public void setDotNum(int dotNum) {
                this.dotNum = dotNum;
            }
        }
    }

    public class TopDisplayPanel implements Renderable {
        private float locationX, locationY;
        private int gameLevel;
        private Array<Renderable> renderableArray;
        private int gameTimeSec = 0;
        private Array<Integer> alarmTimeSecArray;
        private float gameTimer200msec = 0f;
        private float gameTimer1sec = 0f;
        private boolean timerStart = false;

        SpriteNumber gameLevelNumber, movesNumber, timeHourNumber, timeMinNumber, timeSecNumber;
        GameObject levelText, movesText, timeText, timeText_h, timeText_m, timeText_s;
        Array<Sprite> spritesTimeProgress;
        private int timeProgressIndex = 0;

        private int gameMovesNumber = -1;


        public TopDisplayPanel(int gameLevel, float locationX, float locationY) {
            this.gameLevel = gameLevel;
            this.locationX = locationX;
            this.locationY = locationY;

            this.renderableArray = new Array<Renderable>();
            this.alarmTimeSecArray = new Array<Integer>();
            initThis();
        }

        private void initThis() {
            setGameLevel(this.gameLevel);
            initTimeMovesTexts();
            initTimeProgressSprites();
            initTimeSprites();
            initMovesNumSprite();
        }

        public int getGameMovesNumber() {
            return gameMovesNumber;
        }

        public void setGameMovesNumber(int gameMovesNumber) {
            final float RIGHT_ALIGN_X = 542f;
            final float MOVES_ORIGIN_Y = 113f;

            if (getGameMovesNumber() != gameMovesNumber) {
                this.gameMovesNumber = gameMovesNumber;
                movesNumber.setNumber(getGameMovesNumber());
                movesNumber.setOrigin(new Position2D(locationX + RIGHT_ALIGN_X - movesNumber.getSpriteNumWidth(),
                        locationY + MOVES_ORIGIN_Y));
            }

        }

        public void increaseGameMovesNumber(int incNum) {
            setGameMovesNumber(getGameMovesNumber() + incNum);
        }

        private void initMovesNumSprite() {
            movesNumber = new SpriteNumber(game.getResourcesManager().getTexture_t35NumArray(),
                    0, batch, true);
            setGameMovesNumber(0);
            renderableArray.add(movesNumber);
        }

        private void initTimeSprites() {
            timeHourNumber = new SpriteNumber(game.getResourcesManager().getTexture_t35NumArray(), 0, batch, false);
            timeMinNumber = new SpriteNumber(game.getResourcesManager().getTexture_t35NumArray(), 0, batch, false);
            timeSecNumber = new SpriteNumber(game.getResourcesManager().getTexture_t35NumArray(), 0, batch, false);

            timeText_h = new GameObject(game.getResourcesManager().getTexture_t35_h(), 0, 0, false)
                    .setSpriteBatch(batch);
            timeText_m = new GameObject(game.getResourcesManager().getTexture_t35_m(), 0, 0, false)
                    .setSpriteBatch(batch);
            timeText_s = new GameObject(game.getResourcesManager().getTexture_t35_s(), 0, 0, false)
                    .setSpriteBatch(batch);

            renderableArray.add(timeHourNumber);
            renderableArray.add(timeText_h);
            renderableArray.add(timeMinNumber);
            renderableArray.add(timeText_m);
            renderableArray.add(timeSecNumber);
            renderableArray.add(timeText_s);

            upDateTimeNumbers(this.getGameTimeSec());
        }

        private void upDateTimeNumbers(int gameTimeSec) {
            final float TIME_ORIGIN_X = 569f;
            final float TIME_ORIGIN_Y = 47f;

            int hour = 0, min = 0, sec = 0;

            hour = gameTimeSec / 3600;
            min = (gameTimeSec - hour * 3600) / 60;
            sec = gameTimeSec - hour * 360 - min * 60;

            if (hour != 0) {//h:m:s
                timeHourNumber.setNumber(hour);
                timeHourNumber.setOrigin(new Position2D(locationX + TIME_ORIGIN_X, locationY + TIME_ORIGIN_Y));
                timeHourNumber.setShow(true);

                timeText_h.setLocation(timeHourNumber.getRightEdgeX() + timeHourNumber.getGap(),
                        locationY + TIME_ORIGIN_Y);
                timeText_h.setShow(true);

                timeMinNumber.setNumber(min);
                timeMinNumber.setOrigin(new Position2D(timeText_h.getLocationX()
                        + timeText_h.getWidth() + timeHourNumber.getGap(), locationY + TIME_ORIGIN_Y));
                timeMinNumber.setShow(true);

                timeText_m.setLocation(timeMinNumber.getRightEdgeX() + timeMinNumber.getGap(),
                        locationY + TIME_ORIGIN_Y);
                timeText_m.setShow(true);

                timeSecNumber.setNumber(sec);
                timeSecNumber.setOrigin(new Position2D(timeText_m.getLocationX()
                        + timeText_m.getWidth() + timeMinNumber.getGap(), locationY + TIME_ORIGIN_Y));
                timeSecNumber.setShow(true);

                timeText_s.setLocation(timeSecNumber.getRightEdgeX() + timeSecNumber.getGap(),
                        locationY + TIME_ORIGIN_Y);
                timeText_s.setShow(true);
            } else if (min != 0) {//m:s
                timeHourNumber.setShow(false);

                timeMinNumber.setNumber(min);
                timeMinNumber.setOrigin(new Position2D(locationX + TIME_ORIGIN_X, locationY + TIME_ORIGIN_Y));
                timeMinNumber.setShow(true);

                timeText_m.setLocation(timeMinNumber.getRightEdgeX() + timeMinNumber.getGap(),
                        locationY + TIME_ORIGIN_Y);
                timeText_m.setShow(true);

                timeSecNumber.setNumber(sec);
                timeSecNumber.setOrigin(new Position2D(timeText_m.getLocationX()
                        + timeText_m.getWidth() + timeMinNumber.getGap(), locationY + TIME_ORIGIN_Y));
                timeSecNumber.setShow(true);

                timeText_s.setLocation(timeSecNumber.getRightEdgeX() + timeSecNumber.getGap(),
                        locationY + TIME_ORIGIN_Y);
                timeText_s.setShow(true);

            } else {//s
                timeHourNumber.setShow(false);
                timeMinNumber.setShow(false);

                timeSecNumber.setNumber(sec);
                timeSecNumber.setOrigin(new Position2D(locationX + TIME_ORIGIN_X, locationY + TIME_ORIGIN_Y));
                timeSecNumber.setShow(true);

                timeText_s.setLocation(timeSecNumber.getRightEdgeX() + timeSecNumber.getGap(),
                        locationY + TIME_ORIGIN_Y);
                timeText_s.setShow(true);

            }
        }

        private void initTimeProgressSprites() {
            final float TIME_ORIGIN_X = 476f;
            final float TIME_ORIGIN_Y = 47f;
            final float WITH_GAP = 14f;

            spritesTimeProgress = new Array<Sprite>();
            for (int i = 0; i < 5; i++) {
                Sprite sp = new Sprite(game.getResourcesManager().getTexture_rec_10x10());
                sp.setColor(GameColor.GAME_TIME_PROGRESS_OFF);
                sp.setPosition(this.locationX + TIME_ORIGIN_X + WITH_GAP * i,
                        this.locationY + TIME_ORIGIN_Y);
                spritesTimeProgress.add(sp);
            }
        }

        private void initTimeMovesTexts() {
            final float TIME_ORIGIN_X = 476f;
            final float TIME_ORIGIN_Y = 67f;
            final float MOVES_ORIGIN_X = 569f;
            final float MOVES_ORIGIN_Y = 113f;

            timeText = new GameObject(game.getResourcesManager().getTexture_t19_time()
                    , this.locationX + TIME_ORIGIN_X, this.locationY + TIME_ORIGIN_Y
                    , true)
                    .setSpriteBatch(batch);

            movesText = new GameObject(game.getResourcesManager().getTexture_t19_moves()
                    , this.locationX + MOVES_ORIGIN_X, this.locationY + MOVES_ORIGIN_Y
                    , true)
                    .setSpriteBatch(batch);

            renderableArray.add(timeText);
            renderableArray.add(movesText);
        }

        protected void setGameLevel(int gameLevel) {
            final float GAP_TEXT = 33f;

            if (gameLevelNumber == null) {
                gameLevelNumber = new SpriteNumber(game.getResourcesManager().getTexture_t152NumArray(),
                        gameLevel, batch);
                gameLevelNumber.setOrigin(new Position2D(locationX, locationY));

                levelText = new GameObject(game.getResourcesManager().getTexture_t19_level(),
                        gameLevelNumber.getRightEdgeX() + GAP_TEXT,
                        gameLevelNumber.getOrigin().getY(), true)
                        .setSpriteBatch(batch);

                renderableArray.add(gameLevelNumber);
                renderableArray.add(levelText);
            } else {
                gameLevelNumber.setNumber(gameLevel);
            }

        }

        protected void onTimer1Sec() {
            setGameTimeSec(getGameTimeSec() + 1);
            upDateTimeNumbers(getGameTimeSec());
            checkAlarmSecond();
        }

        protected void onTimer200msec() {
            if (spritesTimeProgress == null) {
                return;
            }

            timeProgressIndex = timeProgressIndex < 5 ? timeProgressIndex + 1 : 0;
            for (int i = 0; i < 5; i++) {
                if (i < timeProgressIndex) {
                    spritesTimeProgress.get(i).setColor(GameColor.GAME_TIME_PROGRESS_ON);
                } else {
                    spritesTimeProgress.get(i).setColor(GameColor.GAME_TIME_PROGRESS_OFF);
                }
            }

        }

        private void checkAlarmSecond() {
            for (Integer time : this.alarmTimeSecArray) {
                if (getGameTimeSec() == time.intValue()) {
                    onAlarm(time.longValue());
                    break;
                }
            }
        }

        protected void onAlarm(long alarmSeconds) {

        }

        protected void addAlarmSecond(int alarmSeconds) {
            alarmTimeSecArray.add(alarmSeconds);
        }

        private void checkGameTimer(float delta) {
            this.gameTimer1sec += delta;
            this.gameTimer200msec += delta;
            boolean is200msec = false;
            boolean is1sec = false;

            if (this.gameTimer200msec >= 0.1990f) {
                this.gameTimer200msec = 0f;
                is200msec = true;
            }
            if (this.gameTimer1sec >= 1.9990f) {
                this.gameTimer1sec = 0f;
                is1sec = true;
            }

            if (is200msec) {
                onTimer200msec();
            }
            if (is1sec) {
                onTimer1Sec();
            }

        }

        public int getGameTimeSec() {
            return gameTimeSec;
        }

        public void setGameTimeSec(int gameTimeSec) {
            this.gameTimeSec = gameTimeSec;
        }

        @Override
        public void render(float delta) {
            if (isTimerStart()) {
                checkGameTimer(delta);
            }

            for (Renderable rend : renderableArray) {
                rend.render(delta);
            }

            for (Sprite sprite : spritesTimeProgress) {
                sprite.draw(batch);
            }
        }

        public boolean isTimerStart() {
            return timerStart;
        }

        public void setTimerStart(boolean timerStart) {
            this.timerStart = timerStart;
        }

    }
}
