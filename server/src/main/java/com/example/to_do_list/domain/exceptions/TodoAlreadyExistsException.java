package com.example.to_do_list.domain.exceptions;

public class TodoAlreadyExistsException extends RuntimeException {
    public TodoAlreadyExistsException() {
        super("Todo already exists");
    }
}
