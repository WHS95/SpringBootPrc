package com.xssTest.java.DTO;


public class User {
    private Long id;
    private String username;
    private String password;

    // 생성자, getter, setter 등 필요한 메서드를 추가하세요

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
