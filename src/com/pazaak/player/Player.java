package com.pazaak.player;


import com.pazaak.deck.Card;
import com.pazaak.deck.Deck;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    private boolean isStanding = false;
    private int cardValue;
    private int cardCount;
    private int winCount;
    private Deck mainDeck;
    private List<Card> hand;

    //ctor
    public Player(List<Card> hand) {
        this.hand = hand;
    }

    public abstract void play(String... option);

    public void win() {
        winCount++;
    }

    public void reset() {
        cardValue = 0;
        cardCount = 0;
    }

    public boolean isBusted() {
        return getCardValue() > 20;
    }

    public int getWinCount() {
        return winCount;
    }

    public int getCardValue() {
        return cardValue;
    }

    //Methods
    public void drawCard(int index) {
        this.cardValue += mainDeck.draw().getValue();
        cardCount++;
    }

    public abstract void playSideCard(); //delegate to Ai/User

    public void stand() {
        isStanding = true;
    }

    public boolean isStanding() {
        return isStanding;
    }

    public void setDeck(Deck mainDeck) {
        this.mainDeck = mainDeck;
    }
}