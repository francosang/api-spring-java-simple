package com.grupo.proyecto_pet.shared.converter;

import com.grupo.proyecto_pet.persistence.entity.VerificationToken;
import com.grupo.proyecto_pet.persistence.entity.VerificationToken;
import com.grupo.proyecto_pet.shared.converter.base.Converter;
import com.grupo.proyecto_pet.shared.dto.VerificationTokenDTO;
import com.grupo.proyecto_pet.shared.dto.VerificationTokenDTO;
import org.springframework.stereotype.Component;

/**
 * @author Franco on 07/27/2017.
 */
@Component
public class VerificationTokenConverter extends Converter<VerificationTokenDTO, VerificationToken> {
    
    @Override
    public VerificationTokenDTO toDto(VerificationToken entity) {
        VerificationTokenDTO dto = new VerificationTokenDTO();
        dto.setId(entity.getId());
        dto.setExpirationDate(entity.getExpirationDate());
        dto.setToken(entity.getToken());
        return dto;
    }

}
