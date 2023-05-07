package com.example.catalog.controller;

import com.example.catalog.model.dto.request.GenreRequest;
import com.example.catalog.model.dto.response.GenreResponse;
import com.example.catalog.service.GenreService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import java.util.List;

@Controller("/catalog/api/genres")
@Secured(SecurityRule.IS_ANONYMOUS)
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Get("/")
    public List<GenreResponse> getAllGenres(){
        return genreService.readAllGenres();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Get("/{id}/")
    public GenreResponse getGenreById(Long id){
        return genreService.readGenre(id);
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Post("/")
    public GenreResponse createGenre(@Body GenreRequest genreRequest){
        return genreService.createGenre(genreRequest);
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Put("/{id}/")
    public GenreResponse updateGenre(Long id, @Body GenreRequest genreRequest){
        return genreService.updateGenre(id, genreRequest);
    }

    @Produces(MediaType.TEXT_PLAIN)
    @Delete("/{id}/")
    public String deleteGenre(Long id){
        return genreService.deleteGenre(id);
    }
}
