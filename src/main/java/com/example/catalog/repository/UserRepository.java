package com.example.catalog.repository;

import com.example.catalog.model.User;
import com.example.catalog.model.dto.response.UserResponse;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@JdbcRepository(dialect = Dialect.MYSQL)
public interface UserRepository extends CrudRepository<User, Long> {
    List<UserResponse> find();
    Optional<UserResponse> find(Long id);
    Optional<UserResponse> findByUsername(String username);
}
