package com.example.to_do_list.domain.exceptions;

public class TodoNotFoundException extends RuntimeException {
    public TodoNotFoundException() {
        super("Todo not found");
    }
}
