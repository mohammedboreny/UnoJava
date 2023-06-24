package gameUI;

import card.*;
import player.Player;

import java.util.List;

public class GameUI {
    private GameIO gameIO;

    public GameUI(GameIO gameIO) {
        this.gameIO = gameIO;
    }
    public void displayRankingList(List<Player> rankingList) {
        gameIO.displayMessage("===== Ranking List =====");
        int rank = 1;
        for (Player player : rankingList) {
            String playerInfo = "Rank " + rank + ": " + player.getName() + " (Score: " + player.getScore() + ")";
            gameIO.displayMessage(playerInfo);
            rank++;
        }
        gameIO.displayMessage("========================");
    }

    public void displayPlayerName(Player player) {
        gameIO.displayMessage("Current Player: " + player.getName());
    }
    public void displayPlayerCards(List<Card> playerCards) {
        gameIO.displayMessage("Your Cards: " + playerCards);
    }
    public void displayPlayerScore(int score) {
        gameIO.displayMessage("Your Score: " + score);
    }
    public void displayPlayerScore(Player player) {
        System.out.println("Player Score: " + player.getScore());
    }


    public int askForColor() {
        int colorIndex=0;
        boolean validInput = false;

        do {
            String input = gameIO.getInput("Choose a color index (1-4):RED,BLUE,GREEN,YELLOW ");
            try {
                colorIndex = Integer.parseInt(input);
                if (colorIndex >= 1 && colorIndex <= 4) {
                    validInput = true;
                } else {
                    gameIO.displayMessage("Invalid color index. Please choose a number from 1 to 4.");
                }
            } catch (NumberFormatException e) {
                gameIO.displayMessage("Invalid input. Please enter a valid number.");
            }
        } while (!validInput);

        return colorIndex;
    }



    public void displayCurrentCard(Card currentCard) {
        gameIO.displayMessage("Current card: " + gameIO.displayCard(currentCard));
    }
}
