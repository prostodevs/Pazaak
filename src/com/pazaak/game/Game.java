package com.pazaak.game;

public class Game {
    private int playerSetWinCount = 0;
    private int dealerSetWinCount = 0;
    boolean play = false;
    boolean rules = false;

//business methods
    public void execute() {

        // display welcome message
        welcome();

        if (play) {
            while (playerSetWinCount != 2 || dealerSetWinCount != 2) {

                if (GameWatcher.getPlayerCardValue < 20){
                    // stay
                    // skipTurn
                    // playSideCard
                }else if(GameWatcher.getPlayerCardValue > 20){
                    GameWatcher.dealerSetWinCount = GameWatcher.dealerSetWinCount + 1;
                }

                if(GameWatcher.getDealerCardValue < 20){ // AI will have set rules with Math.rand to force chance
                    // stay
                    // skipTurn
                    // playSideCard
                }else if (GameWatcher.getDealerCardValue > 20){
                    GameWatcher.playerSetWinCount = GameWatcher.playerSetWinCount + 1;
                }
                GameWatcher.increaseTurnCounter();
            }

        }

        if (rules){
            displayRules();
        }


    }



    private void displayRules() {
        System.out.println("Dem's the rules");
    }



    private void welcome() {
        System.out.println("Welcome to Pazaak!!\nWhat would you like to do?" +
                "\nPlay" +
                "\nRead the Rules");
    }
}