package com.example.to_do_list.infrastructure.controllers.deleteTodo;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.to_do_list.application.deleteTodo.DeleteTodoHandler;
import com.example.to_do_list.domain.exceptions.TodoNotFoundException;

@RestController
@RequestMapping("/api/todos/{id}")
public class DeleteTodoController {
    private final DeleteTodoHandler deleteTodoHandler;

    public DeleteTodoController(DeleteTodoHandler deleteTodoHandler) {
        this.deleteTodoHandler = deleteTodoHandler;
    }

    @DeleteMapping
    public ResponseEntity<?> deleteTodo(@PathVariable String id) {
        try {
            this.deleteTodoHandler.execute(UUID.fromString(id));

            Map<String, Object> body = new HashMap<>();
            body.put("message", "Todo deleted successfully");
            body.put("timestamp", LocalDateTime.now());
            body.put("status", HttpStatus.OK.value());

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
            body.put("status", HttpStatus.BAD_REQUEST.value());

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .body(body);
        }
    }
}
