package com.example.to_do_list.infrastructure.controllers.updateTodo;

public class UpdateTodoRequestDto {
    private String title;
    private Boolean completed;

    public UpdateTodoRequestDto(
            String title, Boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    public String title() {
        return title;
    }

    public Boolean completed() {
        return completed;
    }
}
