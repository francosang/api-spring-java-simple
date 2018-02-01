package com.grupo.proyecto_pet.shared.exception;

/**
 * @author Franco on 07/27/2017.
 */
public class UsuarioNotFoundException extends NotFoundException {

    public UsuarioNotFoundException() {
    }

    public UsuarioNotFoundException(String message) {
        super(message);
    }

    public UsuarioNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsuarioNotFoundException(Throwable cause) {
        super(cause);
    }

}
