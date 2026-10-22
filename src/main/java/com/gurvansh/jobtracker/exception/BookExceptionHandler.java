package com.gurvansh.jobtracker.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BookExceptionHandler {

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<?> bookNotFoundException() {
    return ResponseEntity.ok("Book not found!");
  }

}
