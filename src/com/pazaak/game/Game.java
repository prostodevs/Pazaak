package com.pazaak.game;

import com.pazaak.deck.MainDeck;
import com.pazaak.player.Ai;
import com.pazaak.player.Player;
import com.pazaak.player.User;

import java.io.*;
import java.util.Scanner;

public class Game {
    boolean play = false;
    boolean rules = false;
    boolean exit = false;
    private final Scanner scanner = new Scanner(System.in); // console input

    //business methods
    public void execute() {

        do {
            // display welcome message
            welcome();

            // Play flow
            if (play) {
                User player = new User();
                Ai dealer = new Ai();

                // TODO: select SideDeck?

                //this while block will repeat for each set
                while (GameWatcher.getPlayerSetWinCount() != 2 || GameWatcher.getDealerSetWinCount() != 2) {

                    //TODO: MainDeck.randomize();

                    int playerIndex = GameWatcher.getTurnCount();
                    int dealerIndex = GameWatcher.getTurnCount() + 1;

                    while (!player.stand(true)) {
                        if (GameWatcher.getPlayerCardValue() < 20) {
                            player.drawCard(playerIndex); // draws card based on turn
                            GameWatcher.setPlayerCardValue(+player.drawCard(playerIndex));
                            System.out.println("You're current card total is: " + GameWatcher.getPlayerCardValue());

                            boolean validInput = false;
                            while (!validInput) {
                                System.out.println("What you would like to do?\n" +
                                        "1. Stand\n" +
                                        "2. Skip Turn\n" +
                                        "3. Play a Side Card\n" +
                                        "Enter a number: ");
                                String input = scanner.nextLine().trim();
                                switch (input) {
                                    case "1":
                                        player.stand(true);
                                        validInput = true;
                                        break;
                                    case "2":
                                        validInput = true;
                                        break;
                                    case "3":
                                        player.playSideCard();
                                        validInput = true;
                                        break;
                                    default:
                                        System.out.println(input + " is an invalid choice.");
                                }
                            }
                        } else if (GameWatcher.getPlayerCardValue() > 20) {

                            dealer.stand(true);
                        }
                    }

                    while (!dealer.stand(false)) {
                        if (GameWatcher.getDealerCardValue() > 20) { // AI will have set rules with Math.rand to force chance
                            dealer.drawCard(dealerIndex); // draws card based on turn
                            int input = dealer.getChoice();
                            switch (input) {
                                case 1:
                                    dealer.stand(true);
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    dealer.playSideCard();
                                    break;
                            }

                        } else {
                            dealer.stand(true);
                        }

                        //End of turn counter actions
                        GameWatcher.setTurnCount(+1);
                        playerIndex += 1;
                        dealerIndex += 1;
                        GameWatcher.setReset(); //reset board at end of each set
                    }
                }
                if (GameWatcher.getPlayerSetWinCount() == 2) {
                    System.out.println("You won the match!");
                } else {
                    System.out.println("You have lost the match.");
                }
            }

            // Rule display
            if (rules) {
                displayRules();
            }

            resetWelcome();
        } while (!exit);

    }


    private void displayRules() {
        try (BufferedReader br = new BufferedReader(new FileReader("data/Rules.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            System.out.println(everything);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(); // add buffer space to cmd output
    }

    private void welcome() {
        System.out.println("Welcome to Pazaak!!\nWhat would you like to do?" +
                "\n1. Play" +
                "\n2. Read the Rules" +
                "\n3. Exit");

        boolean validInput = false;
        while (!validInput) {
            System.out.print("Please enter a number: ");
            String input = scanner.nextLine().trim().toUpperCase();

            switch (input) {
                case "1":
                    play = true;
                    validInput = true;
                    break;
                case "2":
                    rules = true;
                    validInput = true;
                    break;
                case "3":
                    exit = true;
                    validInput = true;
                    break;
                default:
                    System.out.println(input + " is not a valid choice.");
            }
        }
    }

    private void resetWelcome() {
        play = false;
        rules = false;
    }

}