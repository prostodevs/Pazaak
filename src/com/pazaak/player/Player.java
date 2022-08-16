package com.pazaak.player;

import com.pazaak.game.Game;

import javax.swing.*;

public class Player {

    Game game;
    boolean reset = false;

    //Methods
    public void playCard() {
        //TODO: play a card
    }

    public int drawCard(int index) {
        int cardValue = 0;

        //TODO: draw card from Deck
        return cardValue;
    }

    public void skipTurn() {
        // TODO: no action, skip turn - keep playing
    }

    public void playSideCard() {
        //TODO: play card from side deck

    }

    public boolean stand(boolean a) {
        //TODO: commit to current cardValue count. no more plays
        return a;
    }

    public void resetGame() {
//        if (reset) {
//            this.remove(game);
//            game = new Game();
//            this.add(game);
//            SwingUtilities.updateComponentTreeUI(this);  <-- will generate new game panel, need to implement in Game class
    }
}

//input getReset method() to reset game

//Accessors

