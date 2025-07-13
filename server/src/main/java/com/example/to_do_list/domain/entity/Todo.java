package com.example.to_do_list.domain.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Todo {
    private UUID id;
    private String title;
    private boolean completed;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Todo(UUID id, String title, boolean completed, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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