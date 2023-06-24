package player;

import card.Card;
import card.Color;
import gameUI.GameIO;
import player.hand.PlayerHand;
import manager.cardSelectionManager.MoveValidator;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int score;
    private PlayerHand hand;



    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.hand = new PlayerHand();
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore(int score) {
        this.score += score;
    }

    public PlayerHand getPlayerHand() {
        return hand;
    }
}
