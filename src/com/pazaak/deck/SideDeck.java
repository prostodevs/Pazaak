package com.pazaak.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SideDeck {

    // Fields
//    private final CardValues[] sideDeckValues = {CardValues.NEGATIVE_6, CardValues.NEGATIVE_5,
//            CardValues.NEGATIVE_4, CardValues.NEGATIVE_3, CardValues.NEGATIVE_2,
//            CardValues.NEGATIVE_1, CardValues.POSITIVE_1, CardValues.POSITIVE_2,
//            CardValues.POSITIVE_3, CardValues.POSITIVE_4, CardValues.POSITIVE_5,
//            CardValues.POSITIVE_6};

    List<CardValues> sideCards;

    // Constructor
    public SideDeck() {
        sideCards = new ArrayList<CardValues>();
    }

    public boolean keepSideDeck(CardValues[] sideCards) {
        List<CardValues> oldCards = this.sideCards;
        this.sideCards.clear();
        for (CardValues card : sideCards) {
            if (true) {
                this.sideCards.add(card);
            } else {
                this.sideCards = oldCards;
                return false;
            }
        }
        if (this.sideCards.size() == 30) {
            return true;
        }
        this.sideCards = oldCards;
        return false;
    }

    public List<CardValues> getSideDeck() {
        return Collections.unmodifiableList(this.sideCards);
    }
}
