package me.jics;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.security.authentication.AuthenticationResponse;
import io.micronaut.security.oauth2.endpoint.authorization.state.State;
import io.micronaut.security.oauth2.endpoint.token.response.OauthAuthenticationMapper;
import io.micronaut.security.oauth2.endpoint.token.response.TokenResponse;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

import java.util.Collections;

@Slf4j
@RequiredArgsConstructor
@Named("keycloak")
@Singleton
public class KeycloakAuthenticationMapper implements OauthAuthenticationMapper {

    private final KeycloakClient keycloakClient;

    @Override
    public Publisher<AuthenticationResponse> createAuthenticationResponse(TokenResponse tokenResponse, @Nullable State state) {
        return Mono.from(keycloakClient.getUserInfo(tokenResponse.getAccessToken()))
                .map(userInfo -> {
                    log.info(userInfo.getUsername()); // should print this.
                    return AuthenticationResponse.success(userInfo.getUsername(), Collections.singletonList("User"),
                            Collections.singletonMap(ACCESS_TOKEN_KEY, tokenResponse.getAccessToken()));
                });
    }
}
