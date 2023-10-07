package com.mini.SpringBootPrc.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;


//DataBase
//Static List of todos => Database(h2,Mysql)

//JPA
//Bean -> DataBase Table



//@Entity(name = "TodoABC") 테이블 명을 임의로 정할 수 있다.
//위와 같이 하면 테이블 명은 TodoABC라는 테이블이 된다.

//따로 설정을 하지 않으면 클래스의 명이 테이블명이 된다.
@Entity
public class Todo {


    public Todo() {

    }
    public Todo(int id, String username, String description, LocalDate targetDate, boolean done) {
        super();
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
    }

    @Id
    @GeneratedValue
    private int id;
    private String username;

    @Size(min=10, message = "Enter at least 10 characters")
    private String description;
    private LocalDate targetDate;
    private boolean done;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }


    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", done=" + done +
                '}';
    }
}
