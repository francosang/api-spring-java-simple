package com.grupo.proyecto_pet.shared.exception;

/**
 * @author Franco on 07/27/2017.
 */
public class NotFoundException extends ApplicactionException {

    private Object resourceId;

    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }

    public NotFoundException(Object resourceId) {
        this.resourceId = resourceId;
    }

    public NotFoundException(Object resourceId, String message) {
        super(message);
        this.resourceId = resourceId;
    }

    public NotFoundException(Object resourceId, String message, Throwable cause) {
        super(message, cause);
        this.resourceId = resourceId;
    }

    public NotFoundException(Object resourceId, Throwable cause) {
        super(cause);
        this.resourceId = resourceId;
    }

    public Object getResourceId() {
        return resourceId;
    }
}
