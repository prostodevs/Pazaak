package com.deck;

import java.util.List;

public class Deck {

    //Fields
    private List<Card> cards;

    //Constructor
    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    //Methods
    public Card draw() {
        Card card = cards.get(0);
        cards.remove(0);
        return card;
    }

}
