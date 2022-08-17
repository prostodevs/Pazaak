package com.pazaak.player;

import com.pazaak.deck.Card;
import com.pazaak.deck.CardValues;

import com.pazaak.deck.MainDeck;
import com.pazaak.game.GameWatcher;

import java.util.ArrayList;
import java.util.List;


public class Ai extends Player {


    // Fields
    private CardValues sideDeck;
    private int choice;
    private boolean playerStand = false;
    private boolean dealerStand = false;
    List<CardValues> sideCards;


    //ctor
    public Ai(List<Card> hand) {
        super(hand);
    }

    // Methods
    public void play(String... option) {
        drawCard();

    }

    public int getChoice() {
        if (GameWatcher.getDealerCardValue() <= 13) {
            choice = 2;
            System.out.println("Skip");
        } else if (GameWatcher.getDealerCardValue() > 14 && GameWatcher.getDealerCardValue() < 20) {
            // for each loop that will iterate through the 4 cards to determine value
            sideCards = new ArrayList<CardValues>();

            for (CardValues sideCard : sideCards) {
                if (sideCards + GameWatcher.getDealerCardValue()){
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
