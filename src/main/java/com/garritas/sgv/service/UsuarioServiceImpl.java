package com.garritas.sgv.service;

import com.garritas.sgv.model.Usuario;
import com.garritas.sgv.repository.UsuarioRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    private static final Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Optional<Usuario> buscarPorCodigo(String codigo) {
        return usuarioRepository.findByCodigo(codigo);
    }

    public Usuario guardar(Usuario usuario) {
        // Encriptar la contraseña antes de guardarla
        String encryptedPassword = passwordEncoder.encode(usuario.getContrasena());
        log.info("Registrando usuario con código: ", usuario.getCodigo());
        usuario.setContrasena(encryptedPassword);  // Establecer la contraseña encriptada
        return usuarioRepository.save(usuario);  // Guardar el usuario con la contraseña encriptada
    }

    @Override
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }  
}
