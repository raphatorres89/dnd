package com.raphaowl.dnd.service;

import java.time.Instant;

import com.raphaowl.dnd.model.User;
import com.raphaowl.dnd.repositories.UserRepository;

import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

@Service
public class CustomOidcUserService extends OidcUserService {

    private final UserRepository userRepository;

    public CustomOidcUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) {
        OidcUser oidcUser = super.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String providerId = oidcUser.getSubject();

        String email = oidcUser.getEmail();
        String name = oidcUser.getFullName();
        String picture = oidcUser.getPicture();

        User user = userRepository.findByProviderAndProviderId(registrationId, providerId)
                .orElseGet(() -> {
                    User u = new User();
                    u.setProvider(registrationId);
                    u.setProviderId(providerId);
                    u.setCreatedAt(Instant.now());
                    return u;
                });

        user.setEmail(email);
        user.setName(name);
        user.setPicture(picture);
        user.setLastLogin(Instant.now());

        userRepository.save(user);

        return oidcUser;
    }
}
