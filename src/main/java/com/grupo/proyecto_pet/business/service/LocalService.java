package com.grupo.proyecto_pet.business.service;

import com.grupo.proyecto_pet.persistence.entity.Empresa;
import com.grupo.proyecto_pet.persistence.entity.Local;
import com.grupo.proyecto_pet.persistence.repository.EmpresaRepository;
import com.grupo.proyecto_pet.persistence.repository.LocalRepository;
import com.grupo.proyecto_pet.shared.converter.LocalConverter;
import com.grupo.proyecto_pet.shared.dto.LocalDTO;
import com.grupo.proyecto_pet.shared.exception.LocalNotFoundException;
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
public class LocalService {

    private static final Logger logger = LoggerFactory.getLogger(LocalService.class);

    private static final LocalConverter CONVERTER = new LocalConverter();

    @Autowired
    private LocalRepository localRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    public List<LocalDTO> findAll() {
        return CONVERTER.toDto(localRepository.findAll());
    }

    public LocalDTO findOneById(Long aLong) throws LocalNotFoundException {
        Local one = localRepository.findOne(aLong);

        if (one == null)
            throw new LocalNotFoundException();

        return CONVERTER.toDto(one);
    }

    public LocalDTO save(LocalDTO resource) {
        logger.info("Guardando empresa, id: {}...", resource.getId());

        Local local = localRepository.findOne(resource.getId());

        if (local == null) {
            local = new Local();
            local.setFechaCreacion(new Date());
        } else {
            local.setFechaEdicion(new Date());
        }

        local.setEmpresa(new Empresa(resource.getEmpresa()));
        local.setNombre(resource.getNombre());
        local.setDescripcion(resource.getDescripcion());
        local.setDireccion(resource.getDireccion());
        local.setLatitud(resource.getLatitud());
        local.setLongitud(resource.getLongitud());

        return CONVERTER.toDto(localRepository.save(local));
    }

    public void deleteById(Long id) {
        localRepository.delete(id);
    }
}
