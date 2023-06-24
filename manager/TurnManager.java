package manager;

import card.Card;
import card.Color;
import card.EffectCard;
import card.WildCard;
import deck.Deck;
import gameStates.GameGround;
import gameUI.GameIO;
import manager.cardSelectionManager.CardSelectionManager;
import manager.cardSelectionManager.MoveValidator;
import player.Player;

import java.util.List;

public class TurnManager {
    private final GameIO gameIO;
    private final CardSelectionManager cardSelectionManager;
    private final EffectManager effectManager;

    private final GameGround gameGround = GameGround.getInstance();
    private final Deck deck;

    public TurnManager(GameIO gameIO, CardSelectionManager cardSelectionManager,
                       EffectManager effectManager, Deck deck) {
        this.gameIO = gameIO;
        this.cardSelectionManager = cardSelectionManager;
        this.effectManager = effectManager;
        this.deck = deck;
    }

    public void handleValidMoves(Player currentPlayer, List<? extends Card> validMoves) {
        gameIO.displayMessage("Valid moves:");
        for (int i = 0; i < validMoves.size(); i++) {
            Card card = validMoves.get(i);
            gameIO.displayMessage((i + 1) + ". " + card.toString());
        }

        int cardIndex = cardSelectionManager.selectCardIndex(validMoves);
        Card selectedCard = validMoves.get(cardIndex);

        currentPlayer.getPlayerHand().removeCard(selectedCard);
        gameGround.setCurrentCard(selectedCard); // Update the gameGround with the selected card

        if (selectedCard instanceof EffectCard) {
            effectManager.applyEffectToNextPlayer(((EffectCard) selectedCard).getType());
        }
    }

    public void handleNoValidMoves(Card currentCard, Player currentPlayer) {
        Card drawnCard = deck.drawCard();
        currentPlayer.getPlayerHand().addCard(drawnCard);

        while (drawnCard.compareTo(currentCard) != 0) {
            gameIO.displayMessage(drawnCard + " is not valid, Drawing Card");
            drawnCard = deck.drawCard();
            currentPlayer.getPlayerHand().addCard(drawnCard);
        }

        if (drawnCard instanceof EffectCard effectCard) {
            gameGround.setCurrentCard(effectCard);
            effectManager.applyEffectToNextPlayer(effectCard.getType());
        } else {
            gameGround.setCurrentCard(drawnCard);
        }

        gameIO.displayMessage(drawnCard + " is played");
    }
}
