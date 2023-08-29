package com.prcproject.learnspringframwork.examples.e1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class NormaltypeClass{

}


@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class ProtypeClass{

}



    @Configuration
    @ComponentScan
    public class BeanScopelauncherapplication {

        public static void main(String[] args) {

            try (var context = new AnnotationConfigApplicationContext(BeanScopelauncherapplication.class)) {

                System.out.println(context.getBean(NormaltypeClass.class));
                System.out.println(context.getBean(NormaltypeClass.class));
                System.out.println(context.getBean(NormaltypeClass.class));
                System.out.println(context.getBean(NormaltypeClass.class));


                System.out.println(context.getBean(ProtypeClass.class));
                System.out.println(context.getBean(ProtypeClass.class));
                System.out.println(context.getBean(ProtypeClass.class));

//                com.prcproject.learnspringframwork.examples.e1.NormaltypeClass@3c947bc5
//                com.prcproject.learnspringframwork.examples.e1.NormaltypeClass@3c947bc5
//                com.prcproject.learnspringframwork.examples.e1.NormaltypeClass@3c947bc5
//                com.prcproject.learnspringframwork.examples.e1.NormaltypeClass@3c947bc5

//                com.prcproject.learnspringframwork.examples.e1.ProtypeClass@609db43b
//                com.prcproject.learnspringframwork.examples.e1.ProtypeClass@55f616cf
//                com.prcproject.learnspringframwork.examples.e1.ProtypeClass@1356d4d4

            }
        }
    }
