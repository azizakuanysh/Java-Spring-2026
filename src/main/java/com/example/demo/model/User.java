package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Set;

@Data                   // Lombok: generates getters, setters, toString, equals
@Builder                // Lombok: lets you do User.builder().email("...").build()
@NoArgsConstructor      // Lombok: generates empty constructor
@AllArgsConstructor     // Lombok: generates full constructor
@Document(collection = "users")   // MongoDB: maps this class to "users" collection
public class User {

    @Id                             // MongoDB document ID (_id field)
    private String id;

    private String username;

    @Indexed(unique = true)         // MongoDB index — no duplicate emails
    private String email;

    private String password;        // Will be stored hashed (BCrypt)

    private Set<Role> roles;        // e.g. [ROLE_USER] or [ROLE_USER, ROLE_ADMIN]

    private boolean enabled;        // false until email is verified

    private String profileImagePath;  // for file upload lab

    private LocalDateTime createdAt;
}