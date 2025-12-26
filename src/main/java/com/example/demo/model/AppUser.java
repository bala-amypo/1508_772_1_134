package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // REQUIRED BY TESTS (instead of fullName)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    // KEEP AS STRING (NO UserRole enum)
    private String role;
}
