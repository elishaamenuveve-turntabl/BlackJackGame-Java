package org.example.game;

import org.example.dealer.Dealer;
import org.example.player.Decision;
import org.example.player.Player;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class GameRoom {
    Dealer dealer;
    List<Player> players;
    Map<Player, Decision> playerDecisions;
    List<Player> winners;

    public GameRoom(List<Player> newPlayers, Dealer dealer) {
        this.players = new ArrayList<>();
        this.playerDecisions = new HashMap<>();
        this.winners = new ArrayList<>();

        this.players.addAll(newPlayers);
        this.dealer = dealer;
    }



    public void startGame()  {
        dealer.shuffleCards();

        for (Player player : players)
            dealer.deal(player, 2);
        for (Player player : players)
            playerDecisions.put(player, player.decision());





        do {
            playNextRound();

            for(Player playerAtTable: playerDecisions.keySet()) {
                if (playerAtTable.getHandValue() == 21) {
                    winners.add(playerAtTable);
                }
            }

            playerDecisions.replaceAll((p, v) -> p.decision());
        }
        while (playerDecisions.size() > 1 || !winners.isEmpty());



        System.out.println(dealer);
    }

    public void playNextRound() {
        for(Map.Entry<Player, Decision> playerDecision: playerDecisions.entrySet()) {
            if (playerDecision.getValue() == Decision.HIT) {
                dealer.deal(playerDecision.getKey(),1);
            }
        }
            playerDecisions.values().removeAll(Collections.singleton(Decision.STICK));

    }

    public void checkForWinners() {
        if (!winners.isEmpty()) {
            System.out.println("The winner(s): ");
            for (Player player : winners) {
                System.out.println(player);
            }
        } else if (!playerDecisions.isEmpty()) {


        } else {

        }
    }

    public void displayAllPlayersInformation() {

    }


//    public void loopThrough(Runnable function, int numberOfLoops) {
//        for (int i = 0; i < numberOfLoops; i++) {
//            function.run();
//        }
//    }

}

