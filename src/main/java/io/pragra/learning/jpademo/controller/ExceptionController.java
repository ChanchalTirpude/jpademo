package io.pragra.learning.jpademo.controller;

import io.pragra.learning.jpademo.domain.ErrorResponse;
import io.pragra.learning.jpademo.exceptions.BookNot.BookNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;


@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(BookNotFoundException.class)
    protected ResponseEntity<Object> BookNotFound(BookNotFoundException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), LocalDateTime.now(),"Not Found in Database");
                return  new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
