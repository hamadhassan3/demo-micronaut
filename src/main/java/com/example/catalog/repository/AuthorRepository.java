package com.example.catalog.repository;

import com.example.catalog.model.Author;
import com.example.catalog.model.dto.response.AuthorResponse;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@JdbcRepository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    List<AuthorResponse> find();
    Optional<AuthorResponse> find(Long id);
}
