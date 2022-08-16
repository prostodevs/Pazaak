package com.pazaak.game;

import com.pazaak.player.Ai;
import com.pazaak.player.Player;
import com.pazaak.player.User;

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
            User player = new User();
            Ai dealer = new Ai();
            // TODO: Randomize (via method) MainDeck BEFORE gameplay??

            // TODO: select SideDeck

            while (GameWatcher.getPlayerSetWinCount() != 2 || GameWatcher.getDealerSetWinCount() != 2) {
                int playerIndex = GameWatcher.getTurnCount(); //TODO: move this to player class?
                int dealerIndex = GameWatcher.getTurnCount() + 1; //TODO: move this to AI class?
                boolean playerStand = false; //TODO: move this to Player class
                boolean dealerStand = false; //TODO: move this to AI class

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
                                //User.stand();
                            case "2":
                                break;
                            case "3":
                                System.out.println(sideDeck);
                                //todo: will this call from the same pool? how to id the specific user/AI
                                //User.playCard();
                        }

                    } else if (GameWatcher.getPlayerCardValue() > 20 && GameWatcher.getDealerCardValue() > 20) {
                        // DO NOTHING, TIED SET
                    } else if (GameWatcher.getPlayerCardValue() > 20) {
                        GameWatcher.setDealerSetWinCount(+1);
                    }
                }
                //TODO: we want to outsource this to the AI object
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
                    Player.getReset();
                }
            }
        }

        if (rules) {
            displayRules();
        }
    }


    private void displayRules() {
        System.out.println("\nRules of Play:\n" +
                "\n" +
                "1. Each player draws 4 random cards from their side deck to form their HAND. " +
                "These cards are available to the player for all the sets of the match. " +
                "Each hand card can only be played once per match.\n" +
                "2. The first player draws a card from the main deck and plays it face up to begin their turn.\n" +
                "3. After drawing a card, a player has the option of playing one of the cards from their hand. " +
                "Playing a card from the hand is optional.\n" +
                "4. Only one hand card can be played each turn. " +
                "REMEMBER: A player's 4 card hand must last through all sets of the match.\n" +
                "5. The player now has the option to STAND or to END TURN. " +
                "A player who stands cannot draw again or play any more cards from their hand during the set. " +
                "When one player stands, the opponent can continue to take turns until they either stand or bust.\n" +
                "6. If a player chooses to end turn they will automatically draw another card at the beginning of their next turn." +
                " After one player chooses to stand or end turn, the opponent draws a card to begin their next turn.\n" +
                "7. Players continue to alternate turns until both players choose to stand, or " +
                "until one player ends a turn with a total greater than 20 (a 'bust'). " +
                "REMEMBER: You only lose if you are over 20 at the end of your turn. " +
                "A player can draw a card from the main deck that puts them over 20, " +
                "then play a negative card from the 'hand' that brings the total back under 20.\n" +
                "8. In the case of tie, another set must be played. No new cards from the side decks are drawn.\n" +
                "9. A player can never have more than nine cards in play during one set. " +
                "(This includes cards from the hand as well as cards dealt from the deck.) " +
                "Once you have nine cards in play you automatically stand.\n" +
                "10, A +/- card played from the side deck must be declared as a positive or negative when played. " +
                "Once played it cannot be changed.\n" +
                "11. The first player to win 3 sets wins the match and the wager.\n" +
                "\n");
    }

    private void welcome() {
        System.out.println("Welcome to Pazaak!!\nWhat would you like to do?" +
                "\n1. Play" +
                "\n2. Read the Rules");

        boolean validInput = false;

        while (!validInput) {
            System.out.print("Please enter 1 or 2: ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.matches("1|2")) {  //
                if ("1".equals(input)) {
                    play = true;
                } else {
                    rules = true;
                }
                validInput = true;
            }
        }
    }
}