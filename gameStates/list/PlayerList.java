package gameStates.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerList<T> {
    private static PlayerList<?> instance;
    private List<T> players;
    private int currentPlayerIndex;

    private PlayerList() {
        players = new ArrayList<>();
        currentPlayerIndex = 0;
    }

    public static <T> PlayerList<T> getInstance() {
        if (instance == null) {
            instance = new PlayerList<>();
        }
        return (PlayerList<T>) instance;
    }
    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public List<T> getPlayers() {
        return players;
    }

    public void addPlayer(T player) {
        players.add(player);
    }

    public T getCurrentPlayer() {
        if (players.isEmpty()) {
            return null;
        }
        return players.get(currentPlayerIndex);
    }

    public T getNextPlayer() {
        if (players.isEmpty()) {
            return null;
        }

        int nextPlayerIndex = currentPlayerIndex + 1;
        if (nextPlayerIndex >= players.size()) {
            nextPlayerIndex = 0;  // Wrap around to the first player
        }
        return players.get(nextPlayerIndex);
    }



    public int getNextPlayerIndex(int playerIndex) {
        int nextPlayerIndex = playerIndex + 1;
        if (nextPlayerIndex >= players.size()) {
            nextPlayerIndex = 0;  // Wrap around to the first player
        }

        return nextPlayerIndex;
    }


    public void moveToNextPlayer() {
        if (players.isEmpty()) {
            return;
        }
        currentPlayerIndex = getNextPlayerIndex(currentPlayerIndex);
    }

    public void reverseOrder() {
        if (players.isEmpty()) {
            return;
        }
        Collections.reverse(players);
        currentPlayerIndex = players.size() - 1 - currentPlayerIndex;
    }
}
