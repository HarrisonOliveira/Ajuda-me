package com.estudo.ajudame.exception;

public class OngAlreadyExistsException extends RuntimeException {
    
    public OngAlreadyExistsException(String message) {
        super(message);
    }
    
    public OngAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
