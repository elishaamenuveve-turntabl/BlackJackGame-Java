package org.example;

import org.example.card.Deck;
import org.example.player.Player;

public class Main {
    public static void main(String[] args) {
        // create deck
        Deck newDeck = new Deck();
        System.out.println(newDeck);

        // shuffle deck
        newDeck.shuffle();
        System.out.println(newDeck);

        // create player
        Player mary = new Player();

        // give player card
        mary.takesCard(newDeck.pop());
        mary.takesCard(newDeck.pop());


        System.out.println(mary);
        System.out.println(newDeck);


    }
}