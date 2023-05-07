package com.example.catalog.service;

import com.example.catalog.model.Genre;
import com.example.catalog.model.dto.request.GenreRequest;
import com.example.catalog.model.dto.response.GenreResponse;
import com.example.catalog.repository.GenreRepository;
import jakarta.inject.Singleton;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Singleton
public class GenreService {

    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public long countGenres(){
        return genreRepository.count();
    }

    public List<GenreResponse> readAllGenres(){
        return genreRepository.find();
    }

    public GenreResponse readGenre(Long id){

        Optional<GenreResponse> optionalGenreResponse = genreRepository.find(id);

        if(optionalGenreResponse.isEmpty()){
            throw new NoSuchElementException("A Genre with this id does not exist!");
        }

        return optionalGenreResponse.get();
    }

    @Transactional
    public GenreResponse createGenre(GenreRequest genreRequest){

        Genre genre = new Genre();
        genre.setName(genreRequest.name());
        genre = genreRepository.save(genre);
        return new GenreResponse(genre);
    }

    @Transactional
    public GenreResponse updateGenre(Long id, GenreRequest genreRequest){
        Optional<Genre> optionalGenre = genreRepository.findById(id);
        if(optionalGenre.isEmpty()){
            throw new NoSuchElementException("A Genre with this id does not exist!");
        }
        else {
            Genre genre = optionalGenre.get();
            genre.setName(genreRequest.name());
            genre = genreRepository.update(genre);
            return new GenreResponse(genre);
        }
    }

    @Transactional
    public String deleteGenre(Long id){
        Optional<Genre> optionalGenre = genreRepository.findById(id);
        if(optionalGenre.isEmpty()){
            throw new NoSuchElementException("A Genre with this id does not exist!");
        }
        else {
            genreRepository.delete(optionalGenre.get());
            return "success";
        }
    }
}
