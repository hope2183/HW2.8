package com.example.hw2_8;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeBookIsEmptyException extends RuntimeException {
    public EmployeeBookIsEmptyException(String message) {
        super(message);
    }
}
