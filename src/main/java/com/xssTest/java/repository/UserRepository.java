package com.xssTest.java.repository;

import com.xssTest.java.DTO.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;


@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertUser(String username, String password) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        int rowsAffected = jdbcTemplate.update(sql, username, password);
        if (rowsAffected > 0) {
            System.out.println("User inserted successfully.");
        } else {
            System.out.println("User insertion failed.");
        }
    }

    public User getUserById(Long userId) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, new BeanPropertyRowMapper<>(User.class));
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    public void updateUserPassword(Long userId, String newPassword) {
        String sql = "UPDATE users SET password = ? WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, newPassword, userId);
        if (rowsAffected > 0) {
            System.out.println("User password updated successfully.");
        } else {
            System.out.println("User password update failed.");
        }
    }

    public void deleteUser(Long userId) {
        String sql = "DELETE FROM users WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, userId);
        if (rowsAffected > 0) {
            System.out.println("User deleted successfully.");
        } else {
            System.out.println("User deletion failed.");
        }
    }
}
