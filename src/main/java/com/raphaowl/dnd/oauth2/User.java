package com.raphaowl.dnd.oauth2;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "users")
@Data
public class User {
    @Id
    private String id;

    private String provider;
    private String providerId;
    private String email;
    private String name;
    private String picture;
    private Instant createdAt;
    private Instant lastLogin;
}
