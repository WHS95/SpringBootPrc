package com.mini.SpringBootPrc.security;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringSecurityConfigurationTest {

    @Test
    void passwordEncoder() {


        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // Password entered by the user
        String userInputPassword = "1111";

        // Hashed password retrieved from the database (you would fetch this from your user store)
        String storedHashedPassword1 = "$2a$10$/Est1FDUlzYZsUfg8KdYYeAbXYpOvsyXNSpfbKoMOCkpZyvU7bskO";
        String storedHashedPassword2 = "$2a$10$65tVA2eaTX04JOXagwrBZeThDJ8NUwE/TxwPl3p8QSCyUipQtKOsa";

        // Verify the user's password by comparing it to the stored hashed password
        boolean passwordMatches1 = passwordEncoder.matches(userInputPassword, storedHashedPassword1);
        boolean passwordMatches2 = passwordEncoder.matches(userInputPassword, storedHashedPassword2);

        if (passwordMatches1) {
            System.out.println("Password is correct.");
        } else {
            System.out.println("Password is incorrect.");
        }

        if (passwordMatches2) {
            System.out.println("Password is correct.");
        } else {
            System.out.println("Password is incorrect.");
        }
    }
}