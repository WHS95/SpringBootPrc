package com.prcproject.learnspringframwork.examples.f1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

//
//@Component
//class SomeClass {
//    private SomeDependency someDependency;
//
//    //DI
//    public SomeClass(SomeDependency someDependency) {
//        super();
//        this.someDependency = someDependency;
//        System.out.println("All depency Ready");
//    }
//
//    @PostConstruct
//    public void init() {
//        System.out.println("Bean initialized");
//    }
//    @PreDestroy
//    public void cleanUp() {
//        System.out.println("Bean cleanup");
//    }
//
//    public void doSomething() {
//        System.out.println("Bean is doing something");
//    }
//
//}

@Component
class MyBean implements InitializingBean, DisposableBean {
    private SomeDependency someDependency;

    //DI
    public MyBean(SomeDependency someDependency) {
        super();
        this.someDependency = someDependency;
        System.out.println("All depency Ready");
    }
    @Override
    public void afterPropertiesSet() {
        System.out.println(">>>>>> Bean initialized  use InitializingBean");
    }

    @Override
    public void destroy() {
        System.out.println(">>>>>> Bean cleanup use DisposableBean");
    }

    public void doSomething() {
        System.out.println("Bean is doing something");
    }
}

@Component
class SomeDependency {

    public void init() {
        System.out.println("init!!!");
    }
}


@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class)) {

            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}



//1) DI

//2) Bean initialize

//3) Bean destoryed

