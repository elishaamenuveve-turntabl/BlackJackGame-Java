package org.example.player.strategy;

import org.example.card.Card;
import org.example.player.Decision;

import java.util.ArrayList;

public abstract class Strategy {

    int getHandValue(ArrayList<Card> hand) {
        int handValue = 0;
        for (Card card : hand) {
            handValue += card.getValue();
        }
        return handValue;
    }

    public abstract Decision hitOrStick(ArrayList<Card> hand);
}
