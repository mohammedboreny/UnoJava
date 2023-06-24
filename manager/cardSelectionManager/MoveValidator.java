package manager.cardSelectionManager;

import card.Card;

import java.util.ArrayList;
import java.util.List;

public class MoveValidator {

    public List<Card> getValidMoves(List<Card> hand, Card currentCard) {
        List<Card> validMoves = new ArrayList<>();

        try {
            for (Card playedCard : hand) {
                if (playedCard.compareTo(currentCard) >= 0) {
                    validMoves.add(playedCard);
                }
            }
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }

        return validMoves;
    }

}
