package com.grupo.proyecto_pet.web.controller;

import com.grupo.proyecto_pet.business.service.LocalService;
import com.grupo.proyecto_pet.shared.constant.URLs;
import com.grupo.proyecto_pet.shared.dto.LocalDTO;
import com.grupo.proyecto_pet.shared.exception.LocalNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Franco on 5/21/2017.
 */
@RestController
@RequestMapping(URLs.API.LOCAL_V1)
public class LocalController {

    @Autowired
    private LocalService localService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<LocalDTO> findAll() {
        return localService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public LocalDTO findOne(@PathVariable("id") Long id) throws LocalNotFoundException {
        return localService.findOneById(id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public LocalDTO create(@RequestBody LocalDTO resource) {
        return localService.save(resource);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") Long id, @RequestBody LocalDTO resource) {
        resource.setId(id);
        localService.save(resource);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        localService.deleteById(id);
    }

}