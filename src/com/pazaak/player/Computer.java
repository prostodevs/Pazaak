package com.pazaak.player;

import com.pazaak.deck.Card;

import java.util.List;
import java.util.Scanner;


public class Computer extends Player {

    // Constructor
    public Computer(List<Card> hand) {
        super(hand);
    }


    // Methods
    public void play() {
        System.out.println(this.getClass().getSimpleName() + "'s turn");
        if (isBusted()) {
            stand();
        } else if (getCardTotal() <= 13) {
            System.out.println();
        } else if (getCardTotal() > 13 && getCardTotal() <= 18) {
            playSideCard();
            System.out.println();
        } else if (getCardTotal() > 18) {
            stand();
            System.out.println();
        }
    }

    @Override
    public void playSideCard() {

    }
}
