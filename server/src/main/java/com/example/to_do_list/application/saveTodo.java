package com.example.to_do_list.application;

import com.example.to_do_list.domain.entity.Todo;
import com.example.to_do_list.domain.repository.TodoRepository;

public class saveTodo {
    private final TodoRepository todoRepository;

    public saveTodo(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void execute(Todo todo) {
        todoRepository.save(todo);
    }
}
