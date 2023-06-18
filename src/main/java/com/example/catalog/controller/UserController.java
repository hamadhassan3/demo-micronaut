package com.example.catalog.controller;

import com.example.catalog.model.dto.request.UserRequest;
import com.example.catalog.model.dto.response.UserResponse;
import com.example.catalog.service.UserService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import java.util.List;

@Controller("/catalog/api/users")
@Secured(SecurityRule.IS_ANONYMOUS)
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Get("/")
    public List<UserResponse> getAllUsers(){
        return userService.readAllUsers();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Get("/{id}/")
    public UserResponse getUserById(Long id){
        return userService.readUser(id);
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Post("/")
    public UserResponse createUser(@Body UserRequest userRequest){
        return userService.createUser(userRequest);
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Put("/{id}/")
    public UserResponse updateUser(Long id, @Body UserRequest userRequest){
        return userService.updateUser(id, userRequest);
    }

    @Produces(MediaType.TEXT_PLAIN)
    @Delete("/{id}/")
    public String deleteUser(Long id){
        return userService.deleteUser(id);
    }
}
