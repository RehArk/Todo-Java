package net.vincent_clerc.todo.utils;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String,String>> handleNotNullException(MethodArgumentNotValidException exception) {

        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult().getAllErrors().forEach(objectError -> {
            String findName = ((FieldError)objectError).getField();
            String errorMessage = objectError.getDefaultMessage();
            errors.put(findName, errorMessage);
        });

        return ResponseEntity.badRequest().body(errors);

    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String,String>> handleNotFoundException(EntityNotFoundException exception) {

//        Map<String, String> errors = new HashMap<>();
//        errors.put("error", exception.getMessage());

        return ResponseEntity.notFound().build();

    }

}
