package com.pazaak.player;

import com.pazaak.deck.Card;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.List;

public class Ai extends Player {

    //ctor
    public Ai(List<Card> hand) {
        super(hand);
    }

    // Methods
    public void play(String... option) {
        drawCard();
        System.out.println("COMPUTER TOTAL: " + getCardValue());
        System.out.println("COMPUTER COUNT: " + getCardCount());
        stand();

    }


    @Override
    public void playSideCard() {

    }


}
