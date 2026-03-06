package com.raphaowl.dnd.oauth2;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;

import lombok.Getter;

@Getter
public class CustomUserPrincipal extends DefaultOidcUser {

    private final String userId;

    public CustomUserPrincipal(Collection<? extends GrantedAuthority> authorities,
            OidcIdToken idToken,
            OidcUserInfo userInfo,
            String userId) {

        super(authorities, idToken, userInfo);
        this.userId = userId;
    }
}
