package org.example;

import org.example.card.Deck;
import org.example.dealer.Dealer;
import org.example.game.GameRoom;
import org.example.player.Player;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            players.add(new Player());
        }

        Deck cards = new Deck();
        Dealer blackJackDealer = new Dealer(cards);
        GameRoom gameRoom = new GameRoom(players, blackJackDealer);
        gameRoom.startGame();

    }
}