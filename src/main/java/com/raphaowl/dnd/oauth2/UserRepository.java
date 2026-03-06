package com.raphaowl.dnd.oauth2;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByProviderAndProviderId(String registrationId, String providerId);
    Optional<User> findByEmail(String email);
}
