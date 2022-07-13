package me.jics;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import org.reactivestreams.Publisher;

@KeycloakBodyUMA
@Client(id = "keycloak")
public interface KeycloakClient {
    @Post(uri = "/token", produces = MediaType.APPLICATION_FORM_URLENCODED)
    Publisher<RequestPartyToken> getClaims(@Header("Authorization") String bearer);
}
