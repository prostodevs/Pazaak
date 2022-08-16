package com.pazaak.deck;

public abstract class Card {

    //fields
    public CardValues cards;

    public int handCardMin = 1;
    public int handCardMax = 6;

        //ctor
    public Card(CardValues card) {
        this.cards = card;
    }



}
