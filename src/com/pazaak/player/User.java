package com.pazaak.player;

import com.pazaak.deck.CardValues;

public class User extends Player {

    private CardValues sideDeck;


    //Methods
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

    @Override
    public boolean stand(boolean stand) {
        return stand;
    }
}
