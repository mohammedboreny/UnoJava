package manager.cardSelectionManager;

import card.Card;
import card.Color;
import gameUI.GameIO;

import java.util.List;

public class CardSelectionManager {
    private static CardSelectionManager instance;
    private CardSelector cardSelector;
    private MoveValidator moveValidator;
    private WildCardColorSelector wildCardColorSelector;
   private GameIO gameIO;

    private CardSelectionManager(CardSelector cardSelector, MoveValidator moveValidator, WildCardColorSelector wildCardColorSelector,GameIO gameIO) {
        this.cardSelector = cardSelector;
        this.moveValidator = moveValidator;
        this.wildCardColorSelector = wildCardColorSelector;
        this.gameIO=gameIO;
    }

    public static CardSelectionManager getInstance(CardSelector cardSelector, MoveValidator moveValidator, WildCardColorSelector wildCardColorSelector,GameIO gameIO) {
        if (instance == null) {
            instance = new CardSelectionManager(cardSelector, moveValidator, wildCardColorSelector,gameIO);
        }
        return instance;
    }

    public int selectCardIndex(List<? extends Card> cards) {
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
    public List<Card> getValidMoves(List<Card> hand, Card currentCard) {
return moveValidator.getValidMoves(hand,currentCard);
    }

        public Color selectWildCardColor() {
        return wildCardColorSelector.selectWildCardColor();
    }

}
