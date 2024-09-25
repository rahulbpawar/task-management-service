package com.example.task.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
public class TaskException extends RuntimeException {
    private int statusCode;
    private String errorCode;
    private String message;
}
