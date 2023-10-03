package com.xssTest.java.repository;

import jakarta.persistence.*;
import lombok.*;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String title;

    @Column
    private String content;

    public void removeTag() {
        this.title = this.title.replaceAll("<", "&lt;");
        this.title = this.title.replaceAll(">", "&gt;");
        this.content = this.content.replaceAll("<", "&lt;");
        this.content = this.content.replaceAll(">", "&gt;");
    }
}