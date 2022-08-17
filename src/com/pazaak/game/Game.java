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
    public void execute() throws IOException {
        do {
            // display welcome message
            welcome();

            // Game flow controller
            if (play) {

                Player player = new User(generateHand());
                Player computer = new Ai(generateHand());

                //this while block will repeat for each set
                while (player.getWinCount() != 2 || computer.getWinCount() != 2) { //MATCH LOOP
                    boolean roundOver = false;

                    while (!roundOver) {
                        Deck mainDeck = DeckFactory.createDeck("main");
                        player.setDeck(mainDeck);
                        computer.setDeck(mainDeck);

                        //Player turn
                        if (!player.isStanding() && !player.isBusted() && player.getCardCount() < 9) {
                            player.play();
                        } else if (player.getCardValue() > 20) {
                            computer.stand();
                        }

                        // AI turn
                        if (!computer.isStanding() && !computer.isBusted() && computer.getCardCount() < 9) {
                            computer.play();
                        } else {
                            computer.stand();
                        }
                    }
                    determineWinner(player, computer);
                    player.reset();
                }
            }

            // Rule display
            if (rules) {
                displayRules();
            }

            resetWelcome();
        } while (!exit);
        System.out.println("The game will now exit. Thanks for playing!");
    }

    // Game Methods
    private void displayRules() throws IOException {
        String rules = Files.readString(Path.of("data/Rules.txt"));
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
        if (p1.isBusted()) {
            p2.win();
            return p2;
        } else if (p2.isBusted()) {
            p1.win();
            return p1;
        } else if (p1.getCardValue() > p2.getCardValue()) {
            p1.win();
            return p1;
        } else {
            p2.win();
            return p2;
        }
    }
}
