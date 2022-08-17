package com.pazaak.game;

public class GameWatcher {
    // TODO: change to non-all static class (remove static everywhere)
    // static fields that will be shared with other classes within the com.pazaak.game package
    private int playerSetWinCount = 0;
    private int aiSetWinCount = 0;
    private int playerCardValue = 0;
    private int aiCardValue = 0;
    private int turnCount = 0;
    private int playerCardCount = 0;
    private int aiCardCount = 0;


    // constructors
    public GameWatcher() {
    }

    // getters/setters
    public int getPlayerCardValue() {
        return playerCardValue;
    }

    public void setPlayerCardValue(int playerCardValue) {
        this.playerCardValue = playerCardValue;
    }

    public int getAiCardValue() {
        return aiCardValue;
    }

    public void setAiCardValue(int aiCardValue) {
        this.aiCardValue = aiCardValue;
    }

    public int getPlayerSetWinCount() {
        return playerSetWinCount;
    }

    public void setPlayerSetWinCount(int playerSetWinCount) {
        this.playerSetWinCount = playerSetWinCount;
    }

    public int getAiSetWinCount() {
        return aiSetWinCount;
    }

    public void setAiSetWinCount(int aiSetWinCount) {
        this.aiSetWinCount = aiSetWinCount;
    }

    public int getTurnCount() {
        return turnCount;
    }

    public void setTurnCount(int turnCount) {
        this.turnCount = turnCount;
    }

    public int getPlayerCardCount() {
        return playerCardCount;
    }

    public void setPlayerCardCount(int playerCardCount) {
        this.playerCardCount = playerCardCount;
    }

    public int getAiCardCount() {
        return aiCardCount;
    }

    public void setAiCardCount(int aiCardCount) {
        this.aiCardCount = aiCardCount;
    }

    public void setReset() {
        setTurnCount(0);
        setPlayerCardValue(0);
        setPlayerCardCount(0);
        setAiCardValue(0);
        setAiCardCount(0);
    }
}