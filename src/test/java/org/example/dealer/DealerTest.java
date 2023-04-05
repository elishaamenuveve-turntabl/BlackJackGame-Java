package org.example.dealer;

import org.example.card.Card;
import org.example.card.Deck;
import org.example.card.Rank;
import org.example.card.Suit;
import org.example.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DealerTest {
    Dealer dealer;
    @Mock
    Player player;
    @Mock
    Deck deck;
    Card card = new Card(Suit.CLUBS, Rank.ACE);

    @BeforeEach
    void setup() {
        deck = mock(Deck.class);
        player = mock(Player.class);
        dealer = new Dealer(deck);

        when(deck.removeCard()).thenReturn(card);

    }

    @Test
    void dealerDealTest() {
        int numberOfCards = 5;
        dealer.deal(player,numberOfCards);
        verify(deck,Mockito.times(numberOfCards)).removeCard();
        verify(player,Mockito.times(numberOfCards)).takesCard(card);

    }





}
