package org.example.card;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DeckTest {
    @Test
    public void cardUniquenessInDeckTest() {
        // arrange
        Deck cut = new Deck();
        ArrayList<Card> uniqueCards = new ArrayList<>();

        // act
        for (Card card : cut.getCards()) {
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
        assertEquals(cut.getSize(), uniqueCards.size());
        assertEquals(52, uniqueCards.size());
        assertEquals(52, cut.getSize());


    }
}
