package com.pazaak.game;

import com.pazaak.deck.Card;
import com.pazaak.deck.Deck;
import com.pazaak.deck.DeckFactory;
import com.pazaak.player.Ai;
import com.pazaak.player.Player;
import com.pazaak.player.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private boolean play = false;
    private boolean rules = false;
    private boolean exit = false;
    private final Scanner scanner = new Scanner(System.in); // console input

    // Primary Game method
    public void execute() {
        System.out.println("WELCOME TO PAZAAK" +
                "\n=========================================");
        do {
            // display welcome message
            mainMenu();

            // Game flow controller
            if (play) {
                System.out.println(); //play loop buffer
                Player player = new User(generateHand());
                Player computer = new Ai(generateHand());

                while (player.getWinCount() != 2 && computer.getWinCount() != 2) { //MATCH LOOP
                    boolean roundOver = false;

                    System.out.println("New set!!!" +
                            "\n----------------------------------");
                    while (!roundOver) { // ROUND LOOP
                        Deck mainDeck = DeckFactory.createDeck("main");
                        player.setDeck(mainDeck);
                        computer.setDeck(mainDeck);

                        //Player turn

                        if (player.getCardTotal() == 20) {
                            player.stand();
                        } else if (!player.isStanding() && player.getCardCount() < 9) {
                            player.drawCard();
                            // TODO: add prompt code here - feed to String... option below
                            player.play();
                        }

                        // Computer turn
                        if (player.isBusted()) {
                            computer.stand();
                        } else if (player.isStanding() && computer.getCardTotal() > player.getCardTotal()) {
                            computer.stand();
                        } else if (!computer.isStanding() && computer.getCardCount() < 9) {
                            computer.drawCard();
                            computer.play();
                        }

                        System.out.printf("End of turn totals are:\nPlayer: %s, Computer: %s\n",
                                player.getCardTotal(), computer.getCardTotal());
                        System.out.println();

                        // Evaluate if round is over
                        if (player.isBusted()) {
                            roundOver = true;
                        } else if (computer.isBusted()) {
                            roundOver = true;
                        } else if (player.isStanding() && computer.isStanding()) {
                            roundOver = true;
                        }
                    }
                    Player winner = determineWinner(player, computer);
                    winner.win();
                    String setMessage = (winner == player) ? "You won the round!" : "You lost the round.";
                    System.out.printf("Current round scores are:\nPlayer: %s, Computer %s%n",
                            player.getWinCount(), computer.getWinCount());
                    System.out.println("----------------------------------");
                    player.reset();
                    computer.reset();
                }
                if (player.getWinCount() == 2) {
                    System.out.println("Pazaaka! You just won the match!!!!");
                } else {
                    System.out.println("Sorry Pazaaka, you might need to read the rules again....");
                }
                continuePlaying(); //ask to play again
            }

            // Rule display
            if (rules) {
                System.out.println(); //selection buffer row
                displayRules();
            }

            resetWelcome();
        } while (!exit);
        System.out.println("\nThe game will now exit.");
    }

    // Game Methods
    private void displayRules() {
        try {
            List<String> lines = Files.readAllLines(Path.of("data/Rules.txt"));
            for (String line : lines) {
                System.out.println(line);
            }
            System.out.println(); // add buffer row
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mainMenu() {
        System.out.println("What would you like to do?" +
                "\n1. Play" +
                "\n2. Read the Rules" +
                "\n3. Exit");

        boolean validInput = false;
        while (!validInput) {
            System.out.print("Please enter a number: ");
            String input = scanner.nextLine().trim();

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

    private List<Card> generateHand() {
        Deck sideDeck = DeckFactory.createDeck("side");
        List<Card> hand = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            hand.add(sideDeck.draw());
        }
        return hand;
    }

    private Player determineWinner(Player p1, Player p2) {
        Player winner = null;
        if (p1.isBusted() && !p2.isBusted()) {
            winner = p2;
        } else if (p2.isBusted() && !p1.isBusted()) {
            winner = p1;
        } else if (p1.getCardTotal() == 20 && p2.isBusted()) {
            winner = p1;
        } else if (!p1.isBusted() && !p2.isBusted() && p1.getCardTotal() > p2.getCardTotal()) {
            winner = p1;
        } else {
            winner = p2;
        }
        return winner;
    }

    private void continuePlaying() {
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Do you want to play again? Y or N\n");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.matches("Y|N")) {  //
                if ("N".equals(input)) {
                    System.out.println("Thanks for playing!!");
                } else {
                    System.out.println();
                }
                validInput = true;
            }
        }
    }
}
