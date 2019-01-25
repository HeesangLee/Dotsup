package dalcoms.game.dotsup;

public class GameItem {
    private String itemName;
    private int condition;

    public GameItem(String itemName, int condition) {
        this.itemName = itemName;
        this.condition = condition;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }
}
