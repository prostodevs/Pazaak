package com.pazaak.game;

class GameWatcher {

    // static fields that will be shared with other classes within the com.pazaak.game package
    private static int playerSetWinCount;
    private static int dealerSetWinCount;
    private static int playerCardValue;
    private static int dealerCardValue;
    private static int turnCount = 1;


    // constructors
    public GameWatcher() {
        super();
    }

    // getters/setters
    public static int getPlayerCardValue() {
        return playerCardValue;
    }

    public static void setPlayerCardValue(int playerCardValue) {
        GameWatcher.playerCardValue = playerCardValue;
    }

    public static int getDealerCardValue() {
        return dealerCardValue;
    }

    public static void setDealerCardValue(int dealerCardValue) {
        GameWatcher.dealerCardValue = dealerCardValue;
    }

    public static int getPlayerSetWinCount() {
        return playerSetWinCount;
    }

    public static void setPlayerSetWinCount(int playerSetWinCount) {
        GameWatcher.playerSetWinCount = playerSetWinCount;
    }

    public static int getDealerSetWinCount() {
        return dealerSetWinCount;
    }

    public static void setDealerSetWinCount(int dealerSetWinCount) {
        GameWatcher.dealerSetWinCount = dealerSetWinCount;
    }

    public static int getTurnCount() {
        return turnCount;
    }

    public static void setTurnCount(int turnCount) {
        GameWatcher.turnCount = turnCount;
    }
}