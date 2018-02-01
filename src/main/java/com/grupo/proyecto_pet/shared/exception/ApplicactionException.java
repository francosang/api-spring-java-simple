package com.grupo.proyecto_pet.shared.exception;

/**
 * @author Franco on 07/27/2017.
 */
public class ApplicactionException extends Exception {

    public ApplicactionException() {
    }

    public ApplicactionException(String message) {
        super(message);
    }

    public ApplicactionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicactionException(Throwable cause) {
        super(cause);
    }
}
