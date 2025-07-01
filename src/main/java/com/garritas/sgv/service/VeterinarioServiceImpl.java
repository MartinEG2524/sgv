package com.garritas.sgv.service;

import com.garritas.sgv.model.Veterinario;
import com.garritas.sgv.repository.VeterinarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.google.common.base.Preconditions;

@Service
public class VeterinarioServiceImpl implements VeterinarioService {

    private final VeterinarioRepository veterinarioRepository;

    public VeterinarioServiceImpl(VeterinarioRepository veterinarioRepository) {
        this.veterinarioRepository = veterinarioRepository;
    }

    @Override
    public List<Veterinario> listar() {
        return veterinarioRepository.findAll();
    }

    @Override
    public Optional<Veterinario> buscarPorId(Long id) {
        return veterinarioRepository.findById(id);
    }

    @Override
    public Veterinario guardar(Veterinario veterinario) {
        Preconditions.checkNotNull(veterinario.getNombres(), "El nombre no puede ser null");
        return veterinarioRepository.save(veterinario);
    }

    @Override
    public void eliminar(Long id) {
        veterinarioRepository.deleteById(id);
    }
}
