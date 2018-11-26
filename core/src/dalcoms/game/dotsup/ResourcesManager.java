package dalcoms.game.dotsup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;


public class ResourcesManager {
    private static ResourcesManager instance = new ResourcesManager();

    private Texture texture_title_splash;
    private Array<Texture> texture_dotsArray;
    private Texture text_dalcoms;

    private Texture texture_menu_level_bg;
    private Texture texture_title_menu;
    private Texture texture_background_circle;

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

        texture_menu_level_bg = new Texture(Gdx.files.internal("menu_level_bg.png"));
        texture_title_menu = new Texture(Gdx.files.internal("title_menu.png"));
        texture_background_circle = new Texture(Gdx.files.internal("menu_background_circle.png"));
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

    public Texture getTexture_menu_level_bg() {
        return texture_menu_level_bg;
    }

    public Texture getTexture_title_menu() {
        return texture_title_menu;
    }

    public Texture getTexture_background_circle() {
        return texture_background_circle;
    }

    public void disposeSplashScreenResources() {
        texture_title_splash.dispose();
        text_dalcoms.dispose();
    }

    public void disposeMenuScreenResources() {

    }

    public void disposeGameScreenResources() {

    }
}
