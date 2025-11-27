package com.raphaowl.dnd.oauth2;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String provider;
    private String providerId;
    private String email;
    private String name;
    private String picture;
    private Instant createdAt;
    private Instant lastLogin;
}
