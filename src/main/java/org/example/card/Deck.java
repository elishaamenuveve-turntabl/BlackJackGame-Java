package org.example.card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck {
    private final int numberOfCards = 52;

    private ArrayList<Card> cards;

    public Deck() {
        this.cards  = new ArrayList<>(numberOfCards);
        this.populate();
    }

    private void populate() {
        for (Suit suit : Suit.values()) { //Hearts, Clubs, ...
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public String toString() {
        return "Deck{" +
                "numberOfCards=" + numberOfCards +
                ", cards=" + cards +
                '}';
    }
}
