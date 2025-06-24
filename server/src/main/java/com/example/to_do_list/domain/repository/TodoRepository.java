package com.example.to_do_list.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.to_do_list.domain.entity.Todo;

public interface TodoRepository {
    Optional<Todo> findOne(UUID id);

    List<Todo> findAll();

    void save(Todo todo);

    void update(Todo todo);

    void delete(UUID id);
}
