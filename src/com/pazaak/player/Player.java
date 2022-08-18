package com.pazaak.player;


import com.pazaak.deck.Card;
import com.pazaak.deck.Deck;

import java.util.List;

public abstract class Player {
    private boolean isStanding = false;
    private int cardTotal;
    private int cardCount;
    private int winCount;
    private Deck mainDeck;
    private List<Card> hand;

    //ctor
    public Player(List<Card> hand) {
        this.hand = hand;
    }

    public List<Card> getHand() {
        return this.hand;
    }

    public abstract void play();

    public int getCardCount() {
        return cardCount;
    }

    public boolean isBusted() {
        return getCardTotal() > 20;
    }

    public void win() {
        winCount++;
    }

    public int getWinCount() {
        return winCount;
    }

    public int getCardTotal() {
        return cardTotal;
    }

    public void setCardTotal(int cardTotal) {
        this.cardTotal = cardTotal;
    }

    public void drawCard() {
        this.cardTotal += mainDeck.draw().getValue();
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

    public void reset() {
        cardTotal = 0;
        cardCount = 0;
        isStanding = false;
    }
}