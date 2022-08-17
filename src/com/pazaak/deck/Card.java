package com.pazaak.deck;

public class Card {

    //fields
    private CardValue cardValue;


    //ctor
    public Card(CardValue cardValue) {
        this.cardValue = cardValue;
    }

    public int getValue() {
        return cardValue.value();
    }
}
