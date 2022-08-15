package com.pazaak.player;

import java.util.ArrayList;

public class SideDeck {

    // Fields
    private final CardValues[] sideDeckValues = {CardValues.NEGATIVE_6, CardValues.NEGATIVE_5,
            CardValues.NEGATIVE_4, CardValues.NEGATIVE_3, CardValues.NEGATIVE_2,
            CardValues.NEGATIVE_1, CardValues.POSITIVE_1, CardValues.POSITIVE_2,
            CardValues.POSITIVE_3, CardValues.POSITIVE_4, CardValues.POSITIVE_5,
            CardValues.POSITIVE_6};

    private int deckSize; //size of deck

    private boolean isNegative;

    public SideDeck(CardValues cardValues) {

    }
}
