package com.example.catalog.repository;

import com.example.catalog.model.User;
import com.example.catalog.model.dto.response.UserResponse;
import io.micronaut.data.annotation.Join;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@JdbcRepository(dialect = Dialect.MYSQL)
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> find();
    Optional<User> find(Long id);
    @Join(value = "role", type = Join.Type.LEFT_FETCH)
    Optional<User> findByUsername(String username);
}
