package com.example.to_do_list.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.to_do_list.domain.entity.Todo;

public interface ITodoRepository {
    Optional<Todo> findOneById(UUID id);

    Optional<Todo> findOneByTitle(String title);

    List<Todo> findAll();

    void save(Todo todo);

    void update(Todo todo);

    void delete(UUID id);
}
