package com.personal.CRUD.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name= "last_name", nullable = false)
    private String lastname;

    @Column(name="first_name", nullable = false)
    private String firstname;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="age",nullable = false)
    private Integer age;

}
