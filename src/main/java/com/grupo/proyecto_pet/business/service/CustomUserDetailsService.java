package com.grupo.proyecto_pet.business.service;

import com.grupo.proyecto_pet.persistence.entity.Rol;
import com.grupo.proyecto_pet.persistence.entity.Usuario;
import com.grupo.proyecto_pet.persistence.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Franco on 07/29/2017.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        logger.info("Intentando login con usuario: {}...", email);

        Usuario user = usuarioRepository.findByEmail(email);
        if (user == null) {
            logger.error("Usuario no encontrado por mail {}", email);
            throw new UsernameNotFoundException("Credenciales incorrectas");
        }

        user.setRoles(new ArrayList<>());
        user.getRoles().add(new Rol("USUARIO"));

        List<SimpleGrantedAuthority> roles = user.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getNombre())).collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), roles);
    }

}