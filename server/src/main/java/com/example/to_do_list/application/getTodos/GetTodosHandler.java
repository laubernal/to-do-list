package com.example.to_do_list.application.getTodos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.to_do_list.domain.entity.Todo;
import com.example.to_do_list.domain.repository.ITodoRepository;

@Service("getTodosHandler")
public class GetTodosHandler {
    private final ITodoRepository todoRepository;

    public GetTodosHandler(ITodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoDTO> execute() {
        List<Todo> todos = todoRepository.findAll();

        List<TodoDTO> response = todos.stream()
                .map(todo -> new TodoDTO(todo.id(), todo.title(), todo.completed(), todo.createdAt(),
                        todo.updatedAt()))
                .toList();

        return response;
    }
}
