package com.prcproject.learnspringframwork;

import com.prcproject.learnspringframwork.MarioGame.ContrabaseGame;
import com.prcproject.learnspringframwork.MarioGame.MarioGame;
import com.prcproject.learnspringframwork.game.GameRunner;
import org.springframework.boot.SpringApplication;

public class AppGamingBasicJava {

    public static void main(String[] args) {

        var game = new MarioGame();
//        var game = new ContrabaseGame();
        var gameRunner =new GameRunner(game);
        gameRunner.run();
    }
}
//문제
//강력한 결합은 interface를 사용하지 않고 하는것이다.
//즉, 필요한 게임을 만들고 그것을 직접 GameRunner에게 어떤 게임을 할것이며 그 게임의 메소드들을 실행할수있게 역할을 부여하는것이다.

//1) 해결방법 Interface를 이용하자
//게임마다 사용되는 메소드 = 역할 이 같다면 이를 인터페이스를 연결시키고 게임을 인터페이스에 연결하고 실행자에게는 인터페이스를 부여하자

//2)