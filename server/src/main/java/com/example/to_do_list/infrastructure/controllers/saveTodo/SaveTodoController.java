package com.example.to_do_list.infrastructure.controllers.saveTodo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.to_do_list.application.saveTodo.SaveTodoHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> saveTodo(@RequestBody saveTodoRequestDto entity) {
        try {
            this.saveTodoHandler.execute(entity);

            Map<String, Object> body = new HashMap<>();
            body.put("message", "Todo created successfully");
            body.put("timestamp", LocalDateTime.now());
            body.put("status", HttpStatus.CREATED);

            return ResponseEntity.ok().body(body);
        } catch (Exception e) {
            Map<String, Object> body = new HashMap<>();
            body.put("error", e.getMessage());
            body.put("timestamp", LocalDateTime.now());
            body.put("status", HttpStatus.BAD_REQUEST);

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(body);
        }
    }

}
