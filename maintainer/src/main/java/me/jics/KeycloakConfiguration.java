package me.jics;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.context.annotation.Requires;
import lombok.Getter;

@Getter
@ConfigurationProperties(KeycloakConfiguration.PREFIX)
@Requires(property = KeycloakConfiguration.PREFIX)
@SuppressWarnings("unused")
public class KeycloakConfiguration {
    public static final String PREFIX = "services.keycloak";
    private String grantType;
    private String audience;
}
