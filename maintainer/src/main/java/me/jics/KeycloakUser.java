package me.jics;

import io.micronaut.core.annotation.Introspected;
import lombok.Data;

import java.util.List;

@Data
@Introspected
public class KeycloakUser {
    private String email;
    private String username;
    private List<String> roles;
}
