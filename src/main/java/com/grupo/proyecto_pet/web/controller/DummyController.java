package com.grupo.proyecto_pet.web.controller;

import com.grupo.proyecto_pet.business.service.UsuarioService;
import com.grupo.proyecto_pet.shared.dto.EmpresaDTO;
import com.grupo.proyecto_pet.shared.dto.LocalDTO;
import com.grupo.proyecto_pet.shared.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Franco on 5/21/2017.
 */
@RestController
@RequestMapping("/dummies")
public class DummyController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioService usuarioService;

    private AtomicLong id = new AtomicLong(1);

    @RequestMapping
    public String index() {
        return "/dummies";
    }

    @RequestMapping(value = "/local", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public LocalDTO getLocal() {
        LocalDTO local = new LocalDTO();
        local.setId(id.incrementAndGet());
        local.setDescripcion("Desc");
        local.setDireccion("Dir");
        local.setFechaCreacion(new Date());
        local.setFechaEdicion(new Date());
        local.setNombre("Nombre");
        return local;
    }

    @RequestMapping(value = "/empresa", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public EmpresaDTO getEmpresa() {
        EmpresaDTO empresa = new EmpresaDTO();
        empresa.setId(id.incrementAndGet());
        empresa.setRazonSocial("Razon");
        empresa.setRuc("Ruc");
        empresa.setDescripcion("Desc");
        empresa.setDireccion("Dir");
        empresa.setFechaCreacion(new Date());
        empresa.setFechaEdicion(new Date());
        empresa.setNombre("Nombre");
        return empresa;
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public UsuarioDTO getUsuario(@RequestParam(value = "pass") String pass,
                                 @RequestParam(value = "email") String email) {
        UsuarioDTO cuenta = new UsuarioDTO();
        cuenta.setId(id.incrementAndGet());
        cuenta.setEmail(email);
        cuenta.setPassword(passwordEncoder.encode(pass));
        return cuenta;
    }

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public List<UsuarioDTO> usuarios() {
        return usuarioService.findAll();
    }

}