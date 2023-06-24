package manager;

import card.Card;
import card.WildCard;
import card.WildDrawFourCard;
import deck.Deck;
import gameStates.GameGround;

import java.util.ArrayList;
import java.util.List;

public class CardManager {
    private static CardManager instance;
    private Deck deck;
    private GameGround gameGround;

    private CardManager(Deck deck, GameGround gameGround) {
        this.deck = deck;
        this.gameGround = gameGround;
    }

    public static CardManager getInstance(Deck deck, GameGround gameGround) {
        if (instance == null) {
            instance = new CardManager(deck, gameGround);
        }
        return instance;
    }

    public void reshuffleWildCards() {
        reshuffleCurrentCard();
        reshuffleDiscardedCards();
    }

    private void reshuffleCurrentCard() {
        Card currentCard = gameGround.getCurrentCard();
        if (currentCard instanceof WildCard || currentCard instanceof WildDrawFourCard) {
            deck.addCard(currentCard);
            deck.shuffle();
            currentCard = deck.drawCard();
            gameGround.setCurrentCard(currentCard);
        }
    }

    private void reshuffleDiscardedCards() {
        List<Card> discardedCards = gameGround.getDiscardedCards();
        List<Card> wildCards = new ArrayList<>();

        for (Card card : discardedCards) {
            if (card instanceof WildCard || card instanceof WildDrawFourCard) {
                wildCards.add(card);
            }
        }

        for (Card wildCard : wildCards) {
            discardedCards.remove(wildCard);
            deck.addCard(wildCard);
        }

        deck.shuffle();
    }
}
