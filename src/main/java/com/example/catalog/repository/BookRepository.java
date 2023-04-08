package com.example.catalog.repository;

import com.example.catalog.model.Book;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect= Dialect.MYSQL)
public interface BookRepository extends CrudRepository<Book, Long> {
}
