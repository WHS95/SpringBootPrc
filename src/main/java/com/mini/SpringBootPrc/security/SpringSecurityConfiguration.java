package com.mini.SpringBootPrc.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;

import java.util.function.Function;

@Configuration

public class SpringSecurityConfiguration {

    // 사용자 상세 정보를 메모리에서 관리하기 위한 빈을 생성
    @Bean
    public InMemoryUserDetailsManager createUserDetailManager() {
        // UserDetails 객체 생성 (사용자 정보 설정)
        UserDetails userDetail1 = createNewUser("whs", "1111");
        UserDetails userDetail2 = createNewUser("alex", "222");

        //UserDetails 객체를 포함하는 InMemoryUserDetailsManager를 반환
        return new InMemoryUserDetailsManager(userDetail1, userDetail2);
    }


    private UserDetails createNewUser(String username, String password) {
        // 비밀번호 인코더 함수를 정의하여 사용할 준비
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

        UserDetails userDetail = User.builder()
                .passwordEncoder(passwordEncoder)// 비밀번호 인코더 설정
                .username(username).password(password)// 비밀번호 설정
                .roles("USER", "ADMIN")// 사용자 역할 설정
                .build();

        return userDetail;
    }

    // 비밀번호 인코더를 빈으로 등록
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    BCryptPasswordEncoder는 Spring Security에서 제공하는 비밀번호 해싱(Hashing) 및 검증을 수행하기 위한 구현체 중 하나입니다.
//    비밀번호 해싱은 사용자 비밀번호를 저장할 때 보안을 강화하는 데 사용됩니다. BCrypt는 단방향 해시 함수로,
//    동일한 입력(비밀번호)에 대해 항상 동일한 출력(해시)을 생성하지만,
//    해시된 비밀번호를 복원하는 것은 거의 불가능합니다. 이것은 보안을 높이기 위한 주요 목적 중 하나


}
