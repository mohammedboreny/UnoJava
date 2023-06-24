package manager;

import card.*;
import player.Player;
import gameStates.list.PlayerList;
import gameStates.GameGround;
import manager.cardSelectionManager.CardSelectionManager;

public class EffectManager {
    private static EffectManager instance;
    private PlayerList<Player> players;
    private PlayerManager playerManager;
    private CardSelectionManager cardSelectionManager;
    private GameGround gameGround;

    private EffectManager(PlayerList<Player> players, PlayerManager playerManager, CardSelectionManager cardSelectionManager, GameGround gameGround) {
        this.players = players;
        this.playerManager = playerManager;
        this.cardSelectionManager = cardSelectionManager;
        this.gameGround = gameGround;
    }

    public static EffectManager getInstance(PlayerList<Player> players, PlayerManager playerManager, CardSelectionManager cardSelectionManager, GameGround gameGround) {
        if (instance == null) {
            instance = new EffectManager(players, playerManager, cardSelectionManager, gameGround);
        }
        return instance;
    }

    public void applyEffectToNextPlayer(String effectType) {
        Player currentPlayer = players.getCurrentPlayer();
        Player nextPlayer = players.getNextPlayer();

        switch (effectType.toUpperCase()) {
            case "SKIP" -> {
                players.moveToNextPlayer();
            } // Skip the next player
            case "REVERSE" -> players.reverseOrder();
            case "DRAW_TWO" -> playerManager.drawCards(nextPlayer, 2);
            case "WILD" -> {
                // Implement the logic for a Wild card effect
                Color chosenColor = cardSelectionManager.selectWildCardColor();
                Card currentCard = gameGround.getCurrentCard();
                if (currentCard instanceof EffectCard) {
                    ((WildCard) currentCard).setChosenColor(chosenColor);
                }
                gameGround.setCurrentCard(currentCard);
            }
            case "DRAW_FOUR" -> {
                playerManager.drawCards(nextPlayer, 4);
                Color chosenColor = cardSelectionManager.selectWildCardColor();
                Card currentCard = gameGround.getCurrentCard();
                if (currentCard instanceof EffectCard) {
                    ((WildDrawFourCard) currentCard).setChosenColor(chosenColor);
                }
                gameGround.setCurrentCard(currentCard);
            }
            default -> {
                // Handle any other effect types
            }
        }
    }
}
