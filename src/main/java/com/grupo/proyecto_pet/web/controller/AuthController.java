package com.grupo.proyecto_pet.web.controller;

import com.grupo.proyecto_pet.business.service.UsuarioService;
import com.grupo.proyecto_pet.shared.constant.URLs;
import com.grupo.proyecto_pet.shared.dto.UsuarioDTO;
import com.grupo.proyecto_pet.shared.exception.EmailExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author Franco on 5/21/2017.
 */
@RestController
@RequestMapping(URLs.API.BASE_V1)
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UsuarioDTO create(@RequestBody UsuarioDTO resource) throws EmailExistsException {

        logger.info("Registrando usuario: {}", resource.toString());

        return usuarioService.register(resource);
    }


}