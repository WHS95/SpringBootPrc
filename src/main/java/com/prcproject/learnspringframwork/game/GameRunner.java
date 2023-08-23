package com.prcproject.learnspringframwork.game;

import com.prcproject.learnspringframwork.MarioGame.MarioGame;

import java.sql.SQLOutput;

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
