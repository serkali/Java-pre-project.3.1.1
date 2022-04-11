package com.example.Java.preproject311.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user2")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastname;
}
