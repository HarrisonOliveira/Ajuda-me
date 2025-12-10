package com.estudo.ajudame.exception;

public class PontoColetaAlreadyExistsException extends RuntimeException {

    public PontoColetaAlreadyExistsException(String message) {
        super(message);
    }

    public PontoColetaAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
