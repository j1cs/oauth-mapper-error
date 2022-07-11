package me.jics;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import org.reactivestreams.Publisher;

@KeycloakBasicAuth
@Client(id = "keycloak")
public interface KeycloakClient {
    @Post(uri = "/token/introspect", produces = MediaType.APPLICATION_FORM_URLENCODED)
    Publisher<KeycloakUser> getUserInfo(@Body String token);
}
