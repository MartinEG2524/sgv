package com.garritas.sgv.service;

import com.garritas.sgv.model.Usuario;
import com.garritas.sgv.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private static final Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
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

    @Override
    public Usuario guardar(Usuario usuario) {
        log.info("Registrando usuario con código: {}", usuario.getCodigo());
        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }  
}
