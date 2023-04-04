package org.example.game;

import org.example.card.Deck;
import org.example.dealer.Dealer;
import org.example.player.Decision;
import org.example.player.Player;

public class Game {
    private static boolean isOver;
    public static void main(String[] args) {
        Dealer dealer = new Dealer(new Deck());
        dealer.shuffleCards();

        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();

        dealer.deal(player1, 2);
        dealer.deal(player2, 2);
        dealer.deal(player3, 2);

        Decision playerOnesDecision = player1.decision();
        Decision playerTwosDecision = player2.decision();
        Decision playerThreesDecision = player3.decision();

        if (playerOnesDecision == Decision.HIT) {
            dealer.deal(player1, 1);
        }

        if (playerTwosDecision == Decision.HIT) {
            dealer.deal(player2, 1);
        }

        if (playerThreesDecision == Decision.HIT) {
            dealer.deal(player3, 1);
        }

        System.out.println(player1);
        System.out.println(player2);
        System.out.println(player3);
        System.out.println(dealer);
    }
}
