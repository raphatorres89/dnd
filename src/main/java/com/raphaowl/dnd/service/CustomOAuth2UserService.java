package com.raphaowl.dnd.service;

import java.time.Instant;
import java.util.Collections;
import java.util.Map;

import com.raphaowl.dnd.model.User;
import com.raphaowl.dnd.repositories.UserRepository;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final UserRepository userRepository;

    public CustomOAuth2UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oauthUser = delegate.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId(); // google, github
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
                .getUserInfoEndpoint().getUserNameAttributeName();

        Map<String, Object> attributes = oauthUser.getAttributes();

        // extrai info típica (adaptar por provider)
        String providerId = attributes.get(userNameAttributeName).toString();
        String email = (String) attributes.getOrDefault("email", "");
        String name = (String) attributes.getOrDefault("name", attributes.getOrDefault("login", ""));
        String picture = (String) attributes.getOrDefault("picture", attributes.getOrDefault("avatar_url", ""));

        // find or create
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

        // Retorne um DefaultOAuth2User para que Spring Security tenha os authorities
        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")),
                attributes,
                userNameAttributeName);
    }
}
