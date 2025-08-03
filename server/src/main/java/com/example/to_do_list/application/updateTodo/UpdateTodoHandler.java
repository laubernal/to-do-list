package com.example.to_do_list.application.updateTodo;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.to_do_list.domain.entity.Todo;
import com.example.to_do_list.domain.exceptions.TodoNotFoundException;
import com.example.to_do_list.domain.repository.ITodoRepository;
import com.example.to_do_list.infrastructure.controllers.updateTodo.UpdateTodoRequestDto;

@Service("updateTodoHandler")
public class UpdateTodoHandler {
    public final ITodoRepository todoRepository;

    public UpdateTodoHandler(ITodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void execute(String id, UpdateTodoRequestDto todo) {
        UUID todoId = UUID.fromString(id);
        Todo foundTodo = this.findTodo(todoId);

        Todo updatedTodo = new Todo(todoId, todo.title(), todo.completed(), foundTodo.createdAt(),
                LocalDateTime.now());

        this.todoRepository.update(updatedTodo);
    }

    private Todo findTodo(UUID id) {
        Optional<Todo> todo = this.todoRepository.findOneById(id);

        if (todo.isEmpty()) {
            throw new TodoNotFoundException();
        }

        return todo.get();
    }
}