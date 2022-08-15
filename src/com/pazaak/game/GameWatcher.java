package com.pazaak.game;

class GameWatcher {

    // static fields that will be shared with other classes within the com.pazaak.game package
    public static int playerSetWinCount;
    public static int dealerSetWinCount;
    public static int playerCardValue;
    public static int dealerCardValue;
    public static int turnCount;


    // constructors
    public GameWatcher() {
        super();
    }

    // getters/setters
    public static int getPlayerCardValue() {
        return playerCardValue;
    }

    public static int getDealerCardValue() {
        return dealerCardValue;
    }

    public static int getTurnCount() {
        return turnCount;
    }

    public static void setTurnCount(int turnCount) {
        GameWatcher.turnCount = turnCount;
    }
}