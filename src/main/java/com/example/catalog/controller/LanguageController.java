package com.example.catalog.controller;

import com.example.catalog.model.dto.request.LanguageRequest;
import com.example.catalog.model.dto.response.LanguageResponse;
import com.example.catalog.service.LanguageService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;

import java.util.List;

@Controller("/catalog/api/languages")
@Secured(SecurityRule.IS_ANONYMOUS)
public class LanguageController {

    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Get("/")
    public List<LanguageResponse> getAllLanguages(){
        return languageService.readAllLanguages();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Get("/{id}/")
    public LanguageResponse getLanguageById(Long id){
        return languageService.readLanguage(id);
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Post("/")
    public LanguageResponse createLanguage(@Body LanguageRequest languageRequest){
        return languageService.createLanguage(languageRequest);
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Put("/{id}/")
    public LanguageResponse updateLanguage(Long id, @Body LanguageRequest languageRequest){
        return languageService.updateLanguage(id, languageRequest);
    }

    @Produces(MediaType.TEXT_PLAIN)
    @Delete("/{id}/")
    public String deleteLanguage(Long id){
        return languageService.deleteLanguage(id);
    }
}
