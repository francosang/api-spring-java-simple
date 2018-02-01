package com.grupo.proyecto_pet.web.controller;

import com.grupo.proyecto_pet.business.service.EmpresaService;
import com.grupo.proyecto_pet.shared.constant.URLs;
import com.grupo.proyecto_pet.shared.dto.EmpresaDTO;
import com.grupo.proyecto_pet.shared.exception.EmpresaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Franco on 5/21/2017.
 */
@RestController
@RequestMapping(URLs.API.EMPRESA_V1)
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmpresaDTO> findAll() {
        return empresaService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public EmpresaDTO findOne(@PathVariable("id") Long id) throws EmpresaNotFoundException {
        return empresaService.findOneById(id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public EmpresaDTO create(@RequestBody EmpresaDTO resource) {
        return empresaService.save(resource);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@PathVariable("id") Long id, @RequestBody EmpresaDTO resource) {
        resource.setId(id);
        empresaService.save(resource);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        empresaService.deleteById(id);
    }

}