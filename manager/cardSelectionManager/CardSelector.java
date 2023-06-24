package manager.cardSelectionManager;

import card.Card;
import gameUI.GameIO;

import java.util.List;

public class CardSelector {
    private GameIO gameIO;

    public CardSelector(GameIO gameIO) {
        this.gameIO = gameIO;
    }

    public int selectCardIndex(List<Card> cards) {
        int cardIndex = -1;
        boolean validInput = false;

        while (!validInput) {
            try {
                String input = gameIO.getInput("Enter the number corresponding to your choice: ");
                cardIndex = Integer.parseInt(input) - 1;

                if (cardIndex >= 0 && cardIndex < cards.size()) {
                    validInput = true;
                } else {
                    gameIO.displayMessage("Invalid card index. Please select a valid index.");
                }
            } catch (NumberFormatException e) {
                gameIO.displayMessage("Invalid input. Please enter a valid number.");
            }
        }

        return cardIndex;
    }
}
