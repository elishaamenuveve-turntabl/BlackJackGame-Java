package org.example.card;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class DeckTest {
    private Deck deck;

    @BeforeEach
    public void setup() {
        // arrange
        deck = new Deck();
    }
    @Test
    public void cardUniquenessInDeckTest() {
        //arrange
        ArrayList<Card> uniqueCards = new ArrayList<>();

        // act
        for (Card card : deck.getCards()) {
            boolean isUnique = true;
            for (Card uniqueCard : uniqueCards) {
                if (uniqueCard.getSuit() == card.getSuit() && uniqueCard.getRank() == card.getRank()) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                uniqueCards.add(card);
            }
        }

        // assert
        assertEquals(deck.getSize(), uniqueCards.size());
        assertEquals(52, uniqueCards.size());
        assertEquals(52, deck.getSize());
    }

    @Test
    public void removeCardFromDeckTest() {
        Card removedCard  = deck.removeCard();

        assertEquals(51, deck.getSize());
        assertFalse(deck.getCards().contains(removedCard));
    }

}
