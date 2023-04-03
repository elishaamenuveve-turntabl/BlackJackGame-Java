package org.example;

import org.example.card.Deck;

public class Main {
    public static void main(String[] args) {
        Deck newDeck = new Deck();
        System.out.println(newDeck);
        newDeck.shuffle();
        System.out.println(newDeck);
    }
}