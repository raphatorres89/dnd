package com.raphaowl.dnd.repositories;

import java.util.Optional;

import com.raphaowl.dnd.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByProviderAndProviderId(String registrationId, String providerId);
}
