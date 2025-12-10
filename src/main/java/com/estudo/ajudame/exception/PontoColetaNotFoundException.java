package com.estudo.ajudame.exception;

public class PontoColetaNotFoundException extends RuntimeException {
    public PontoColetaNotFoundException(String message) {
        super(message);
    }

    public PontoColetaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
