package com.example.catalog.repository;

import com.example.catalog.model.BookInstance;
import com.example.catalog.model.dto.response.BookInstanceResponse;
import com.example.catalog.model.dto.response.BookResponse;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@JdbcRepository(dialect = Dialect.MYSQL)
public interface BookInstanceRepository extends CrudRepository<BookInstance, Long> {
    List<BookInstanceResponse> find();
    Optional<BookInstanceResponse> find(Long id);
}
