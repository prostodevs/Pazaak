package com.pazaak.player;

import com.pazaak.game.Game;

public class Player {

    private Game game = new Game();


    //Methods
    public void playCard() {
        //TODO: play a card
    }

    public void drawCard() {
        //TODO: draw card from Deck

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

    public void reset() {

    }

    //input getReset method() to reset game

    //Accessors

}
