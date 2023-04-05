package org.example.dealer;

import org.example.card.Card;
import org.example.card.Deck;
import org.example.player.Player;

public class Dealer {
    private Deck deck;

    public Dealer(Deck cards) {
        this.deck = cards;
    }

    public void shuffleCards() {
        deck.shuffle();
    }

    public void deal(Player player, int numberOfCards) {
        for (int i = 0; i < numberOfCards; i++) {
            Card cardBeingGivenOut = deck.removeCard();
            player.takesCard(cardBeingGivenOut);
            System.out.println("Dealer deals card to player " + player.getId());
        }
    }

    @Override
    public String toString() {
        return "Dealer{" +
                "cards=" + deck +
                '}';
    }
}
