package com.grupo.proyecto_pet.shared.validator;

import com.grupo.proyecto_pet.shared.annotation.PasswordMatches;
import com.grupo.proyecto_pet.shared.dto.UsuarioDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        UsuarioDTO user = (UsuarioDTO) obj;
        return user.getPassword().equals(user.getPassword());
    }

}