package com.grupo.proyecto_pet.shared.exception;

/**
 * @author Franco on 07/27/2017.
 */
public class TokenExpiredException extends Exception {

    public TokenExpiredException() {
    }

    public TokenExpiredException(String message) {
        super(message);
    }

    public TokenExpiredException(String message, Throwable cause) {
        super(message, cause);
    }

    public TokenExpiredException(Throwable cause) {
        super(cause);
    }
}
