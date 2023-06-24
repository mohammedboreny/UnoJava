package player.hand;

import card.Card;
import java.util.ArrayList;
import java.util.List;

public class PlayerHand {
    private List<Card> cards;

    public PlayerHand() {
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        if (card != null) {
            cards.add(card);
        }
    }

    public boolean hasCard(Card card) {
        return cards.contains(card);
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }

    public List<Card> getCards() {
        return new ArrayList<>(cards);  // Return a copy of the list to prevent direct modification
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
