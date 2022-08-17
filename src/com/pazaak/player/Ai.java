package com.pazaak.player;

import com.pazaak.deck.Card;
import com.pazaak.deck.MainDeck;

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
        } else if (getCardValue() <= 0) {
            playSideCard();
        } else (getCardValue() <= 13 || getCardValue() <= 19) {
            playSideCard();
        }
    }


    @Override
    public int drawCard(int index) {
        int cardValue = MainDeck.getCards().indexOf(index);

        return cardValue;
    }

        @Override
    public void playSideCard() {
        super.playSideCard();
    }


    // set stand method to false
    @Override
    public boolean stand(boolean stand) {
        return stand;
    }
}
