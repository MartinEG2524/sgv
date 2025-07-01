package com.garritas.sgv.service;

import com.garritas.sgv.model.DetalleHistorialInventario;
import com.garritas.sgv.repository.DetalleHistorialInventarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleHistorialInventarioServiceImpl implements DetalleHistorialInventarioService {

    private final DetalleHistorialInventarioRepository repository;

    public DetalleHistorialInventarioServiceImpl(DetalleHistorialInventarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DetalleHistorialInventario> listar() {
        return repository.findAll();
    }

    @Override
    public Optional<DetalleHistorialInventario> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public DetalleHistorialInventario guardar(DetalleHistorialInventario detalle) {
        return repository.save(detalle);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
