package me.jics;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MutableHttpRequest;
import io.micronaut.http.filter.ClientFilterChain;
import io.micronaut.http.filter.HttpClientFilter;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;

import java.util.Map;

@KeycloakBodyUMA
@RequiredArgsConstructor
@Singleton
public class KeycloakFilter implements HttpClientFilter {

    private final KeycloakConfiguration configuration;

    @Override
    public Publisher<? extends HttpResponse<?>> doFilter(MutableHttpRequest<?> request, ClientFilterChain chain) {
        return chain.proceed(request.body(Map.of("grant-type", configuration.getGrantType(), "audience", configuration.getAudience())));
    }
}
