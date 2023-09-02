package com.my.book.store.backend.exception;

public class EntityCreationException extends RuntimeException {
    public EntityCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
