package com.prcproject.learnspringframwork;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


record Person(String name, int age, Address address) {
};

record Address(String firstLine, String city) {
};


@Configuration
public class HelloWorldConfiguration {
    @Bean
    public String name() {
        return "Ranga";
    }

    @Bean
    public int age() {
        return 15;
    }

    @Bean
    public Person person() {
        return new Person("Ravi", 20, new Address("Baker", "Seoul"));
    }

    ;

    @Bean
    public Person person2MethodCall() {
        return new Person(name(), age(), address());
    }

    ;


    @Bean
    public Person person3Parmerters(String name, int age, Address address3) {
        return new Person(name, age, address3);
    }

    ;

    @Bean
    @Primary
    public Person person4Parmerters(String name, int age, Address address32) {
        return new Person(name, age, address32);
    }

    ;

    @Bean
    public Person person5Qualify(String name, int age, @Qualifier("address344") Address address) {
        return new Person(name, age, address);
    }

    ;

    @Bean(name = "address2")
    @Primary
    public Address address() {
        return new Address("primary1", "primary2");
    }


    @Bean
    @Qualifier("address344")
    public Address address3() {
        return new Address("Qualify1", "Qualify2");
    }


    @Bean
    public Address address32() {
        return new Address("Street", "place");
    }
}
