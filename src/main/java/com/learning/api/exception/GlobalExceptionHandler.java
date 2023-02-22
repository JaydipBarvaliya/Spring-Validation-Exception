package com.learning.api.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends Exception {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String, String> userNotFoundExceptionHandler(UserNotFoundException ex) {

        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", ex.getMessage());

        return errorMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ConstraintViolationException.class})
    public Map<String, String> handleConstraintViolation(ConstraintViolationException ex) {

        Map<String, String> errorMap = new HashMap<>();

        ex.getConstraintViolations().stream().forEach(constraintViolation ->
                errorMap.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage())
        );
        return errorMap;
    }





}
