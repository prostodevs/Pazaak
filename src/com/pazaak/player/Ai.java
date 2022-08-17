package com.pazaak.player;

import com.pazaak.deck.Card;

import java.util.List;
import java.util.Scanner;


public class Ai<CardValues> extends Player {

    // Constructor
    public Ai(List<Card> hand) {
        super(hand);
    }


    // Methods
    public void play(String... option) {
        Scanner scanner = new Scanner(System.in);
        drawCard();

        if (isBusted()) {
            stand();
        } else if (getCardValue() <= 13) {
            System.out.println();
        } else if (getCardValue() > 13 && getCardValue() <= 19) {
            playSideCard();
        }
    }

    @Override
    public void playSideCard() {

    }
}
