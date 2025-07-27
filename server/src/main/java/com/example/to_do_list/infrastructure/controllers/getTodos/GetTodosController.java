package com.example.to_do_list.infrastructure.controllers.getTodos;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.to_do_list.application.getTodos.GetTodosHandler;
import com.example.to_do_list.application.getTodos.TodoDTO;

@RestController
@RequestMapping("/api/todos")
public class GetTodosController {
    private final GetTodosHandler getTodosHandler;

    public GetTodosController(GetTodosHandler getTodosHandler) {
        this.getTodosHandler = getTodosHandler;
    }

    @GetMapping
    public ResponseEntity<?> getTodos() {
        try {
            List<TodoDTO> response = this.getTodosHandler.execute();

            Map<String, Object> body = new HashMap<>();

            body.put("data", response);
            body.put("message", "Todos retrieved successfully");
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
