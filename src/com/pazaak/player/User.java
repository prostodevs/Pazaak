package com.pazaak.player;

import com.pazaak.deck.Card;
import com.pazaak.deck.Deck;

import java.util.List;

public class User extends Player {

    //Methods
//TODO: add play() method
    public void play(String... option) {

    }

    //ctor
    public User(List<Card> hand) {
        super(hand);
    }

    @Override
    public void playSideCard() { //play the card they want

    }


}
