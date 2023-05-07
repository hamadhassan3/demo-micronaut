package com.example.catalog.service;

import com.example.catalog.model.Author;
import com.example.catalog.model.dto.request.AuthorRequest;
import com.example.catalog.model.dto.response.AuthorResponse;
import com.example.catalog.repository.AuthorRepository;
import jakarta.inject.Singleton;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Singleton
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public long countAuthors(){
        return authorRepository.count();
    }

    public List<AuthorResponse> readAllAuthors(){
        return authorRepository.find();
    }

    public AuthorResponse readAuthor(Long id){

        Optional<AuthorResponse> optionalAuthorResponse = authorRepository.find(id);

        if(optionalAuthorResponse.isEmpty()){
            throw new NoSuchElementException("An Author with this id does not exist!");
        }

        return optionalAuthorResponse.get();
    }

    @Transactional
    public AuthorResponse createAuthor(AuthorRequest authorRequest){

        Author author = new Author();
        author.setFirstName(authorRequest.firstName());
        author.setLastName(authorRequest.lastName());
        author.setDateOfBirth(authorRequest.dateOfBirth());
        author.setDateOfDeath(authorRequest.dateOfDeath());
        author = authorRepository.save(author);
        return new AuthorResponse(author);
    }

    @Transactional
    public AuthorResponse updateAuthor(Long id, AuthorRequest authorRequest){
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if(optionalAuthor.isEmpty()){
            throw new NoSuchElementException("An Author with this id does not exist!");
        }
        else {
            Author author = optionalAuthor.get();
            author.setFirstName(authorRequest.firstName());
            author.setLastName(authorRequest.lastName());
            author.setDateOfBirth(authorRequest.dateOfBirth());
            author.setDateOfDeath(authorRequest.dateOfDeath());

            author = authorRepository.update(author);
            return new AuthorResponse(author);
        }
    }

    @Transactional
    public String deleteAuthor(Long id){
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if(optionalAuthor.isEmpty()){
            throw new NoSuchElementException("An Author with this id does not exist!");
        }
        else {
            authorRepository.delete(optionalAuthor.get());
            return "success";
        }
    }
}
