package com.example.to_do_list.application.deleteTodo;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.to_do_list.domain.entity.Todo;
import com.example.to_do_list.domain.exceptions.TodoNotFoundException;
import com.example.to_do_list.domain.repository.ITodoRepository;

@Service("deleteTodoHandler")
public class DeleteTodoHandler {
    private final ITodoRepository todoRepository;

    public DeleteTodoHandler(ITodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void execute(UUID id) {
        this.ensureTodoExists(id);

        this.todoRepository.delete(id);
    }

    private void ensureTodoExists(UUID id) {
        Optional<Todo> optionalTodo = this.todoRepository.findOneById(id);

        if (optionalTodo.isEmpty()) {
            throw new TodoNotFoundException();
        }
    }
}
