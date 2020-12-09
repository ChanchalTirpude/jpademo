package io.pragra.learning.jpademo.exceptions.BookNot;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
    }
}
