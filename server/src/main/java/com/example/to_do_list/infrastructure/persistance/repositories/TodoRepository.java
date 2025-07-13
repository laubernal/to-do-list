package com.example.to_do_list.infrastructure.persistance.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.to_do_list.domain.entity.Todo;
import com.example.to_do_list.domain.repository.ITodoRepository;
import com.example.to_do_list.infrastructure.models.TodoEntity;
import com.example.to_do_list.infrastructure.persistance.mappers.TodoMapper;

@Repository
public class TodoRepository implements ITodoRepository {
    private final JpaTodoRepository jpaTodoRepository;
    private final TodoMapper mapper;

    public TodoRepository(JpaTodoRepository jpaTodoRepository, TodoMapper mapper) {
        this.jpaTodoRepository = jpaTodoRepository;
        this.mapper = mapper;

    }

    @Override
    public Optional<Todo> findOneById(UUID id) {
        Optional<TodoEntity> result = jpaTodoRepository.findById(id);

        return result.map(this.mapper::toDomain);
    }

    @Override
    public Optional<Todo> findOneByTitle(String title) {
        Optional<TodoEntity> result = jpaTodoRepository.findOneByTitle(title);

        return result.map(this.mapper::toDomain);
    }

    @Override
    public List<Todo> findAll() {
        List<TodoEntity> results = jpaTodoRepository.findAll();

        return results.stream().map(mapper::toDomain).toList();
    }

    @Override
    public void save(Todo entity) {
        TodoEntity todo = this.mapper.toModel(entity);

        jpaTodoRepository.save(todo);
    }

    @Override
    public void update(Todo entity) {
        TodoEntity todo = this.mapper.toModel(entity);

        jpaTodoRepository.save(todo);
    }

    @Override
    public void delete(UUID id) {
        jpaTodoRepository.deleteById(id);
    }
}
