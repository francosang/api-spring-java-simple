package com.grupo.proyecto_pet.shared.converter;

import com.grupo.proyecto_pet.persistence.entity.Local;
import com.grupo.proyecto_pet.shared.converter.base.Converter;
import com.grupo.proyecto_pet.shared.dto.LocalDTO;
import org.springframework.stereotype.Component;

/**
 * @author Franco on 07/27/2017.
 */
@Component
public class LocalConverter extends Converter<LocalDTO, Local> {
    
    @Override
    public LocalDTO toDto(Local entity) {
        LocalDTO dto = new LocalDTO();
        dto.setId(entity.getId());
        dto.setFechaEdicion(entity.getFechaEdicion());
        dto.setLongitud(entity.getLongitud());
        dto.setLatitud(entity.getLatitud());
        dto.setDescripcion(entity.getDescripcion());
        dto.setDireccion(entity.getDireccion());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setNombre(entity.getNombre());
        dto.setEmpresa(entity.getEmpresa().getId());
        return dto;
    }

}
