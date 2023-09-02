package com.prcproject.learnspringframwork.examples.g1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;



@Configuration
public class ComponentStreoContextLauncherApplication {

    public static void main(String[] args) {

        var ac = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig appConfig = ac.getBean(AppConfig.class);

        System.out.println(appConfig);
    }
}


