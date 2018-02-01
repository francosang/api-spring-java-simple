package com.grupo.proyecto_pet.business.service;

import com.grupo.proyecto_pet.persistence.entity.Usuario;
import com.grupo.proyecto_pet.persistence.repository.UsuarioRepository;
import com.grupo.proyecto_pet.shared.converter.UsuarioConverter;
import com.grupo.proyecto_pet.shared.dto.UsuarioDTO;
import com.grupo.proyecto_pet.shared.exception.EmailExistsException;
import com.grupo.proyecto_pet.shared.exception.UsuarioNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Franco on 5/21/2017.
 */
@Service
public class UsuarioService {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    private static final UsuarioConverter CONVERTER = new UsuarioConverter();

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UsuarioDTO> findAll() {
        logger.info("Obteniendo todos los usuarios...");
        return CONVERTER.toDto(usuarioRepository.findAll());
    }

    public UsuarioDTO findOneById(Long aLong) throws UsuarioNotFoundException {
        logger.info("Buscar usuario por id: {}...", aLong);

        Usuario one = usuarioRepository.findOne(aLong);

        if (one == null)
            throw new UsuarioNotFoundException();

        return CONVERTER.toDto(one);
    }

    public UsuarioDTO register(UsuarioDTO resource) throws EmailExistsException {
        if (existsByEmail(resource.getEmail())) {
            throw new EmailExistsException("Correo en uso");
        }

        String encodedPass = passwordEncoder.encode(resource.getPassword());

        Usuario entity = new Usuario();
        entity.setEmail(resource.getEmail());
        entity.setApellido(resource.getApellido());
        entity.setNombre(resource.getNombre());
        entity.setEnabled(false);
        entity.setPassword(encodedPass);
        entity.setFechaCreacion(new Date());

        logger.info("Creando usuario: {}", entity);

        return CONVERTER.toDto(usuarioRepository.save(entity));
    }

    public UsuarioDTO save(UsuarioDTO resource) {
        logger.info("Guardando usuario, id: {}...", resource.getId());

        Usuario entity = usuarioRepository.findOne(resource.getId());

        if (entity == null) {
            entity = new Usuario();
            entity.setFechaCreacion(new Date());
        } else {
            entity.setFechaEdicion(new Date());
        }

        String encodedPass = passwordEncoder.encode(resource.getPassword());

        entity.setEmail(resource.getEmail());
        entity.setApellido(resource.getApellido());
        entity.setNombre(resource.getNombre());
        entity.setEnabled(false);
        entity.setPassword(encodedPass);
        entity.setFechaCreacion(new Date());;

        return CONVERTER.toDto(usuarioRepository.save(entity));
    }

    public void deleteById(Long aLong) {
        logger.info("Eliminar usuario por id: {}...", aLong);

        usuarioRepository.delete(aLong);
    }

    public UsuarioDTO findByEmail(String email) throws UsuarioNotFoundException {
        logger.info("Buscar usuario por email: {}...", email);

        Usuario one = usuarioRepository.findByEmail(email);

        if (one == null)
            throw new UsuarioNotFoundException();

        return CONVERTER.toDto(one);
    }

    public boolean existsByEmail(String email) {
        logger.info("Verificando existencia de mail: {}", email);

        return usuarioRepository.findByEmail(email) != null;
    }

}
