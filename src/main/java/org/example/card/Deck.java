package org.example.card;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        this.cards  = new ArrayList<>(52);
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

    public Card removeCard() {
        //check for cards
        return cards.remove(0);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getSize() {
        return cards.size();
    }


    @Override
    public String toString() {
        return "Deck{" +
                "numberOfCards=" + getSize() +
                ", cards=" + cards +
                '}';
    }


}


