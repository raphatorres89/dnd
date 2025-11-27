package com.raphaowl.dnd.oauth2;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByProviderAndProviderId(String registrationId, String providerId);
    Optional<User> findByEmail(String email);
}
