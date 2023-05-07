package com.example.catalog.controller.auth;

import com.example.catalog.model.dto.response.AccessRefreshTokenResponse;
import com.example.catalog.security.client.LoginClient;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.authentication.UsernamePasswordCredentials;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.security.token.jwt.render.BearerAccessRefreshToken;

@Controller("/catalog/api")
@Secured(SecurityRule.IS_ANONYMOUS)
public class LoginController {

    private final LoginClient loginClient;

    public LoginController(LoginClient loginClient) {
        this.loginClient = loginClient;
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Post("/token")
    public AccessRefreshTokenResponse login(@Body UsernamePasswordCredentials credentials){
        BearerAccessRefreshToken token = loginClient.login(credentials);

        return new AccessRefreshTokenResponse(token.getUsername(),
                token.getAccessToken(),
                token.getRefreshToken(),
                token.getTokenType(),
                token.getExpiresIn(),
                token.getRoles());
    }
}
