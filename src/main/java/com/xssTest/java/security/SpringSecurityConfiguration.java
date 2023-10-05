package com.xssTest.java.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionFixationProtectionStrategy;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {
    //LDAP or Database
    //In Memory

    //InMemoryUserDetailsManager
    //InMemoryUserDetailsManager(UserDetails... users)

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {

        UserDetails userDetails1 = createNewUser("whs", "1111");
        UserDetails userDetails2 = createNewUser("alex", "2222");

        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    private UserDetails createNewUser(String username, String password) {
        Function<String, String> passwordEncoder
                = input -> passwordEncoder().encode(input);

        UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoder)
                .username(username)
                .password(password)
                .roles("USER","ADMIN")
                .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



//    Spring Security 사용하여 애플리케이션의 인증 및 권한 부여, 기본적인 보안 설정을 정의
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //로그인한 사용자만이 애플리케이션의 모든 URL에 접근
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );
        //Spring Security의 기본 로그인 페이지를 사용
        http.formLogin(withDefaults());
        //CSRF(Cross-Site Request Forgery) 공격을 방지하는 Spring Security의 기본 기능을 비활성화
//        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        http.csrf().disable();
        //X-Frame-Options 헤더를 비활성화하는 부분
        http.headers().frameOptions().disable();
        //Cookie httpOnly 속성으로 설정
        http.sessionManagement()
                .sessionAuthenticationStrategy(sessionAuthenticationStrategy());
        //CSP(Content Security Policy)
//        http.headers()
//                .xssProtection()
//                .and()
//                .contentSecurityPolicy("script-src 'self'");
        return http.build();
    }

    @Bean
    public SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new SessionFixationProtectionStrategy();
    }






}