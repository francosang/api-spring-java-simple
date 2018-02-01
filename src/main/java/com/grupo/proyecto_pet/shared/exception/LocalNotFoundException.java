package com.grupo.proyecto_pet.shared.exception;

/**
 * @author Franco on 07/27/2017.
 */
public class LocalNotFoundException extends NotFoundException {

    public LocalNotFoundException() {
    }

    public LocalNotFoundException(String message) {
        super(message);
    }

    public LocalNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public LocalNotFoundException(Throwable cause) {
        super(cause);
    }

}
