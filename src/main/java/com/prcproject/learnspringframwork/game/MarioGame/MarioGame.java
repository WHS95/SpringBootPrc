package com.prcproject.learnspringframwork.game.MarioGame;

import com.prcproject.learnspringframwork.game.GamingConsole;

public class MarioGame implements GamingConsole {

    public void up(){
        System.out.println("Jump");
    }
    public void down(){
        System.out.println("Go in to a hole");
    }
    public void left(){
        System.out.println("Go back");
    }
    public void right(){
        System.out.println("Accerlate");
    }
}
