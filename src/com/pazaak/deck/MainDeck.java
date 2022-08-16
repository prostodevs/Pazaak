package com.pazaak.deck;


import java.util.ArrayList;
import java.util.List;

public class MainDeck extends Card {

    //Fields
    public static List<Card> cards;


    private int deckSize; //size of deck

    //Constructor

    public MainDeck(CardValues card) {
        super(card);
        this.cards = new ArrayList<Card>();
    }

    //Methods


    public static List<Card> getCards() {
        return cards;
    }

    public void getCardValues() {
    }

//    public int cards() {
//        int card = 0;
//        card += cards.getCardValue();
//        return card;
//    }


}
