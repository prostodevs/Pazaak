package com.pazaak.player;


public class MainDeck {

    //Fields
    private final CardValues cardValues;
    private int deckSize; //size of deck

    //Constructor
    public MainDeck(CardValues cardValues) {
        this.cardValues = cardValues;
    }

    //Methods

    public int getCardValues() {
        return cardValues.getCardValue();
    }

    public int cards() {
        int card = 0;
        card += cardValues.getCardValue();
        return card;
    }


}
