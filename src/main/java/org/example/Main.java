package org.example;

import org.example.card.Deck;
import org.example.dealer.Dealer;
import org.example.game.GameRoom;
import org.example.player.Player;
import org.example.player.strategy.AlwaysHitStrategy;
import org.example.player.strategy.AlwaysStickStrategy;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        List<Player> players = new ArrayList<>();
        int numberOfPlayers = 3;
        System.out.println(args[0]);

        try {
            for (int i = 0; i < args.length; i++) {
                if (Objects.equals(args[i], "--player") && i + 1 < args.length) {
                    switch (args[i + 1]) {
                        case "always-stick" -> {
                            if (players.size() < 6) {
                                players.add(new Player(new AlwaysStickStrategy()));
                            }
                        }
                        case "always-hit" -> {
                            if (players.size() < 6) {
                                players.add(new Player(new AlwaysHitStrategy()));
                            }
                        }
                        case "risk-calculator", "default" -> {
                            if (players.size() < 6) {
                                players.add(new Player());
                            }
                        }
                    }
                }
            }
        }  catch (Exception e) {
            System.out.println(e);
        }

        try {
            int numberOfPlayersPassed = 0;
            for (int i = 0; i < args.length; i++) {
                if (Objects.equals(args[i], "--num-players") && i + 1 < args.length) {
                    numberOfPlayersPassed = Integer.parseInt(args[i + 1]);
                    System.out.println(numberOfPlayersPassed);
                    break;
                }
            }
            if (numberOfPlayersPassed > 1 && numberOfPlayersPassed <= 6) {
                numberOfPlayers = numberOfPlayersPassed;
            }
        } catch (Exception e) {
            System.out.println(e);
        }


        for (int i = 0; i < numberOfPlayers - players.size(); i++) {
            players.add(new Player());
        }

        Deck cards = new Deck();
        Dealer blackJackDealer = new Dealer(cards);
        GameRoom gameRoom = new GameRoom(players, blackJackDealer);
        gameRoom.startGame();

    }
}