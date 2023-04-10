package org.example.player;

import org.example.card.Card;
import org.example.player.strategy.AlwaysHitStrategy;
import org.example.player.strategy.AlwaysStickStrategy;
import org.example.player.strategy.DefaultStrategy;
import org.example.player.strategy.Strategy;

import java.util.ArrayList;

public class Player {
    private static int numberOfPlayers;
    private final int id;
    private ArrayList<Card> hand;
    private final Strategy strategy;

    public Player(Strategy strategy) {
        numberOfPlayers++;
        this.id = numberOfPlayers;
        this.hand = new ArrayList<>(3);
        this.strategy = strategy;
    }

    public Player() {
        this(new DefaultStrategy());
    }

    public int handValue() {
        int handValue = 0;
        for (Card card : hand) {
            handValue += card.getValue();
        }
        return handValue;
    }

     public void takesCard(Card card) {
        hand.add(card);
     }

     public Decision decision() {
        return strategy.hitOrStick(hand);
     }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", hand=" + hand +
                ", handValue=" + handValue() +
                '}';
    }
}
