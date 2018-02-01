package com.grupo.proyecto_pet.shared.converter;

import com.grupo.proyecto_pet.persistence.entity.Empresa;
import com.grupo.proyecto_pet.shared.converter.base.Converter;
import com.grupo.proyecto_pet.shared.dto.EmpresaDTO;
import org.springframework.stereotype.Component;

/**
 * @author Franco on 07/27/2017.
 */
@Component
public class EmpresaConverter extends Converter<EmpresaDTO, Empresa> {

    @Override
    public EmpresaDTO toDto(Empresa entity) {
        EmpresaDTO dto = new EmpresaDTO();
        dto.setId(entity.getId());
        dto.setDescripcion(entity.getDescripcion());
        dto.setDireccion(entity.getDireccion());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setFechaEdicion(entity.getFechaEdicion());
        dto.setNombre(entity.getNombre());
        dto.setRazonSocial(entity.getRazonSocial());
        dto.setRuc(entity.getRuc());
        return dto;
    }

}
