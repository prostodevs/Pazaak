package com.pazaak.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckFactory {

    public static Deck createDeck(String type) {

        List<Card> cards = new ArrayList<>();

        switch (type) {
            case "main":
                for (int i = 0; i < 4; i++) { // creates 4 sets of the ten objects
                    for (CardValue cardValue : CardValue.getMainDeckCards()) { // add ten card objects
                        cards.add(new Card(cardValue));
                    }
                }
                break;
            case "side":
                for (int i = 0; i < 2; i++) {
                    for (CardValue cardValue : CardValue.getSideDeckCards()) { // add six card objects
                        cards.add(new Card(cardValue));
                    }
                }
                break;
        }
        Collections.shuffle(cards);
        return new Deck(cards);
    }

}