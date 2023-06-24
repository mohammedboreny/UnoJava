package game;

import deck.Deck;
import gameStates.GameGround;
import gameUI.GameIO;
import gameUI.GameUI;
import manager.TurnManager;
import manager.cardSelectionManager.CardSelectionManager;
import manager.EffectManager;
import manager.PlayerManager;
import manager.cardSelectionManager.CardSelector;
import manager.cardSelectionManager.WildCardColorSelector;
import player.Player;
import gameStates.list.PlayerList;
import manager.cardSelectionManager.MoveValidator;

public abstract class UnoGame {
    protected PlayerList<Player> players;
    protected PlayerManager playerManager;
    protected EffectManager effectManager;

    protected TurnManager turnManager;
    protected Deck deck;
    protected GameIO gameIO;
    protected GameUI gameUI;
    protected MoveValidator moveValidator;
    protected CardSelectionManager cardSelectionManager;
    protected GameGround gameGround;

    public UnoGame() {
        players = PlayerList.getInstance();
        deck = new Deck();
        gameIO = new GameIO();
        gameUI =new GameUI(gameIO);
        MoveValidator moveValidator = new MoveValidator();
        playerManager = PlayerManager.getInstance(deck);
        CardSelector cardSelector = new CardSelector(gameIO);

        WildCardColorSelector wildCardColorSelector =  WildCardColorSelector.getInstance(gameIO,gameUI);
        cardSelectionManager = CardSelectionManager.getInstance(cardSelector, moveValidator, wildCardColorSelector,gameIO);
        gameGround = GameGround.getInstance();
        effectManager =  EffectManager.getInstance(players, playerManager, cardSelectionManager, gameGround);
        turnManager = new TurnManager(gameIO, cardSelectionManager, effectManager, deck);

    }


    public abstract void play();
}
