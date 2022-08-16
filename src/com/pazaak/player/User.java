package com.pazaak.player;

import com.pazaak.deck.CardValues;
import com.pazaak.deck.MainDeck;

public class User extends Player {

    private CardValues sideDeck;


    //Methods
    @Override
    public int drawCard(int index) {
        int cardValue = MainDeck.getCards().indexOf(index);

        return cardValue;
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
