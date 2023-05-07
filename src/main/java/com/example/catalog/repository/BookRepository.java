package com.example.catalog.repository;

import com.example.catalog.model.Book;
import com.example.catalog.model.dto.response.AuthorResponse;
import com.example.catalog.model.dto.response.BookResponse;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@JdbcRepository(dialect = Dialect.MYSQL)
public interface BookRepository extends CrudRepository<Book, Long> {
    List<BookResponse> find();
    Optional<BookResponse> find(Long id);
}
