package game;

import card.*;

import player.Player;
import player.hand.PlayerHand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyUno extends UnoGame {
    protected List<Player> rankingList;
    protected int scoreLimit;

    public MyUno() {
        rankingList = new ArrayList<>();
    }

    @Override
    public void play() {
        createPlayers();
        dealInitialCards();
        gameLogic();
        determineRanking();
        gameUI.displayRankingList(rankingList)
;    }

    private int getValidScoreLimit() {
        int scoreLimit;
        do {
            scoreLimit = gameIO.getIntInput("Enter the score limit (100-1000): ");
        } while (scoreLimit < 100 || scoreLimit > 1000);
        return scoreLimit;
    }

    private void gameLogic() {
        while (!isGameOver()) {
            Player currentPlayer = players.getCurrentPlayer();
            displayGameState(currentPlayer);
            // Get the current card and player's hand
            Card currentCard = gameGround.getCurrentCard();
            PlayerHand playerHand = currentPlayer.getPlayerHand();
            // Get the valid moves for the player's hand and current card
            List<Card> validMoves = cardSelectionManager.getValidMoves(playerHand.getCards(), currentCard);
            // Check if the player has won the game
            if (validMoves.isEmpty()) {
                turnManager.handleNoValidMoves(currentCard, currentPlayer);
                currentPlayer.incrementScore(currentCard.getValue());
            } else {
                turnManager.handleValidMoves(currentPlayer, validMoves);
                currentPlayer.incrementScore(currentCard.getValue());
            }
            gameUI.displayPlayerScore(currentPlayer.getScore());
            players.moveToNextPlayer();
        }
    }



    private void dealInitialCards() {
        deck.shuffle();
        Card drawnCard = deck.drawCard();
        if (drawnCard instanceof WildDrawFourCard || drawnCard instanceof WildCard) {
            deck.shuffle();
            drawnCard = deck.drawCard(); // Draw a new card
        }
        gameGround.setCurrentCard(drawnCard);
        scoreLimit = getValidScoreLimit();
        for (Player player : players.getPlayers()) {
            PlayerHand playerHand = player.getPlayerHand();
            for (int i = 0; i < 7; i++) {
                Card card = deck.drawCard();
                playerHand.addCard(card);
            }
        }
    }

    protected void displayGameState(Player currentPlayer) {
        Card currentCard = gameGround.getCurrentCard();
        gameUI.displayPlayerName(currentPlayer);
        gameUI.displayPlayerCards(currentPlayer.getPlayerHand().getCards());
        gameUI.displayCurrentCard(currentCard);
        gameUI.displayPlayerScore(currentPlayer.getScore());
    }


    protected boolean isGameOver() {
        List<Player> playersToRemove = new ArrayList<>();

        for (Player player : players.getPlayers()) {
            if (player.getPlayerHand().getCards().isEmpty() || player.getScore() >= scoreLimit) {
                rankingList.add(player); // Add player to ranking list
                playersToRemove.add(player); // Mark player for removal
            }
        }

        // Add the last player to the ranking list if there is only one player left
        if (players.getPlayers().size() == 1) {
            Player lastPlayer = players.getPlayers().get(0);
            rankingList.add(lastPlayer);
            playersToRemove.add(lastPlayer); // Mark player for removal
        }

        // Remove the marked players
        players.getPlayers().removeAll(playersToRemove);

        return players.getPlayers().size() <= 1;
    }
    protected void determineRanking() {
        rankingList.sort(Comparator.comparingInt(Player::getScore));
        Collections.reverse(rankingList);
    }

    public void createPlayers() {
     gameIO.createPlayers(players,gameIO.getNumberOfPlayers());
    }



}
