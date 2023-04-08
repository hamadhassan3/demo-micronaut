package com.example.catalog.repository;

import com.example.catalog.model.Genre;
import com.example.catalog.model.dto.request.GenreRequest;
import com.example.catalog.model.dto.response.GenreResponse;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@JdbcRepository(dialect = Dialect.MYSQL)
public interface GenreRepository extends CrudRepository<Genre, Long> {
    List<GenreResponse> find();
    Optional<GenreResponse> find(Long id);
}
