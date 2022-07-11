package me.jics;

import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;

import java.util.Map;

import static io.micronaut.security.rules.SecurityRule.IS_AUTHENTICATED;

@Controller("/home")
public class HomeController {

    @Secured(IS_AUTHENTICATED)
    @Get
    public Map<String, String> index() {
        return Map.of("my", "value");
    }
}