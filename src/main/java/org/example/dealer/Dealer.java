package org.example.dealer;

import org.example.card.Card;
import org.example.card.Deck;
import org.example.player.Player;

public class Dealer {
    private Deck cards;

    public Dealer(Deck cards) {
        this.cards = cards;
    }

    public void shuffleCards() {
        cards.shuffle();
    }

    public void deal(Player player, int numberOfCards) {
        for (int i = 0; i < numberOfCards; i++) {
            Card cardBeingGivenOut = cards.removeCard();
            player.takesCard(cardBeingGivenOut);
        }
    }

    @Override
    public String toString() {
        return "Dealer{" +
                "cards=" + cards +
                '}';
    }
}
