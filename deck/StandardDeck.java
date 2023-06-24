package deck;

import card.Card;
import card.Color;

import java.util.ArrayList;
import java.util.List;

public class StandardDeck extends DeckInitializer {
    private static StandardDeck instance;
    private List<Card> cards;

    private StandardDeck() {
        // Private constructor to prevent instantiation
        cards = initializeDeck();
    }

    public static  StandardDeck getInstance() {
        if (instance == null) {
            instance = new StandardDeck();
        }
        return instance;
    }

    @Override
    public List<Card> initializeDeck() {
        List<Card> cards = new ArrayList<>();

        // Adding NumberedAndColored cards
        for (Color color : Color.values()) {
            if (color != Color.WILD) {
                for (int number = 0; number <= 9; number++) {
                    cards.add(Card.createCard("Numbered",color, number, number));
                    if (number != 0) {
                        cards.add(Card.createCard("Numbered",color, number, number));
                    }
                }
            }
        }

        // Adding Effect cards
        for (int i = 0; i < 2; i++) {
            for (Color color : Color.values()) {
                if (color != Color.WILD) {
                    cards.add(Card.createCard("SKIP",color, 20,0));
                    cards.add(Card.createCard("REVERSE",color, 20, 0));
                    cards.add(Card.createCard("DRAW_TWO",color, 20, 0));
                }
            }
        }

        // Adding Wild cards
        for (int i = 0; i < 4; i++) {
            cards.add(Card.createCard("WILD",Color.WILD, 50,1));
            cards.add(Card.createCard("WILD_DRAW_FOUR",Color.WILD, 50,1));
        }

        return cards;
    }

}
