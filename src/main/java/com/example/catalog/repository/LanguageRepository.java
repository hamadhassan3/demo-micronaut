package com.example.catalog.repository;

import com.example.catalog.model.Language;
import com.example.catalog.model.dto.response.LanguageResponse;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@JdbcRepository(dialect = Dialect.MYSQL)
public interface LanguageRepository extends CrudRepository<Language, Long> {
    List<LanguageResponse> find();
    Optional<LanguageResponse> find(Long id);
}
