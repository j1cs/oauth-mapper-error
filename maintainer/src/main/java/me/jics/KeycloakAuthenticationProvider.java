package me.jics;

import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.AuthenticationProvider;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Singleton
public class KeycloakAuthenticationProvider implements AuthenticationProvider {

    private final KeycloakClient client;

    @Override
    public Publisher<AuthenticationResponse> authenticate(HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> authenticationRequest) {
        return Mono.from(client.getClaims(httpRequest.getHeaders().get("Authorization")))
                .map(requestPartyToken ->
                        {
                            log.info(requestPartyToken.toString()); // ain't entering.
                            return AuthenticationResponse.success(requestPartyToken.getAccess().getPreferredUsername(),
                                    requestPartyToken.getAccess().getRealmAccess().getRoles());
                        }
                );
    }
}
