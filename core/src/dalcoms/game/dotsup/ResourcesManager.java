package dalcoms.game.dotsup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;


public class ResourcesManager {
    private static ResourcesManager instance = new ResourcesManager();

    private Texture texture_title_splash;
    private Array<Texture> texture_dotsArray;
    private Texture text_dalcoms;
    private Texture text_dongle;

    private Texture texture_menu_level_bg;
    private Texture texture_title_menu;

    private Texture texture_roundRect_468x148;
    private Texture texture_menu_background_circles;
    private Texture texture_text_start;

    private Array<Texture> texture_t35NumArray;
    private Texture texture_level_sel_arrow_left;
    private Texture texture_level_sel_arrow_right;
    private Texture texture_level_selected_circle;

    private Array<Texture> texture_menu_dotsArray;
    private Texture texture_level_board_rect;
    private Texture texture_level_board_rect_disabled;
    private Texture texture_t35_x;

    private Texture texture_level_lock;

    private Texture texture_t35_s;
    private Texture texture_t35_m;
    private Texture texture_t35_h;

    private Texture texture_t19_time;
    private Texture texture_t19_moves;
    private Texture texture_t52_cleared;
    private Texture texture_t52_locked;
    private Texture texture_t52_new;

    private Texture texture_dialog_847x406;
    private Texture texture_button_302x105;
    private Texture texture_text_ask_exit;
    private Texture texture_btn_text_exit;
    private Texture texture_btn_text_stay;
    private Texture texture_btn_text_home;


    private Texture texture_t35_Loading;
    private Texture texture_circle_100x100;
    private Texture texture_circle_661x661;

    private Texture texture_circle_200x200;
    private Texture texture_game_home_btn;
    private Array<Texture> texture_t152NumArray;
    private Texture texture_t19_level;

    private Texture texture_rec_10x10;
    private Texture texture_game_bottom;

    private Texture texture_game_mission_info_bg;
    private Texture texture_rect_90x90;

    private Texture texture_game_cell_134x134;

    private Texture texture_btn_home_105x105;
    private Texture texture_btn_replay_105x105;
    private Texture texture_btn_text_next;
    private Texture texture_btn_text_replay;
    private Texture texture_dialog_870x718;
    private Texture texture_dialog_hat_770x288;
    private Texture texture_dialog_text_clear_all;
    private Texture texture_dialog_text_failed;
    private Texture texture_dialog_text_success;

    private Texture texture_t35_challenage_next_level;
    private Texture texture_t35_try_again;
    private Texture texture_t35_you_are_the_best;

    private Texture texture_music_off;
    private Texture texture_music_on;

    private Texture texture_t35_NO;
    private Texture texture_t35_YES;
    private Texture texture_item_bomb;
    private Texture texture_item_magic;
    private Texture texture_item_missile;

    private Texture texture_item_effect_1;
    private Texture texture_item_effect_2;

    private Texture texture_dice_dynamite;
    private Texture texture_dice_lock;
    private Texture texture_dice_rainbow;
    private Texture texture_item_rainbow;
    private Texture texture_dice_zero;
    private Texture texture_dice_missile;

    private Texture texture_button_more;
    private Texture texture_button_review;
    private Texture texture_button_share;

    private Texture texture_ico_xdriver;

    private Array<Texture> textureCarsArray;
    private Texture texture_crasheffect;
    private Texture texture_driving_after_image;
    private Texture texture_flag;
    private Texture texture_heart;
    private Texture texture_hud_bg;
    private Texture texture_me;
    private Texture texture_me_light;
    private Texture texture_roadline;
    private Texture texture_thumbup;
    private Texture texture_tire_footprint;
    private Texture texture_xdriver_title;
    private Texture texture_text_km;

    private Texture texture_mcpu_1;
    private Texture texture_mcpu_2;
    private Texture texture_mcpu_3;


    private Sound sound_tap;
    private Sound sound_missionClear;
    private Sound sound_merge;
    private Sound sound_dotsNew;
    private Sound sound_popup;
    private Sound sound_item;


    public static ResourcesManager getInstance() {
        return instance;
    }

    public void loadResources() {
        loadTextureResources();
        loadSoundResources();
    }

    private void loadSoundResources() {
        sound_tap = Gdx.audio.newSound(Gdx.files.internal("Sound/sound_tap.wav"));
        sound_missionClear = Gdx.audio.newSound(Gdx.files.internal("Sound/mission_clear.mp3"));
        sound_merge = Gdx.audio.newSound(Gdx.files.internal("Sound/sound_merge.mp3"));
        sound_dotsNew = Gdx.audio.newSound(Gdx.files.internal("Sound/sound_dotsNew.mp3"));
        sound_popup = Gdx.audio.newSound(Gdx.files.internal("Sound/sound_popup.mp3"));
        sound_item = Gdx.audio.newSound(Gdx.files.internal("Sound/sound_item.mp3"));
    }

    private void loadTextureResources() {
        texture_title_splash = new Texture(Gdx.files.internal("title_splash.png"));
        texture_dotsArray = new Array<Texture>() {
            {
                add(new Texture(Gdx.files.internal("dice_1.png")));
                add(new Texture(Gdx.files.internal("dice_2.png")));
                add(new Texture(Gdx.files.internal("dice_3.png")));
                add(new Texture(Gdx.files.internal("dice_4.png")));
                add(new Texture(Gdx.files.internal("dice_5.png")));
                add(new Texture(Gdx.files.internal("dice_6.png")));
                add(new Texture(Gdx.files.internal("dice_7.png")));
                add(new Texture(Gdx.files.internal("dice_8.png")));
                add(new Texture(Gdx.files.internal("dice_9.png")));

                add(new Texture(Gdx.files.internal("dice_lock.png")));//10
                add(new Texture(Gdx.files.internal("dice_missile.png")));//11
                add(new Texture(Gdx.files.internal("dice_zero.png")));//12

            }
        };
        text_dalcoms = new Texture(Gdx.files.internal("text_dalcoms.png"));
        text_dongle = new Texture(Gdx.files.internal("dongle_text.png"));


        texture_menu_level_bg = new Texture(Gdx.files.internal("menu_level_bg.png"));
        texture_title_menu = new Texture(Gdx.files.internal("title_menu.png"));

        texture_roundRect_468x148 = new Texture(Gdx.files.internal("roundRect_468x148.png"));

        texture_menu_background_circles =
                new Texture(Gdx.files.internal("menu_background_circles.png"));
        texture_text_start = new Texture(Gdx.files.internal("text_start.png"));

        texture_t35NumArray = new Array<Texture>() {
            {
                add(new Texture(Gdx.files.internal("t35_num_0.png")));
                add(new Texture(Gdx.files.internal("t35_num_1.png")));
                add(new Texture(Gdx.files.internal("t35_num_2.png")));
                add(new Texture(Gdx.files.internal("t35_num_3.png")));
                add(new Texture(Gdx.files.internal("t35_num_4.png")));
                add(new Texture(Gdx.files.internal("t35_num_5.png")));
                add(new Texture(Gdx.files.internal("t35_num_6.png")));
                add(new Texture(Gdx.files.internal("t35_num_7.png")));
                add(new Texture(Gdx.files.internal("t35_num_8.png")));
                add(new Texture(Gdx.files.internal("t35_num_9.png")));
            }
        };

        texture_level_sel_arrow_left = new Texture(Gdx.files.internal("level_sel_arrow_left.png"));
        texture_level_sel_arrow_right =
                new Texture(Gdx.files.internal("level_sel_arrow_right.png"));

        texture_level_selected_circle =
                new Texture(Gdx.files.internal("level_selected_circle.png"));

        texture_menu_dotsArray = new Array<Texture>() {
            {
                add(new Texture(Gdx.files.internal("level_dots_1.png")));
                add(new Texture(Gdx.files.internal("level_dots_2.png")));
                add(new Texture(Gdx.files.internal("level_dots_3.png")));
                add(new Texture(Gdx.files.internal("level_dots_4.png")));
                add(new Texture(Gdx.files.internal("level_dots_5.png")));
                add(new Texture(Gdx.files.internal("level_dots_6.png")));
                add(new Texture(Gdx.files.internal("level_dots_7.png")));
                add(new Texture(Gdx.files.internal("level_dots_8.png")));
                add(new Texture(Gdx.files.internal("level_dots_9.png")));
            }
        };
        texture_level_board_rect = new Texture(Gdx.files.internal("level_board_rect.png"));
        texture_level_board_rect_disabled =
                new Texture(Gdx.files.internal("level_board_rect_disabled.png"));
        texture_t35_x = new Texture(Gdx.files.internal("t35_x.png"));

        texture_level_lock = new Texture(Gdx.files.internal("level_lock.png"));

        texture_t35_s = new Texture(Gdx.files.internal("t35_s.png"));
        texture_t35_m = new Texture(Gdx.files.internal("t35_m.png"));
        texture_t35_h = new Texture(Gdx.files.internal("t35_h.png"));
        texture_t19_time = new Texture(Gdx.files.internal("t19_time.png"));
        texture_t19_moves = new Texture(Gdx.files.internal("t19_moves.png"));
        texture_t52_cleared = new Texture(Gdx.files.internal("t52_cleared.png"));
        texture_t52_locked = new Texture(Gdx.files.internal("t52_locked.png"));
        texture_t52_new = new Texture(Gdx.files.internal("t52_new.png"));

        texture_dialog_847x406 = new Texture(Gdx.files.internal("dialog_847x406.png"));
        texture_button_302x105 = new Texture(Gdx.files.internal("button_302x105.png"));
        texture_text_ask_exit = new Texture(Gdx.files.internal("text_ask_exit.png"));
        texture_btn_text_exit = new Texture(Gdx.files.internal("btn_text_exit.png"));
        texture_btn_text_stay = new Texture(Gdx.files.internal("btn_text_stay.png"));
        texture_btn_text_home = new Texture(Gdx.files.internal("btn_text_home.png"));


        texture_t35_Loading = new Texture(Gdx.files.internal("t35_Loading.png"));
        texture_circle_100x100 = new Texture(Gdx.files.internal("circle_100x100.png"));
        texture_circle_661x661 = new Texture(Gdx.files.internal("circle_661x661.png"));

        texture_t152NumArray = new Array<Texture>() {
            {
                add(new Texture(Gdx.files.internal("t152_0.png")));
                add(new Texture(Gdx.files.internal("t152_1.png")));
                add(new Texture(Gdx.files.internal("t152_2.png")));
                add(new Texture(Gdx.files.internal("t152_3.png")));
                add(new Texture(Gdx.files.internal("t152_4.png")));
                add(new Texture(Gdx.files.internal("t152_5.png")));
                add(new Texture(Gdx.files.internal("t152_6.png")));
                add(new Texture(Gdx.files.internal("t152_7.png")));
                add(new Texture(Gdx.files.internal("t152_8.png")));
                add(new Texture(Gdx.files.internal("t152_9.png")));
            }
        };

        texture_circle_200x200 = new Texture(Gdx.files.internal("circle_200x200.png"));
        texture_game_home_btn = new Texture(Gdx.files.internal("game_home_btn.png"));
        texture_t19_level = new Texture(Gdx.files.internal("t19_level.png"));
        texture_rec_10x10 = new Texture(Gdx.files.internal("rec_10x10.png"));
        texture_game_bottom = new Texture(Gdx.files.internal("game_bottom.png"));

        texture_game_mission_info_bg = new Texture(Gdx.files.internal("game_mission_info_bg.png"));
        texture_rect_90x90 = new Texture(Gdx.files.internal("rect_90x90.png"));

        texture_game_cell_134x134 = new Texture(Gdx.files.internal("game_cell_134x134.png"));

        texture_btn_home_105x105 = new Texture(Gdx.files.internal("btn_home_105x105.png"));
        texture_btn_replay_105x105 = new Texture(Gdx.files.internal("btn_replay_105x105.png"));
        texture_btn_text_next = new Texture(Gdx.files.internal("btn_text_next.png"));
        texture_btn_text_replay = new Texture(Gdx.files.internal("btn_text_replay.png"));
        texture_dialog_870x718 = new Texture(Gdx.files.internal("dialog_870x718.png"));
        texture_dialog_hat_770x288 = new Texture(Gdx.files.internal("dialog_hat_770x288.png"));
        texture_dialog_text_clear_all =
                new Texture(Gdx.files.internal("dialog_text_clear_all.png"));
        texture_dialog_text_failed = new Texture(Gdx.files.internal("dialog_text_failed.png"));
        texture_dialog_text_success = new Texture(Gdx.files.internal("dialog_text_success.png"));

        texture_t35_challenage_next_level =
                new Texture(Gdx.files.internal("t35_challenage_next_level.png"));
        texture_t35_try_again = new Texture(Gdx.files.internal("t35_try_again.png"));
        texture_t35_you_are_the_best = new Texture(Gdx.files.internal("t35_you_are_the_best.png"));

        texture_music_off = new Texture(Gdx.files.internal("music_off.png"));
        texture_music_on = new Texture(Gdx.files.internal("music_on.png"));

        texture_item_bomb = new Texture(Gdx.files.internal("item_bomb.png"));
        texture_item_magic = new Texture(Gdx.files.internal("item_magic.png"));
        texture_item_missile = new Texture(Gdx.files.internal("item_missile.png"));

        texture_t35_NO = new Texture(Gdx.files.internal("t35_NO.png"));
        texture_t35_YES = new Texture(Gdx.files.internal("t35_YES.png"));
        texture_item_effect_1 = new Texture(Gdx.files.internal("item_effect_1.png"));
        texture_item_effect_2 = new Texture(Gdx.files.internal("item_effect_2.png"));

        texture_dice_dynamite = new Texture(Gdx.files.internal("dice_dynamite.png"));
        texture_dice_lock = new Texture(Gdx.files.internal("dice_lock.png"));
        texture_dice_rainbow = new Texture(Gdx.files.internal("dice_rainbow.png"));
        texture_item_rainbow = new Texture(Gdx.files.internal("item_rainbow.png"));

        texture_button_more = new Texture(Gdx.files.internal("button_more.png"));
        texture_button_review = new Texture(Gdx.files.internal("button_review.png"));
        texture_button_share = new Texture(Gdx.files.internal("button_share.png"));

        texture_ico_xdriver = new Texture(Gdx.files.internal("ico_xdriver.png"));
        texture_tire_footprint = new Texture(Gdx.files.internal("tire_footprint.png"));

        texture_mcpu_1 = new Texture(Gdx.files.internal("mcpu_1.png"));
        texture_mcpu_2 = new Texture(Gdx.files.internal("mcpu_2.png"));
        texture_mcpu_3 = new Texture(Gdx.files.internal("mcpu_3.png"));


        loadTextureResourcesOfXdriver();

    }

    private void loadTextureResourcesOfXdriver() {

        textureCarsArray = new Array<Texture>() {
            {
                add(new Texture(Gdx.files.internal("car_1.png")));
                add(new Texture(Gdx.files.internal("car_2.png")));
                add(new Texture(Gdx.files.internal("car_3.png")));
                add(new Texture(Gdx.files.internal("car_4.png")));
                add(new Texture(Gdx.files.internal("car_5.png")));
                add(new Texture(Gdx.files.internal("car_6.png")));
                add(new Texture(Gdx.files.internal("car_7.png")));
                add(new Texture(Gdx.files.internal("car_8.png")));
                add(new Texture(Gdx.files.internal("car_9.png")));
            }
        };
        texture_crasheffect = new Texture(Gdx.files.internal("crasheffect.png"));
        texture_driving_after_image = new Texture(Gdx.files.internal("driving_after_image.png"));
        texture_flag = new Texture(Gdx.files.internal("flag.png"));
        texture_heart = new Texture(Gdx.files.internal("heart.png"));
        texture_hud_bg = new Texture(Gdx.files.internal("hud_bg.png"));
        texture_me = new Texture(Gdx.files.internal("me.png"));
        texture_me_light = new Texture(Gdx.files.internal("me_light.png"));
        texture_roadline = new Texture(Gdx.files.internal("roadline.png"));
        texture_thumbup = new Texture(Gdx.files.internal("thumbup.png"));
        texture_tire_footprint = new Texture(Gdx.files.internal("tire_footprint.png"));
        texture_xdriver_title = new Texture(Gdx.files.internal("xdriver_title.png"));
        texture_text_km = new Texture(Gdx.files.internal("text_km.png"));

    }

    public Array<Texture> getTexture_dotsArray() {
        return texture_dotsArray;
    }

    public Texture getTexture_title_splash() {
        return texture_title_splash;
    }

    public Texture getText_dalcoms() {
        return text_dalcoms;
    }

    public Texture getText_dongle() {
        return text_dongle;
    }

    public Texture getTexture_menu_level_bg() {
        return texture_menu_level_bg;
    }

    public Texture getTexture_title_menu() {
        return texture_title_menu;
    }

    public Texture getTexture_roundRect_468x148() {
        return texture_roundRect_468x148;
    }

    public Texture getTexture_menu_background_circles() {
        return texture_menu_background_circles;
    }

    public Texture getTexture_text_start() {
        return texture_text_start;
    }

    public Array<Texture> getTexture_t35NumArray() {
        return texture_t35NumArray;
    }

    /**
     * @param num 0~9
     * @return Texture of number. If num is over 9 it will return 0.
     */
    public Texture getTexture_t35Num(int num) {
        if (num > 9) {
            num = 0;
            Gdx.app.log("getTexture_t35Num", String.valueOf(num) + " is over limit >> fixed to 0");
        }
        return getTexture_t35NumArray().get(num);
    }

    public Texture getTexture_level_sel_arrow_left() {
        return texture_level_sel_arrow_left;
    }

    public Texture getTexture_level_sel_arrow_right() {
        return texture_level_sel_arrow_right;
    }

    public Texture getTexture_level_selected_circle() {
        return texture_level_selected_circle;
    }

    public Array<Texture> getTexture_menu_dotsArray() {
        return texture_menu_dotsArray;
    }

    public Texture getTexture_level_board_rect() {
        return texture_level_board_rect;
    }

    public Texture getTexture_t35_x() {
        return texture_t35_x;
    }

    public Texture getTexture_level_lock() {
        return texture_level_lock;
    }

    public Texture getTexture_t35_s() {
        return texture_t35_s;
    }

    public Texture getTexture_t35_m() {
        return texture_t35_m;
    }

    public Texture getTexture_t35_h() {
        return texture_t35_h;
    }

    public Texture getTexture_t19_time() {
        return texture_t19_time;
    }

    public Texture getTexture_t19_moves() {
        return texture_t19_moves;
    }

    public Texture getTexture_t52_cleared() {
        return texture_t52_cleared;
    }

    public Texture getTexture_t52_locked() {
        return texture_t52_locked;
    }

    public Texture getTexture_t52_new() {
        return texture_t52_new;
    }

    public Texture getTexture_dialog_847x406() {
        return texture_dialog_847x406;
    }

    public Texture getTexture_button_302x105() {
        return texture_button_302x105;
    }

    public Texture getTexture_text_ask_exit() {
        return texture_text_ask_exit;
    }

    public Texture getTexture_btn_text_exit() {
        return texture_btn_text_exit;
    }

    public Texture getTexture_btn_text_stay() {
        return texture_btn_text_stay;
    }

    public Texture getTexture_btn_text_home() {
        return texture_btn_text_home;
    }

    public Texture getTexture_t35_Loading() {
        return texture_t35_Loading;
    }

    public Texture getTexture_circle_100x100() {
        return texture_circle_100x100;
    }

    public Texture getTexture_circle_661x661() {
        return texture_circle_661x661;
    }

    public Texture getTexture_circle_200x200() {
        return texture_circle_200x200;
    }

    public Texture getTexture_game_home_btn() {
        return texture_game_home_btn;
    }

    public Array<Texture> getTexture_t152NumArray() {
        return texture_t152NumArray;
    }

    public Texture getTexture_t19_level() {
        return texture_t19_level;
    }

    public Texture getTexture_rec_10x10() {
        return texture_rec_10x10;
    }

    public Texture getTexture_game_mission_info_bg() {
        return texture_game_mission_info_bg;
    }

    public Texture getTexture_rect_90x90() {
        return texture_rect_90x90;
    }

    public Texture getTexture_game_cell_134x134() {
        return texture_game_cell_134x134;
    }

    public Texture getTexture_btn_home_105x105() {
        return texture_btn_home_105x105;
    }

    public Texture getTexture_btn_replay_105x105() {
        return texture_btn_replay_105x105;
    }

    public Texture getTexture_btn_text_next() {
        return texture_btn_text_next;
    }

    public Texture getTexture_btn_text_replay() {
        return texture_btn_text_replay;
    }

    public Texture getTexture_dialog_870x718() {
        return texture_dialog_870x718;
    }

    public Texture getTexture_dialog_hat_770x288() {
        return texture_dialog_hat_770x288;
    }

    public Texture getTexture_dialog_text_clear_all() {
        return texture_dialog_text_clear_all;
    }

    public Texture getTexture_dialog_text_failed() {
        return texture_dialog_text_failed;
    }

    public Texture getTexture_dialog_text_success() {
        return texture_dialog_text_success;
    }

    public Texture getTexture_t35_challenage_next_level() {
        return texture_t35_challenage_next_level;
    }

    public Texture getTexture_t35_try_again() {
        return texture_t35_try_again;
    }

    public Texture getTexture_t35_you_are_the_best() {
        return texture_t35_you_are_the_best;
    }

    public Texture getTexture_music_off() {
        return texture_music_off;
    }

    public Texture getTexture_music_on() {
        return texture_music_on;
    }


    public Texture getTexture_t35_NO() {
        return texture_t35_NO;
    }

    public Texture getTexture_t35_YES() {
        return texture_t35_YES;
    }

    public Texture getTexture_item_bomb() {
        return texture_item_bomb;
    }

    public Texture getTexture_item_magic() {
        return texture_item_magic;
    }

    public Texture getTexture_item_missile() {
        return texture_item_missile;
    }

    public Texture getTexture_item_effect_1() {
        return texture_item_effect_1;
    }

    public Texture getTexture_item_effect_2() {
        return texture_item_effect_2;
    }

    public Texture getTexture_dice_dynamite() {
        return texture_dice_dynamite;
    }

    public Texture getTexture_dice_lock() {
        return texture_dice_lock;
    }

    public Texture getTexture_dice_rainbow() {
        return texture_dice_rainbow;
    }

    public Texture getTexture_item_rainbow() {
        return texture_item_rainbow;
    }

    public Texture getTexture_button_more() {
        return texture_button_more;
    }

    public Texture getTexture_button_review() {
        return texture_button_review;
    }

    public Texture getTexture_button_share() {
        return texture_button_share;
    }

    public Sound getSound_tap() {
        return sound_tap;
    }

    public Sound getSound_missionClear() {
        return sound_missionClear;
    }

    public Sound getSound_merge() {
        return sound_merge;
    }

    public Sound getSound_dotsNew() {
        return sound_dotsNew;
    }

    public Sound getSound_popup() {
        return sound_popup;
    }

    public Sound getSound_item() {
        return sound_item;
    }

    public void disposeSplashScreenResources() {
        texture_title_splash.dispose();
        text_dalcoms.dispose();
        text_dongle.dispose();
    }

    public void disposeMenuScreenResources() {
        texture_roundRect_468x148.dispose();
        texture_menu_background_circles.dispose();
        texture_text_start.dispose();
    }

    public Texture getTexture_game_bottom() {
        return texture_game_bottom;
    }

    public Texture getTexture_ico_xdriver() {
        return texture_ico_xdriver;
    }

    public Texture getTexture_tire_footprint() {
        return texture_tire_footprint;
    }

    public Array<Texture> getTextureCarsArray() {
        return textureCarsArray;
    }

    public Texture getTextureCar(int index) {
        return getTextureCarsArray().get(index);
    }

    public Texture getTexture_crasheffect() {
        return texture_crasheffect;
    }

    public Texture getTexture_driving_after_image() {
        return texture_driving_after_image;
    }

    public Texture getTexture_flag() {
        return texture_flag;
    }

    public Texture getTexture_heart() {
        return texture_heart;
    }

    public Texture getTexture_hud_bg() {
        return texture_hud_bg;
    }

    public Texture getTexture_me() {
        return texture_me;
    }

    public Texture getTexture_me_light() {
        return texture_me_light;
    }

    public Texture getTexture_roadline() {
        return texture_roadline;
    }

    public Texture getTexture_thumbup() {
        return texture_thumbup;
    }

    public Texture getTexture_xdriver_title() {
        return texture_xdriver_title;
    }

    public Texture getTexture_text_km() {
        return texture_text_km;
    }

    public Texture getTexture_mcpu_1() {
        return texture_mcpu_1;
    }

    public Texture getTexture_mcpu_2() {
        return texture_mcpu_2;
    }

    public Texture getTexture_mcpu_3() {
        return texture_mcpu_3;
    }

    public Texture getTexture_missionClearPopup(int i) {
        switch (i) {
            case 0:
                return getTexture_mcpu_1();
            case 1:
                return getTexture_mcpu_2();
            case 2:
                return getTexture_mcpu_3();
            default:
                return getTexture_mcpu_1();
        }
    }

    public Texture getTexture_level_board_rect_disabled() {
        return texture_level_board_rect_disabled;
    }

    public void disposeGameScreenResources() {

    }

    public void disposeSoundResources() {
        sound_tap.dispose();
        sound_missionClear.dispose();
        sound_merge.dispose();
        sound_dotsNew.dispose();
        sound_popup.dispose();
        sound_item.dispose();
    }
}