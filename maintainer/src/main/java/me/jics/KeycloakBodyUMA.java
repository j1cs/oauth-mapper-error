package me.jics;

import io.micronaut.http.annotation.FilterMatcher;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@FilterMatcher
@Documented
@Retention(RUNTIME)
@Target({TYPE, PARAMETER})
public @interface KeycloakBodyUMA {
}
