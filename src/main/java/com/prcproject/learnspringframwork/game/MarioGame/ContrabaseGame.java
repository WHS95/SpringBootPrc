package com.prcproject.learnspringframwork.game.MarioGame;

import com.prcproject.learnspringframwork.game.GamingConsole;

public class ContrabaseGame implements GamingConsole {

    public void up() {
        System.out.println("Up");
    }

    public void down() {
        System.out.println("Sit down");
    }

    public void left() {
        System.out.println("back");
    }

    public void right() {
        System.out.println("Shoot");
    }
}
