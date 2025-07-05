package com.example.to_do_list.infrastructure.controller.saveTodo;

import java.util.UUID;

public class saveTodoRequestDto {
    private UUID id;
    private String title;

    public saveTodoRequestDto(UUID id, String title) {
        this.id = id;
        this.title = title;
    }

    public UUID id() {
        return id;
    }

    public String title() {
        return title;
    }
}
