package com.pazaak.player;

public enum CardValues {

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
    POSITIVE_6(6),
    POSITIVE_7(7),
    POSITIVE_8(8),
    POSITIVE_9(9),
    POSITIVE_10(10);

    //Fields
    private final int cardValue;

    //Constructors
    private CardValues(int value) { //gives value of int to enum
        this.cardValue = value;
    }

    //Methods
    public int getCardValue() {   //makes enum public with value
        return cardValue;
    }
}
