package gameStates;

import card.Card;

import java.util.ArrayList;
import java.util.List;

public class GameGround {
    private static GameGround instance;
    private Card currentCard;
    private List<Card> discardedCards;
    private GameGround() {
        discardedCards = new ArrayList<>();
    }
    public static  GameGround getInstance() {
        if (instance == null) {
            instance = new GameGround();
        }
        return instance;
    }
    public Card getCurrentCard() {
        return currentCard;
    }
    public void setCurrentCard(Card currentCard) {
        this.currentCard = currentCard;
    }
    public List<Card> getDiscardedCards() {
        return discardedCards;
    }
}
