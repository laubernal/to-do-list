package com.example.to_do_list.infrastructure.controller.saveTodo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.to_do_list.application.saveTodo.SaveTodoHandler;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/todos")
public class SaveTodoController {
    private final SaveTodoHandler saveTodoHandler;

    public SaveTodoController(SaveTodoHandler saveTodoHandler) {
        this.saveTodoHandler = saveTodoHandler;
    }

    @PostMapping
    public void saveTodo(@RequestBody saveTodoRequestDto entity) {
        this.saveTodoHandler.execute(entity);
    }

}
