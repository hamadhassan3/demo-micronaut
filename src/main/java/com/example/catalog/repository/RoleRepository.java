package com.example.catalog.repository;

import com.example.catalog.model.Role;
import com.example.catalog.model.dto.response.RoleResponse;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@JdbcRepository(dialect = Dialect.MYSQL)
public interface RoleRepository extends CrudRepository<Role, Long> {
    List<RoleResponse> find();
    Optional<RoleResponse> find(Long id);
}
