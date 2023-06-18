package com.example.catalog.controller.auth;

import com.example.catalog.model.dto.request.UserRequest;
import com.example.catalog.model.dto.response.UserResponse;
import com.example.catalog.service.UserService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

@Controller("/catalog/api")
@Secured(SecurityRule.IS_ANONYMOUS)
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService){
        this.userService = userService;
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Post("/register")
    public UserResponse createUser(@Body UserRequest userRequest){
        return userService.createUser(userRequest);
    }
}
