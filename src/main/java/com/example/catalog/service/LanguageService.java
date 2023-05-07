package com.example.catalog.service;

import com.example.catalog.model.Language;
import com.example.catalog.model.dto.request.LanguageRequest;
import com.example.catalog.model.dto.response.LanguageResponse;
import com.example.catalog.repository.LanguageRepository;
import jakarta.inject.Singleton;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Singleton
public class LanguageService {

    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public long countLanguages(){
        return languageRepository.count();
    }

    public List<LanguageResponse> readAllLanguages(){
        return languageRepository.find();
    }

    public LanguageResponse readLanguage(Long id){

        Optional<LanguageResponse> optionalLanguageResponse = languageRepository.find(id);

        if(optionalLanguageResponse.isEmpty()){
            throw new NoSuchElementException("A Language with this id does not exist!");
        }

        return optionalLanguageResponse.get();
    }

    @Transactional
    public LanguageResponse createLanguage(LanguageRequest languageRequest){

        Language language = new Language();
        language.setName(languageRequest.name());
        language = languageRepository.save(language);
        return new LanguageResponse(language);
    }

    @Transactional
    public LanguageResponse updateLanguage(Long id, LanguageRequest languageRequest){
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isEmpty()){
            throw new NoSuchElementException("A Language with this id does not exist!");
        }
        else {
            Language language = optionalLanguage.get();
            language.setName(languageRequest.name());
            language = languageRepository.update(language);
            return new LanguageResponse(language);
        }
    }

    @Transactional
    public String deleteLanguage(Long id){
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isEmpty()){
            throw new NoSuchElementException("A Language with this id does not exist!");
        }
        else {
            languageRepository.delete(optionalLanguage.get());
            return "success";
        }
    }
}
