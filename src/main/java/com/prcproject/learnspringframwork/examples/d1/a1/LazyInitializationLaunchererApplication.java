package com.prcproject.learnspringframwork.examples.d1.a1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


import java.util.Arrays;

@Component
class ClassA{

}

@Component
@Lazy
class ClassB{
    private  ClassA classA;

    public ClassB(ClassA classA){
        System.out.println("Some Logic start");
        this.classA = classA;
    }

    public void doSomeThing(){
        System.out.println("do Some thing!!");
    }
}


    @Configuration
    @ComponentScan
    public class LazyInitializationLaunchererApplication {

        public static void main(String[] args) {

            try (var context = new AnnotationConfigApplicationContext(LazyInitializationLaunchererApplication.class)) {

                context.getBean(ClassB.class).doSomeThing();
            }
        }
    }

    //@ComponentScan을 당한 모든 Component(Bean)즉시 intialize가된다.

//@Lazy를 사용하게되면  @ComponentScan 범위내에 있어도 Component(Bean)즉시 intialize가 되지 않는다.
//호출이 되는 시점에 initailize가된다.


//그렇다면 @Lazy는 필요할만한 요소인가?
//일반적인 상황에서 필요하지 않으며 복잡하고 길어, 시작시 intialize에 무리가 될경우 따로 빼서 사용할수도 있긴하다.
//다만, 컴파일할때 initialize를 하지 않다보니 에러가 런타임시 발생하여 서비스 실행에 문제점을 야기 할수있어 권장되진않는다.
