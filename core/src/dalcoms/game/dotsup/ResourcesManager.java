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
    private Texture texture_t35_x;

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
        texture_t35_x = new Texture(Gdx.files.internal("t35_x.png"));

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

    public void disposeGameScreenResources() {

    }
}
