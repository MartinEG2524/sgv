package com.garritas.sgv.service;

import com.garritas.sgv.model.Veterinario;

import java.util.List;
import java.util.Optional;

public interface VeterinarioService {
    List<Veterinario> listar();
    Optional<Veterinario> buscarPorId(Long id);
    Veterinario guardar(Veterinario veterinario);
    void eliminar(Long id);
}
