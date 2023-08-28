package com.prcproject.learnspringframwork.game;

public class GameRunner {
    GamingConsole game;
    public GameRunner(GamingConsole game) {
        this.game = game;
    }
    public void run(){
        System.out.println("Running game:"+ game);
        game.down();
        game.up();
        game.right();
        game.left();
    }
}
