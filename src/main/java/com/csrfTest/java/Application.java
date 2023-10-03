package com.csrfTest.java;


import com.csrfTest.java.domain.member.Member;
import com.csrfTest.java.domain.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {


    @Autowired
    private MemberService memberService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        memberService.registerMember(Member.builder()
                .id("whs")
                .memberName("alex")
                .password("123")
                .build());
    }
}