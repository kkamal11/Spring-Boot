package com.kamal.spring_security_demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")  //need to give is table name and class name are different
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    @Column(name = "username",unique = true, nullable = false)
    private String username;
    @Column(name = "password",nullable = false)
    private String password;
}
