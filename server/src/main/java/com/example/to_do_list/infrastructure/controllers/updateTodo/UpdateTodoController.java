package com.example.to_do_list.infrastructure.controllers.updateTodo;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.to_do_list.application.updateTodo.UpdateTodoHandler;
import com.example.to_do_list.domain.exceptions.TodoNotFoundException;

@RestController()
@RequestMapping("/api/todos/{id}")
public class UpdateTodoController {
    private final UpdateTodoHandler updateTodoHandler;

    public UpdateTodoController(UpdateTodoHandler updateTodoHandler) {
        this.updateTodoHandler = updateTodoHandler;
    }

    @PutMapping()
    public ResponseEntity<?> updateTodo(@PathVariable String id, @RequestBody UpdateTodoRequestDto entity) {
        try {
            this.updateTodoHandler.execute(id, entity);

            Map<String, Object> body = new HashMap<>();
            body.put("message", "Todo updated successfully");
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
