package com.grupo.proyecto_pet.shared.exception;

/**
 * @author Franco on 07/27/2017.
 */
public class EmailExistsException extends NotFoundException {

    public EmailExistsException() {
    }

    public EmailExistsException(String message) {
        super(message);
    }

    public EmailExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailExistsException(Throwable cause) {
        super(cause);
    }

}
