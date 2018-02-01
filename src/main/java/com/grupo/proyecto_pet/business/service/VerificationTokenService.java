package com.grupo.proyecto_pet.business.service;

import com.grupo.proyecto_pet.persistence.entity.Usuario;
import com.grupo.proyecto_pet.persistence.entity.VerificationToken;
import com.grupo.proyecto_pet.persistence.repository.UsuarioRepository;
import com.grupo.proyecto_pet.persistence.repository.VerificationTokenRepository;
import com.grupo.proyecto_pet.shared.exception.TokenExpiredException;
import com.grupo.proyecto_pet.shared.exception.UsuarioNotFoundException;
import com.grupo.proyecto_pet.shared.exception.VerificationTokenNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.UUID;

/**
 * @author Franco on 07/29/2017.
 */
@Service
public class VerificationTokenService {

    private static final Logger logger = LoggerFactory.getLogger(VerificationTokenService.class);

    @Value("${app.token.expiration.minutes}")
    private int tokenExpirationMinutes;

    @Value("${app.token.expiration.hours}")
    private int tokenExpirationHours;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    public VerificationToken findByToken(String existingToken) throws VerificationTokenNotFoundException {
        VerificationToken verificationToken = verificationTokenRepository.findByToken(existingToken);
        if (verificationToken == null) {
            throw new VerificationTokenNotFoundException();
        }
        return verificationToken;
    }

    public VerificationToken createVerificationToken(Long id) throws UsuarioNotFoundException {
        logger.info("Creando token de verificacion, usuario: {}", id);

        Usuario usuario = usuarioRepository.findOne(id);
        String token = UUID.randomUUID().toString();

        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.HOUR, tokenExpirationHours);

        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUsuario(usuario);
        verificationToken.setExpirationDate(instance.getTime());
        return verificationTokenRepository.save(verificationToken);
    }

    public void verifyToken(String token) throws VerificationTokenNotFoundException, TokenExpiredException, UsuarioNotFoundException {
        logger.info("Verificando token {}...", token);

        VerificationToken verificationToken = findByToken(token);

        Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpirationDate().getTime() - cal.getTime().getTime()) <= 0) {
            throw new TokenExpiredException();
        }

        Usuario usuario = verificationToken.getUsuario();
        usuario.setEnabled(true);
        usuarioRepository.save(usuario);
    }

    public VerificationToken generateNewVerificationToken(String existingToken) throws VerificationTokenNotFoundException {
        VerificationToken verificationToken = findByToken(existingToken);
        String token = UUID.randomUUID().toString();

        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.MINUTE, tokenExpirationMinutes);

        verificationToken.setToken(token);
        verificationToken.setExpirationDate(instance.getTime());
        return verificationTokenRepository.save(verificationToken);
    }
}
