package org.example.game;

import org.example.dealer.Dealer;
import org.example.player.Decision;
import org.example.player.Player;

import java.util.*;

public class GameRoom {
    String name;
    Dealer dealer;
    List<Player> players;
    Map<Player, PlayerState> playersStates;

    public GameRoom(List<Player> newPlayers, Dealer dealer, String name) {
        this.name = name;
        System.out.println(name + " Game Room Opened\n");
        this.players = new ArrayList<>();
        this.playersStates = new HashMap<>(newPlayers.size());

        for (Player player: newPlayers) {
            this.players.add(player);
            System.out.println("Player " + player.getId() + " has entered the " + name + "Game Room");
        }

        this.dealer = dealer;
        System.out.println("A dealer has entered the game room. \n");
    }

    public GameRoom(List<Player> newPlayers, Dealer dealer) {
        this(newPlayers, dealer, "Main");
    }



    public void startGame()  {
        System.out.println("Game has started...");
        for (Player player: players) {
            this.playersStates.put(player, PlayerState.IN_GAME);
            System.out.println("Player " + player.getId() + " has joined the game\n");
        }

        dealer.shuffleCards();

        players.forEach((player -> dealer.deal(player, 2)));
        System.out.println();
        updatePlayersStates();

        int numberOfRounds = 0;
        while (!isGameOver())
        {
                numberOfRounds++;
                System.out.println("\nRound: " + numberOfRounds);
                playRound();
                updatePlayersStates();
        }
        System.out.println("\nGAME OVER!\n");
        System.out.println("Players reveal their hand.\n\n");
        players.forEach((System.out::println));

        if (playersStates.containsValue(PlayerState.WON)) {
            System.out.println("\n\nGAME WINNERS");
            for (Map.Entry<Player, PlayerState> playerStateEntry : playersStates.entrySet()) {
                if (playerStateEntry.getValue() == PlayerState.WON) {
                    System.out.println("Player " + playerStateEntry.getKey().getId());
                }
            }
        } else {
            System.out.println("\n\n NO PLAYER WON!");
        }
    }

    private boolean isGameOver() {
        // A player has hit 21
        if (playersStates.containsValue(PlayerState.WON))
            return true;

        // All players have decided to Stick
        if (!playersStates.containsValue(PlayerState.IN_GAME))
        {
            int highestHandValue = 0;
            for (Map.Entry<Player, PlayerState> entry : playersStates.entrySet()) {
             if (entry.getKey().handValue() > highestHandValue && entry.getValue() == PlayerState.HAS_STUCK) {
                    highestHandValue = entry.getKey().handValue();
                }
            }
            for (Player player : players) {
                if (player.handValue() == highestHandValue && playersStates.get(player) == PlayerState.HAS_STUCK) {
                    playersStates.put(player, PlayerState.WON);
                }
            }
            return true;
        }


        // Only One player remains in Game
        int numberOfPlayersInGame = 0;
        for (PlayerState playerState : playersStates.values()) {
            if (playerState == PlayerState.IN_GAME)
                numberOfPlayersInGame++;
        }
        if (numberOfPlayersInGame == 1 && !playersStates.containsValue(PlayerState.HAS_STUCK)) {
            for (Map.Entry<Player, PlayerState> entry : playersStates.entrySet()) {
                if (entry.getValue() == PlayerState.IN_GAME)
                    entry.setValue(PlayerState.WON);
            }
            return true;
        }
        else
            return false;
    }

    public void updatePlayersStates() {
        for (Player player: players) {
            if (isPlayerBust(player))
                playersStates.put(player, PlayerState.BUSTED);
            else if (player.handValue() == 21)
                playersStates.put(player, PlayerState.WON);
        }
    }


    public void playRound() {
        for(Map.Entry<Player, PlayerState> playerStateEntry: playersStates.entrySet()) {
            if (playerStateEntry.getValue() == PlayerState.IN_GAME) {
                Decision playerDecision = playerStateEntry.getKey().decision();
                if (playerDecision == Decision.HIT) {
                    dealer.deal(playerStateEntry.getKey(), 1);
                } else if (playerDecision == Decision.STICK) {
                 playerStateEntry.setValue(PlayerState.HAS_STUCK);
                }
            }
        }
//        for(Map.Entry<Player, Decision> playerDecision: playerDecisions.entrySet()) {
//            if (playerDecision.getValue() == Decision.HIT) {
//                dealer.deal(playerDecision.getKey(),1);
//            }
//        }
//            playerDecisions.values().removeAll(Collections.singleton(Decision.STICK));

    }

    public void displayAllPlayersInformation() {
        for (Player player: players) {
            System.out.println(player);
        }
    }
     public boolean isPlayerBust(Player player) {
        return player.handValue() > 21;
     }

}

