package com.pazaak.game;

public class GameWatcher {

    // static fields that will be shared with other classes within the com.pazaak.game package
    private static int playerSetWinCount = 0;
    private static int dealerSetWinCount = 0;
    private static int playerCardValue = 0;
    private static int dealerCardValue = 0;
    private static int turnCount = 0;


    // constructors
    public GameWatcher() {
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