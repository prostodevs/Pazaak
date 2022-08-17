package com.pazaak.game;

import com.pazaak.deck.Card;
import com.pazaak.deck.Deck;
import com.pazaak.deck.DeckFactory;
import com.pazaak.player.Ai;
import com.pazaak.player.Player;
import com.pazaak.player.User;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private boolean play = false;
    private boolean rules = false;
    private boolean exit = false;
    private final Scanner scanner = new Scanner(System.in); // console input
    private GameWatcher watcher = new GameWatcher(); // replace GameWatcher. with 'watcher.'

    // Primary Game method
    public void execute() {
        do {
            // display welcome message
            welcome();

            // Game flow controller
            if (play) {

                Player player = new User(generateHand());
                Player computer = new Ai(generateHand());

                //this while block will repeat for each set
                while (watcher.getPlayerSetWinCount() != 2 || watcher.getAiSetWinCount() != 2) { //MATCH LOOP
                    int playerIndex = watcher.getTurnCount();
                    int dealerIndex = watcher.getTurnCount() + 1;
                    boolean roundOver = false;

                    //TODO: while(!roundOver){player.play() and computer.play()}
                    Deck mainDeck = DeckFactory.createDeck("main");
                    player.setDeck(mainDeck);
                    computer.setDeck(mainDeck);

                    while (!player.isStanding()) { //Player turn
                        if (player.getCardValue() < 20) {
                            player.drawCard(playerIndex);
                            System.out.println("You're current card total is: " + player.getCardValue());

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
                                        player.stand();
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
                        } else if (player.getCardValue() > 20) {
                            computer.stand();
                        }
                    }

                    while (!computer.isStanding()) { //AI turn
                        //TODO: convert to method?
                        computer.drawCard(dealerIndex); // draws card based on turn
                        int input = computer.getChoice();
                        switch (input) {
                            case 1:
                                computer.stand();
                                break;
                            case 2:
                                break;
                            case 3:
                                computer.playSideCard();
                                break;
                        }
                    } else{
                        computer.stand();
                    }
                }


                //End of turn counter actions
                GameWatcher.setTurnCount(+1);
                playerIndex += 1;
                dealerIndex += 1;

                // Block to assign set wins

            }
        }
        if (GameWatcher.getPlayerSetWinCount() == 2) {
            System.out.println("You won the match!");
        } else if (GameWatcher.getAiSetWinCount() == 2) {
            System.out.println("You have lost the match.");
        }

        // Rule display
        if (rules) {
            displayRules();
        }

        resetWelcome();
    } while(!exit);
        System.out.println("The game will now exit. Thanks for playing!");
}

    // Game Methods
    private void displayRules() {
        //TODO: Files.readString(Path.of(data/Rules.txt))
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
        } else if (p2.isBusted()) {
            p1.win();
        } else if (p1.getCardValue() > p2.getCardValue()) {
            p1.win();
        } else {
            p2.win();
        }
        GameWatcher.setReset();
    }
}