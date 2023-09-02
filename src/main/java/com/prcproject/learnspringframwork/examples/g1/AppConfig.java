package com.prcproject.learnspringframwork.examples.g1;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



public class AppConfig {

    @Bean
    public void aaa(){
        System.out.println("AppConfig.calculate11");
    }


    @Bean
    public void bbb(){
        System.out.println("AppConfig.calculator222");
    }


}
