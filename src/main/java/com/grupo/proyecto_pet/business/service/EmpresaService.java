package com.grupo.proyecto_pet.business.service;

import com.grupo.proyecto_pet.persistence.entity.Empresa;
import com.grupo.proyecto_pet.persistence.repository.EmpresaRepository;
import com.grupo.proyecto_pet.shared.converter.EmpresaConverter;
import com.grupo.proyecto_pet.shared.dto.EmpresaDTO;
import com.grupo.proyecto_pet.shared.exception.EmpresaNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Franco on 5/21/2017.
 */
@Service
public class EmpresaService {

    private static final Logger logger = LoggerFactory.getLogger(EmpresaService.class);

    private static final EmpresaConverter CONVERTER = new EmpresaConverter();

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<EmpresaDTO> findAll() {
        return CONVERTER.toDto(empresaRepository.findAll());
    }

    public EmpresaDTO findOneById(Long id) throws EmpresaNotFoundException {
        logger.info("Obteniendo empresa, id: {}...", id);

        Empresa entity = empresaRepository.findOne(id);

        if (entity == null)
            throw new EmpresaNotFoundException();


        return CONVERTER.toDto(entity);
    }

    public EmpresaDTO save(EmpresaDTO resource) {
        logger.info("Guardando empresa, id: {}...", resource.getId());

        Empresa entity = empresaRepository.findOne(resource.getId());

        if (entity == null) {
            entity = new Empresa();
            entity.setFechaCreacion(new Date());
        } else {
            entity.setFechaEdicion(new Date());
        }

        entity.setDescripcion(resource.getDescripcion());
        entity.setDireccion(resource.getDireccion());
        entity.setNombre(resource.getNombre());
        entity.setRazonSocial(resource.getRazonSocial());
        entity.setRuc(resource.getRuc());

        return CONVERTER.toDto(empresaRepository.save(entity));
    }

    public void deleteById(Long id) {
        empresaRepository.delete(id);
    }
}
