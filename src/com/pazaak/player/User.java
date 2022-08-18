package com.pazaak.player;

import com.pazaak.deck.Card;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class User extends Player {


    //ctor
    public User(List<Card> hand) {
        super(hand);
    }

    //Methods
    public void play(String... option) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Your current card total is: %s%n", this.getCardValue()); //display current card total
        System.out.printf("Available hand cards are: %s%n", option);
        try {
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
                        this.stand();
                        validInput = true;
                        break;
                    case "2":
                        validInput = true;
                        break;
                    case "3":
                        this.playSideCard();
                        validInput = true;
                        break;
                    default:
                        System.out.println(input + " is an invalid choice.");
                }
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void playSideCard() { //play the card they want
        Scanner scanner = new Scanner(System.in);

        boolean validInput = false;
        while (!validInput) {
            System.out.println("What card do you want to play?\n" +
                    "Enter the card number by position (example: 1, 2, 3, 4):\n");
            System.out.println(getHand());
            String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    this.setCardValue(getHand().indexOf(0));
                    this.getHand().remove(0);
                    validInput = true;
                    break;
                case "2":
                    this.setCardValue(getHand().indexOf(1));
                    this.getHand().remove(1);
                    validInput = true;
                    break;
                case "3":
                    this.setCardValue(getHand().indexOf(2));
                    this.getHand().remove(2);
                    validInput = true;
                    break;
                case "4":
                    this.setCardValue(getHand().indexOf(3));
                    this.getHand().remove(3);
                    validInput = true;
                    break;
                default:
                    System.out.println(input + " is an invalid choice.");
            }
        }
    }


}
