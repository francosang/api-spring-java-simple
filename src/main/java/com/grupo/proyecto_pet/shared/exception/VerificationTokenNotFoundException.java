package com.grupo.proyecto_pet.shared.exception;

/**
 * @author Franco on 07/27/2017.
 */
public class VerificationTokenNotFoundException extends NotFoundException {

    public VerificationTokenNotFoundException() {
    }

    public VerificationTokenNotFoundException(String message) {
        super(message);
    }

    public VerificationTokenNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public VerificationTokenNotFoundException(Throwable cause) {
        super(cause);
    }

    public VerificationTokenNotFoundException(Object resourceId) {
        super(resourceId);
    }

    public VerificationTokenNotFoundException(Object resourceId, String message) {
        super(resourceId, message);
    }

    public VerificationTokenNotFoundException(Object resourceId, String message, Throwable cause) {
        super(resourceId, message, cause);
    }

    public VerificationTokenNotFoundException(Object resourceId, Throwable cause) {
        super(resourceId, cause);
    }
}
