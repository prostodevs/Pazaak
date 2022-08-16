package com.pazaak.player;

import com.pazaak.deck.CardValues;

import com.pazaak.deck.MainDeck;
import com.pazaak.game.GameWatcher;


public class Ai extends Player {


    // Fields
    private CardValues sideDeck;
    private int choice;
    private boolean playerStand = false;
    private boolean dealerStand = false;


    // Methods
    public int getChoice() {
        if (GameWatcher.getDealerCardValue() <= 13) {
            choice = 2;
            System.out.println("Skip");
        } else if (GameWatcher.getDealerCardValue() <= 14 && GameWatcher.getDealerCardValue() < 18) {
            if (0 == 0) {
                choice = 0;

            }

        }


        return choice;
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
