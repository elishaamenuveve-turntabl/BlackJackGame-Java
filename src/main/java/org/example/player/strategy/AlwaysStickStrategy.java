package org.example.player.strategy;

import org.example.card.Card;
import org.example.player.Decision;

import java.util.ArrayList;

public class AlwaysStickStrategy extends Strategy {
    @Override
    public Decision hitOrStick(ArrayList<Card> hand) {
            return Decision.STICK;
    }
}
