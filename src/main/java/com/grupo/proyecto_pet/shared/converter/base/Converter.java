package com.grupo.proyecto_pet.shared.converter.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Franco on 07/27/2017.
 */
public abstract class Converter<DTO, Entity> {
    
    public abstract DTO toDto(Entity entity);

    public List<DTO> toDto(List<Entity> entities) {
        List<DTO> dtos = new ArrayList<>();
        for (Entity entity : entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }

}
