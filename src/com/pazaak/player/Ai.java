package com.pazaak.player;

import com.pazaak.deck.Card;
import com.pazaak.deck.CardValue;
import com.pazaak.deck.Deck;

import java.util.ArrayList;
import java.util.List;


public class Ai extends Player {


    // Fields
    private CardValue sideDeck;
    private int choice;
    private boolean playerStand = false;
    private boolean dealerStand = false;


    public Ai(List<Card> hand) {
        super(hand);
    }

    // Methods
    public void play(String... option) {

    }

    public int getChoice() {
        if (getCardValue() <= 13) {
            choice = 2;
            System.out.println("Skip");
        } else if (getCardValue() > 14 && getCardValue() < 20) {
            // for each loop that will iterate through the 4 cards to determine value
            sideCards = new ArrayList<CardValue>();

            for (CardValue sideCard : sideCards) {
                if (sideCards < 20) {
                    playSideCard();
                }

            }




//            int cardValueOnBoard = sum(GameWatcher.getDealerCardValue() + sideDeck.getCardValue());
//            if (cardValueOnBoard <= 0) {
//                choice = ;
//
//            }

        }


        return 0;
    }

        @Override
    public void playSideCard() {

        }
}
