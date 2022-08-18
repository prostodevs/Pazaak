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
    public void play(String... option) {
        Scanner scanner = new Scanner(System.in);

        if (isBusted()) {
            stand();
        } else if (getCardValue() <= 13) {
            System.out.println("(1)Computer total is: " + getCardValue() + "\n");
        } else if (getCardValue() > 13 && getCardValue() <= 18) {
            playSideCard();
            System.out.println("(2)Computer total is: " + getCardValue() + "\n");
        } else if (getCardValue() > 18) {
            stand();
            System.out.println("(3)Computer total is: " + getCardValue() + "\n");
        }
    }

    @Override
    public void playSideCard() {

    }
}
