package com.example.catalog.controller;

import com.example.catalog.model.dto.response.GenreResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import java.util.ArrayList;
import java.util.List;

@Controller("/catalog/api/home")
@Secured(SecurityRule.IS_ANONYMOUS)
public class HomeController {

    @Produces(MediaType.APPLICATION_JSON)
    @Get("/")
    public List<GenreResponse> getHomeData(){
        return new ArrayList<>();
    }
}
