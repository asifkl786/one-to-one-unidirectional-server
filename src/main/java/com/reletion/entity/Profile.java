package com.reletion.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phoneNumber;
    
    @Column(nullable = false)
    private String department;
    
    @Column(nullable = false)
    private String designation;   
}

