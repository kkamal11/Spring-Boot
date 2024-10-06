package com.kamal.spring_security_demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")  //need to give is table name and class name are different
public class User {
    @Id
    private int id;
    private String username;
    private String password;
}
