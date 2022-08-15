package com.pazaak.game;

public class Game {
    boolean play = false;
    boolean rules = false;

    //business methods
    public void execute() {

        // display welcome message
        welcome();

        if (play) {
            while (GameWatcher.getPlayerSetWinCount() != 2 || GameWatcher.getDealerSetWinCount() != 2) {

                if (GameWatcher.getPlayerCardValue() < 20) {
                    // stay
                    // skipTurn
                    // playSideCard
                } else if (GameWatcher.getPlayerCardValue() > 20 && GameWatcher.getDealerCardValue() > 20) {
                    // DO NOTHING, TIED SET
                } else if (GameWatcher.getPlayerCardValue() > 20) {
                    GameWatcher.setDealerSetWinCount(+1);
                }

                if (GameWatcher.getDealerCardValue() < 20) { // AI will have set rules with Math.rand to force chance
                    // stay
                    // skipTurn
                    // playSideCard
                } else if (GameWatcher.getPlayerCardValue() > 20 && GameWatcher.getDealerCardValue() > 20) {
                    // DO NOTHING, TIED SET
                } else if (GameWatcher.getDealerCardValue() > 20) {
                    // add win to player win count
                    GameWatcher.setPlayerSetWinCount(+1);
                }
                GameWatcher.setTurnCount(+1);
            }

        }

        if (rules) {
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