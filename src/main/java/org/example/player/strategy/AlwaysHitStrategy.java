package org.example.player.strategy;

import org.example.card.Card;
import org.example.player.Decision;

import java.util.ArrayList;

public class AlwaysHitStrategy extends Strategy{

    @Override
    public Decision hitOrStick(ArrayList<Card> hand) {
        if (getHandValue(hand) < 21)
            return Decision.HIT;
        else
            return Decision.STICK;
    }
}
