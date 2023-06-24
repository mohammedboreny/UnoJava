package gameUI;

import card.*;
import player.Player;
import gameStates.list.PlayerList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameIO {
    private BufferedReader reader;

    public GameIO() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String getInput(String prompt) {
        try {
            displayMessage(prompt);
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getIntInput(String prompt) {
        int inputNumber = -1;
        boolean validInput = false;

        while (!validInput) {
            String input = getInput(prompt);
            try {
                inputNumber = Integer.parseInt(input);
                validInput = true;
            } catch (NumberFormatException e) {
                displayMessage("Invalid input. Please enter a valid number.");
            }
        }

        return inputNumber;
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public String displayCard(Card card) {
        if (card instanceof NumberedAndColoredCard numberedCard) {
            return numberedCard.getNumber() + " (" + numberedCard.getColor() + ")";
        } else if (card instanceof EffectCard effectCard) {
            return effectCard.getType() + (effectCard.getColor() == null ? "" : "\t" + effectCard.getColor());
        } else {
            return card.getDisplayName();
        }
    }

    public int getNumberOfPlayers() {
        int numPlayers = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                String input = getInput("Enter the number of players (2-10): ");
                numPlayers = Integer.parseInt(input);

                if (numPlayers >= 2 && numPlayers <= 10) {
                    validInput = true;
                } else {
                    displayMessage("Invalid number of players. Please enter a number between 2 and 10.");
                }
            } catch (NumberFormatException e) {
                displayMessage("Invalid input. Please enter a valid number.");
            }
        }

        return numPlayers;
    }


    public void createPlayers(PlayerList<Player> players,int count) {

        for (int i = 1; i <= count; i++) {
            try {
                displayMessage("Enter the name of Player " + i + ": ");
                String playerName = reader.readLine();
                Player player = new Player(playerName);
                players.addPlayer(player);
            } catch (IOException e) {
                displayMessage("Error reading input. Please try again.");
            }
        }
    }
}
