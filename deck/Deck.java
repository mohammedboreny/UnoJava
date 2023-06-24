package deck;

import card.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        DeckInitializer deckInitializer = StandardDeck.getInstance();
        // Initialize the deck using the deck initializer
        this.cards = new ArrayList<>(deckInitializer.initializeDeck());
    }



    public void addCard(Card card) {
        cards.add(card);
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public int getSize() {
        return cards.size();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public Card drawCard() {
        if (!isEmpty()) {
            return cards.remove(0);
        }
        return null;
    }
}
