package com.pazaak.player;

import com.pazaak.game.Game;

import javax.swing.*;

public class Player {

    Game game;
    boolean reset = false;

    //Methods
    public int drawCard(int index) {
        int cardValue = 0;

        //TODO: draw card from Deck
        return cardValue;
    }


    public void playSideCard() {
        //TODO: play card from side deck

    }

    public boolean stand(boolean a) {
        //TODO: commit to current cardValue count. no more plays
        return a;
    }
}