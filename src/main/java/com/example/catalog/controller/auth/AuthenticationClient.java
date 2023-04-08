package com.example.catalog.controller.auth;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.security.authentication.UsernamePasswordCredentials;
import io.micronaut.security.token.jwt.render.BearerAccessRefreshToken;

import static io.micronaut.http.HttpHeaders.AUTHORIZATION;

@Client("/")
public interface AuthenticationClient {

    @Produces(MediaType.APPLICATION_JSON)
    @Post("/login")
    BearerAccessRefreshToken login(@Body UsernamePasswordCredentials credentials);

    @Consumes(MediaType.TEXT_PLAIN)
    @Get
    String home(@Header(AUTHORIZATION) String authorization);
}

