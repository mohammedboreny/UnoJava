package manager;

import card.Card;
import deck.Deck;
import player.Player;
import player.hand.PlayerHand;

public class PlayerManager {
    private static PlayerManager instance;
    private Deck deck;

    private PlayerManager(Deck deck) {
        this.deck = deck;
    }

    public static PlayerManager getInstance(Deck deck) {
        if (instance == null) {
            instance = new PlayerManager(deck);
        }
        return instance;
    }

    public void drawCards(Player player, int count) {
        PlayerHand playerHand = player.getPlayerHand();
        for (int i = 0; i < count; i++) {
            Card card = deck.drawCard();
            playerHand.addCard(card);
        }
    }

}
