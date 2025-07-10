package com.organizer.todo.exception;

import com.organizer.todo.dto.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Error> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        Error error = new Error();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTitle("Resource Not Found");
        error.setType(request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<Error> handleConflictException(ConflictException ex, WebRequest request) {
        Error error = new Error();
        error.setStatus(HttpStatus.CONFLICT.value());
        error.setTitle("Conflict");
        error.setType(request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleGlobalException(Exception ex, WebRequest request) {
        Error error = new Error();
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setTitle("Internal Server Error");
        error.setType(request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}