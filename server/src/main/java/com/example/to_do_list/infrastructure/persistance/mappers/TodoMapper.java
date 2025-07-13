package com.example.to_do_list.infrastructure.persistance.mappers;

import org.springframework.stereotype.Component;

import com.example.to_do_list.domain.entity.Todo;
import com.example.to_do_list.domain.interfaces.IMapper;
import com.example.to_do_list.infrastructure.models.TodoEntity;

@Component
public class TodoMapper implements IMapper<Todo, TodoEntity> {
    public Todo toDomain(TodoEntity todo) {
        return new Todo(todo.getId(), todo.getTitle(), todo.isCompleted(), todo.getCreatedAt(), todo.getUpdatedAt());
    }

    public TodoEntity toModel(Todo todo) {
        return new TodoEntity(todo.id(), todo.title(), todo.completed(), todo.createdAt(), todo.updatedAt());
    }
}
