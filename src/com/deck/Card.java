package com.deck;

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

    @Override
    public String toString() {
        return " " + getValue() + " "; // [ 3 ], [ 5 ]
    }
}
