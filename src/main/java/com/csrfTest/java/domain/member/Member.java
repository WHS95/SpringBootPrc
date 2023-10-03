package com.csrfTest.java.domain.member;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_MEMBER")
public class Member {

    @Id
    private String id;

    @Column
    private String password;

    @Column
    private String memberName;
}