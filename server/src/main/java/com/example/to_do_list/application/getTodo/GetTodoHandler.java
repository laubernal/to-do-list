package com.example.to_do_list.application.getTodo;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.to_do_list.application.getTodos.TodoDTO;
import com.example.to_do_list.domain.entity.Todo;
import com.example.to_do_list.domain.exceptions.TodoNotFoundException;
import com.example.to_do_list.domain.repository.ITodoRepository;

@Service("getTodoHandler")
public class GetTodoHandler {
    private final ITodoRepository todoRepository;

    public GetTodoHandler(ITodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoDTO execute(UUID id) {
        Optional<Todo> optionalTodo = todoRepository.findOneById(id);

        if (optionalTodo.isEmpty()) {
            throw new TodoNotFoundException();
        }

        Todo todo = optionalTodo.get();

        TodoDTO response = new TodoDTO(todo.id(), todo.title(), todo.completed(),
                todo.createdAt(),
                todo.updatedAt());

        return response;

    }
}
