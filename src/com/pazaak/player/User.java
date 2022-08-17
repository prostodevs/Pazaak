package com.pazaak.player;

import com.pazaak.deck.Card;

import java.util.Scanner;

import java.util.List;

public class User extends Player {

    //Methods
    public void play(String... option) {
        Scanner scanner = new Scanner(System.in);
        drawCard();
        System.out.println("Your current card total is: " + getCardValue());
        System.out.println("Your hand card options are: " + getHand());

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
                    stand();
                    validInput = true;
                    break;
                case "2":
                    validInput = true;
                    break;
                case "3":
                    playSideCard();
                    validInput = true;
                    break;
                default:
                    System.out.println(input + " is an invalid choice.");
            }
        }
    }

    //ctor
    public User(List<Card> hand) {
        super(hand);
    }

    @Override
    public void playSideCard() { //play the card they want

    }


}
