package com.grupo.proyecto_pet.shared.exception;

/**
 * @author Franco on 07/27/2017.
 */
public class EmpresaNotFoundException extends NotFoundException {

    public EmpresaNotFoundException() {
    }

    public EmpresaNotFoundException(String message) {
        super(message);
    }

    public EmpresaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmpresaNotFoundException(Throwable cause) {
        super(cause);
    }

}
