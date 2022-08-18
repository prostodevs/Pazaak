package com.pazaak.player;

import com.pazaak.deck.Card;

import java.util.List;
import java.util.Scanner;


public class Ai extends Player {

    // Constructor
    public Ai(List<Card> hand) {
        super(hand);
    }


    // Methods
    public void play() {
        Scanner scanner = new Scanner(System.in);

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
