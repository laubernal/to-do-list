package com.example.to_do_list.domain.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Todo {
    private UUID id;
    private String title;
    private boolean completed;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Todo(UUID id, String title) {
        this.id = id;
        this.title = title;
        this.completed = false;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public UUID id() {
        return this.id;
    }

    public String title() {
        return this.title;
    }

    public boolean completed() {
        return this.completed;
    }

    public LocalDateTime createdAt() {
        return this.createdAt;
    }

    public LocalDateTime updatedAt() {
        return this.updatedAt;
    }
}