package com.example.catalog.controller;

import com.example.catalog.model.dto.request.AuthorRequest;
import com.example.catalog.model.dto.response.AuthorResponse;
import com.example.catalog.service.AuthorService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import java.util.List;

@Controller("/catalog/api/authors")
@Secured(SecurityRule.IS_ANONYMOUS)
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Secured(SecurityRule.IS_ANONYMOUS)
    @Produces(MediaType.APPLICATION_JSON)
    @Get
    public List<AuthorResponse> getAllAuthors(){
        return authorService.readAllAuthors();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Get("/{id}/")
    public AuthorResponse getAuthorById(Long id){
        return authorService.readAuthor(id);
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Post("/")
    public AuthorResponse createAuthor(@Body AuthorRequest authorRequest){
        return authorService.createAuthor(authorRequest);
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Put("/{id}/")
    public AuthorResponse updateAuthor(Long id, @Body AuthorRequest authorRequest){
        return authorService.updateAuthor(id, authorRequest);
    }

    @Produces(MediaType.TEXT_PLAIN)
    @Delete("/{id}/")
    public String deleteAuthor(Long id){
        return authorService.deleteAuthor(id);
    }
}
