package com.pazaak.player;

public enum SideDeck {


    NEGATIVE_1(-1),
    NEGATIVE_2(-2),
    NEGATIVE_3(-3),
    NEGATIVE_4(-4),
    NEGATIVE_5(-5),
    NEGATIVE_6(-6),

    POSITIVE_1(1),
    POSITIVE_2(2),
    POSITIVE_3(3),
    POSITIVE_4(4),
    POSITIVE_5(5),
    POSITIVE_6(6);

    private int sideDeck;

    private SideDeck(int value) {
        this.sideDeck = value;
    }

    public int getSideDeck() {
        return sideDeck;
    }


}
