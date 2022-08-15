package com.pazaak.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    boolean play = false;
    boolean rules = false;
    private List<Integer> sideDeck = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in); // console input

    //business methods
    public void execute() {

        // display welcome message
        welcome();

        if (play) {
            // TODO: MainDeck Randomized (via method) BEFORE gameplay

            // TODO: select SideDeck

            while (GameWatcher.getPlayerSetWinCount() != 2 || GameWatcher.getDealerSetWinCount() != 2) {
                int playerIndex = GameWatcher.getTurnCount();
                int dealerIndex = GameWatcher.getTurnCount() + 1;
                boolean playerStand = false;
                boolean dealerStand = false;

                while (playerStand) {
                    if (GameWatcher.getPlayerCardValue() < 20) {
                        // Drawn card = Math.rand(MainDeck[playerIndex])
                        System.out.println("Please select what you would like to do:\n" +
                                "1. Stand\n" +
                                "2. Skip Turn\n" +
                                "3. Play a Side Card");
                        String input = scanner.nextLine().trim();
                        switch (input) {
                            case "1":
                                break;
                            case "2":
                                break;
                            case "3":
                                System.out.println(sideDeck);
                        }
                        // stand
                        // skipTurn
                        // playSideCard
                    } else if (GameWatcher.getPlayerCardValue() > 20 && GameWatcher.getDealerCardValue() > 20) {
                        // DO NOTHING, TIED SET
                    } else if (GameWatcher.getPlayerCardValue() > 20) {
                        GameWatcher.setDealerSetWinCount(+1);
                    }
                }
                while (dealerStand) {
                    if (GameWatcher.getDealerCardValue() < 20) { // AI will have set rules with Math.rand to force chance
                        // TODO: implement getChoice() for the AI subclass
                    } else if (GameWatcher.getPlayerCardValue() > 20 && GameWatcher.getDealerCardValue() > 20) {
                        // DO NOTHING, TIED SET
                    } else if (GameWatcher.getDealerCardValue() > 20) {
                        // add win to player win count
                        GameWatcher.setPlayerSetWinCount(+1);
                    }

                    GameWatcher.setTurnCount(+1);
                    playerIndex += 1;
                    dealerIndex += 1;
                }
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