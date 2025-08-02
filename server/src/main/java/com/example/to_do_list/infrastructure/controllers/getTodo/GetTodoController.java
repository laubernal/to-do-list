package com.example.to_do_list.infrastructure.controllers.getTodo;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.to_do_list.application.getTodo.GetTodoHandler;
import com.example.to_do_list.application.getTodos.TodoDTO;
import com.example.to_do_list.domain.exceptions.TodoNotFoundException;

@RestController
@RequestMapping("/api/todos/{id}")
public class GetTodoController {
    private final GetTodoHandler getTodoHandler;

    public GetTodoController(GetTodoHandler getTodoHandler) {
        this.getTodoHandler = getTodoHandler;
    }

    @GetMapping
    public ResponseEntity<?> getTodo(@PathVariable String id) {
        try {
            TodoDTO response = this.getTodoHandler.execute(UUID.fromString(id));

            Map<String, Object> body = new HashMap<>();

            body.put("data", response);
            body.put("message", "Todo retrieved successfully");
            body.put("timestamp", LocalDateTime.now());
            body.put("status", HttpStatus.CREATED.value());

            return ResponseEntity.ok().body(body);
        } catch (TodoNotFoundException e) {
            Map<String, Object> body = new HashMap<>();
            body.put("error", e.getMessage());
            body.put("timestamp", LocalDateTime.now());
            body.put("status", HttpStatus.NOT_FOUND.value());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND.value())
                    .body(body);

        } catch (Exception e) {
            Map<String, Object> body = new HashMap<>();
            body.put("error", e.getMessage());
            body.put("timestamp", LocalDateTime.now());
            body.put("status", HttpStatus.BAD_REQUEST);

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .body(body);
        }
    }
}
