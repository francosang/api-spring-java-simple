package com.grupo.proyecto_pet.shared.converter;

import com.grupo.proyecto_pet.persistence.entity.Usuario;
import com.grupo.proyecto_pet.shared.converter.base.Converter;
import com.grupo.proyecto_pet.shared.dto.UsuarioDTO;
import org.springframework.stereotype.Component;

/**
 * @author Franco on 07/27/2017.
 */
@Component
public class UsuarioConverter extends Converter<UsuarioDTO, Usuario> {
    
    @Override
    public UsuarioDTO toDto(Usuario entity) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setApellido(entity.getApellido());
        dto.setNombre(entity.getNombre());
        return dto;
    }

}
