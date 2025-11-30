package com.estudo.ajudame.exception;

public class OngNotFoundException extends RuntimeException {
    
    public OngNotFoundException(String message) {
        super(message);
    }
    
    public OngNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
