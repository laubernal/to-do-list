package com.example.to_do_list.application.saveTodo;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.to_do_list.domain.entity.Todo;
import com.example.to_do_list.domain.repository.TodoRepository;
import com.example.to_do_list.infrastructure.controller.saveTodo.saveTodoRequestDto;

@Service("saveTodoHandler")
public class SaveTodoHandler {
    private final TodoRepository todoRepository;

    public SaveTodoHandler(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void execute(saveTodoRequestDto todo) {
        this.ensureTodoNotExistsAlready(todo);

        Todo todoEntity = new Todo(todo.id(), todo.title());

        todoRepository.save(todoEntity);
    }

    private void ensureTodoNotExistsAlready(saveTodoRequestDto todo) {
        Optional<Todo> result = todoRepository.findOneByTitle(todo.title());

        if (result.isPresent()) {
            throw new Error("Todo already exists");
        }
    }
}
