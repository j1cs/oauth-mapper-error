package me.jics;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.TypeHint;
import lombok.*;
import lombok.extern.jackson.Jacksonized;
import org.keycloak.representations.AccessToken;

@Jacksonized
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode
@ToString
@TypeHint(
        typeNames = {"om.mapaconflictomzs.RequestPartyToken$RequestPartyTokenBuilder"},
        accessType = {TypeHint.AccessType.ALL_DECLARED_CONSTRUCTORS, TypeHint.AccessType.ALL_DECLARED_FIELDS, TypeHint.AccessType.ALL_DECLARED_METHODS}
)
@Introspected
public class RequestPartyToken {
    @JsonProperty("access_token")
    private AccessToken access;
}
