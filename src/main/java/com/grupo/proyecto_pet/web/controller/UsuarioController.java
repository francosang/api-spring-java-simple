package com.grupo.proyecto_pet.web.controller;

import com.grupo.proyecto_pet.business.service.UsuarioService;
import com.grupo.proyecto_pet.shared.constant.URLs;
import com.grupo.proyecto_pet.shared.dto.UsuarioDTO;
import com.grupo.proyecto_pet.shared.exception.UsuarioNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Franco on 5/21/2017.
 */
@RestController
@RequestMapping(URLs.API.USUARIO_V1)
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UsuarioDTO> findAll() {
        return usuarioService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public UsuarioDTO findOne(@PathVariable("id") Long id) throws UsuarioNotFoundException {
        return usuarioService.findOneById(id);
    }

    @RequestMapping(value = "/mail/{mail}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public UsuarioDTO findOne(@PathVariable("mail") String mail) throws UsuarioNotFoundException {
        return usuarioService.findByEmail(mail);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO create(@RequestBody UsuarioDTO resource) {
        return usuarioService.save(resource);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") Long id, @RequestBody UsuarioDTO resource) {
        resource.setId(id);
        usuarioService.save(resource);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        usuarioService.deleteById(id);
    }

}