package com.example.demo.module.user.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "USER_TABLE")
@Getter
@Setter
public class UseEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id ;

    @Column(name = "user_name" , nullable = false)
    private String Name ;

    @Column(name = "user_pass",nullable = false)
    private String password ;

}
