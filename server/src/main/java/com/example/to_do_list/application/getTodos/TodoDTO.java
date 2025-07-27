package com.example.to_do_list.application.getTodos;

import java.time.LocalDateTime;
import java.util.UUID;

public record TodoDTO(
        UUID id,
        String title,
        boolean completed,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}
