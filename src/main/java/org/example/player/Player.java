package org.example.player;

import org.example.card.Card;

import java.util.ArrayList;

public class Player {
    private static int numberOfPlayers;
    private final int id;
    private ArrayList<Card> hand;

    public Player() {
        numberOfPlayers++;
        this.id = numberOfPlayers;
        this.hand = new ArrayList<>(3);
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
        if (this.handValue() < 17){
            System.out.println("Player " + id + " has decided to "+ Decision.HIT);
            return Decision.HIT;
        }
         System.out.println("Player " + id + " "+ Decision.STICK + "s");
        return Decision.STICK;
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
