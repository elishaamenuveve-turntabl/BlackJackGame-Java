package org.example.player;

import org.example.card.Card;

import java.util.ArrayList;

public class Player {
    private static int numberOfPlayers;
    private int id;
    private ArrayList<Card> hand;

    public Player() {
        Player.numberOfPlayers++;
        this.id = numberOfPlayers;
        this.hand = new ArrayList<>(3);
    }

    public int getHandValue () {
        int handValue = 0;
        for (Card card : hand) {
            handValue += card.getValue();
        }
        return handValue;
    }

     public void takesCard(Card card) {
        hand.add(card);
     }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", hand=" + hand +
                ", handValue=" + getHandValue() +
                '}';
    }
}
