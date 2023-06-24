package manager.cardSelectionManager;

import card.Color;
import gameUI.GameIO;
import gameUI.GameUI;

public class WildCardColorSelector {
    private static WildCardColorSelector instance;
    private GameIO gameIO;
    private GameUI gameUI;
    private WildCardColorSelector(GameIO gameIO, GameUI gameUI) {
        this.gameIO = gameIO;
        this.gameUI = gameUI;
    }
    public static WildCardColorSelector getInstance(GameIO gameIO, GameUI gameUI) {
        if (instance == null) {
            instance = new WildCardColorSelector(gameIO, gameUI);
        }
        return instance;
    }
    public Color selectWildCardColor() {
        int colorIndex = gameUI.askForColor();
        Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
        if (colorIndex >= 1 && colorIndex <= colors.length) {
            return colors[colorIndex - 1];
        } else {
            gameIO.displayMessage("Invalid color selection. Please try again.");
            return selectWildCardColor();
        }
    }

}
