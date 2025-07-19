package com.example.to_do_list.application.saveTodo;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.to_do_list.domain.entity.Todo;
import com.example.to_do_list.domain.exceptions.TodoAlreadyExistsException;
import com.example.to_do_list.domain.repository.ITodoRepository;
import com.example.to_do_list.infrastructure.controllers.saveTodo.saveTodoRequestDto;

@Service("saveTodoHandler")
public class SaveTodoHandler {
    private final ITodoRepository todoRepository;

    public SaveTodoHandler(ITodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void execute(saveTodoRequestDto todo) {
        this.ensureTodoNotExistsAlready(todo);

        Todo todoEntity = new Todo(todo.id(), todo.title(), false, LocalDateTime.now(), LocalDateTime.now());

        todoRepository.save(todoEntity);
    }

    private void ensureTodoNotExistsAlready(saveTodoRequestDto todo) {
        Optional<Todo> result = todoRepository.findOneByTitle(todo.title());

        if (result.isPresent()) {
            throw new TodoAlreadyExistsException();
        }
    }
}
