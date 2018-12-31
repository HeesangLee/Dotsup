package dalcoms.game.dotsup;

import com.badlogic.gdx.Gdx;
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




    public static ResourcesManager getInstance() {
        return instance;
    }

    public void loadResources() {
        loadTextureResources();
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
            }
        };
        text_dalcoms = new Texture(Gdx.files.internal("text_dalcoms.png"));
        text_dongle = new Texture(Gdx.files.internal("dongle_text.png"));


        texture_menu_level_bg = new Texture(Gdx.files.internal("menu_level_bg.png"));
        texture_title_menu = new Texture(Gdx.files.internal("title_menu.png"));

        texture_roundRect_468x148 = new Texture(Gdx.files.internal("roundRect_468x148.png"));

        texture_menu_background_circles = new Texture(Gdx.files.internal("menu_background_circles.png"));
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
        texture_level_sel_arrow_right = new Texture(Gdx.files.internal("level_sel_arrow_right.png"));

        texture_level_selected_circle = new Texture(Gdx.files.internal("level_selected_circle.png"));

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
        texture_level_board_rect_disabled = new Texture(Gdx.files.internal("level_board_rect_disabled.png"));
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
        texture_dialog_text_clear_all = new Texture(Gdx.files.internal("dialog_text_clear_all.png"));
        texture_dialog_text_failed = new Texture(Gdx.files.internal("dialog_text_failed.png"));
        texture_dialog_text_success = new Texture(Gdx.files.internal("dialog_text_success.png"));

        texture_t35_challenage_next_level = new Texture(Gdx.files.internal("t35_challenage_next_level.png"));
        texture_t35_try_again = new Texture(Gdx.files.internal("t35_try_again.png"));
        texture_t35_you_are_the_best = new Texture(Gdx.files.internal("t35_you_are_the_best.png"));


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

    public Texture getTexture_level_board_rect_disabled() {
        return texture_level_board_rect_disabled;
    }

    public void disposeGameScreenResources() {

    }
}
