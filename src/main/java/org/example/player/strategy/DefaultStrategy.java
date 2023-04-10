package org.example.player.strategy;

import org.example.card.Card;
import org.example.player.Decision;

import java.util.ArrayList;

public class DefaultStrategy extends Strategy{

    @Override
    public Decision hitOrStick(ArrayList<Card> hand) {
        if (getHandValue(hand) < 17)
            return Decision.HIT;
        else
            return Decision.STICK;
    }
}
