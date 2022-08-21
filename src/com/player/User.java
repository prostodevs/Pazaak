package com.player;

import com.deck.Card;

import java.util.List;
import java.util.Scanner;

public class User extends Player {


    //ctor
    public User(List<Card> hand) {
        super(hand);
    }

    //Methods
    public void play() {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Your current card total is: %s%n", this.getCardTotal()); //display current card total
        System.out.printf("Available hand cards are: %s%n", this.getHand().toString()); //toString automatically called!

        boolean validInput = false;
        while (!validInput) {
            System.out.println("What would you like to do?\n" +
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
                    System.out.println(input + " is an invalid choice, please try again.");
            }
        }
    }

    @Override
    public void playSideCard() { //play the card they want
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        System.out.println("What card would you like to play?\n" +
                "Enter the card number by position (example: [1, 2, 3, 4]):\n");
        System.out.println(getHand());

        while (!validInput) {
            String input = scanner.nextLine().trim();
            try {
                switch (input) {
                    case "1":
                        this.setCardTotal(getCardTotal() + getHand().get(0).getValue());
                        this.getHand().remove(0);
                        validInput = true;
                        break;
                    case "2":
                        this.setCardTotal(getCardTotal() + getHand().get(1).getValue());
                        this.getHand().remove(1);
                        validInput = true;
                        break;
                    case "3":
                        this.setCardTotal(getCardTotal() + getHand().get(2).getValue());
                        this.getHand().remove(2);
                        validInput = true;
                        break;
                    case "4":
                        this.setCardTotal(getCardTotal() + getHand().get(3).getValue());
                        this.getHand().remove(3);
                        validInput = true;
                        break;
                    default:
                        System.out.println(input + " is an invalid choice, please try again.");
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid choice, please try again.");
            }
        }


        validInput = false;
        while (!validInput) {
            System.out.print("New card total is: " + getCardTotal() +
                    "\nWhat would you like to do?\n" +
                    "1. Stand\n" +
                    "2. Skip Turn\n" +
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
                default:
                    System.out.println(input + " is an invalid choice, please try again.");
            }
        }

    }


}
