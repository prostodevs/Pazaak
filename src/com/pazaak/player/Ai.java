package com.pazaak.player;

import com.pazaak.game.GameWatcher;

public class Ai extends Player {


    // Fields
    private CardValues sideDeck;
    private String choice;
    private boolean playerStand = false;
    private boolean dealerStand = false;


    // Methods
    public int getChoice() {
        if (GameWatcher.getDealerCardValue() <= 13) {
            choice = "2";
            System.out.println("Skip");
        } else if (GameWatcher.getDealerCardValue() <= 14 && GameWatcher.getDealerCardValue() < 18) {
            if () {


            }

        }




        return choice;
    }

    @Override
    public void playCard() {
        super.playCard();
    }

    @Override
    public void drawCard() {
        super.drawCard();
    }

    @Override
    public void skipTurn() {
        super.skipTurn();
    }

    @Override
    public void playSideCard() {
        super.playSideCard();
    }


    // set stand method to false
    @Override
    public void stand() {
        super.stand();
    }
}
