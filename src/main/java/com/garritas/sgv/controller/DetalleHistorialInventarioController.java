package com.garritas.sgv.controller;

import com.garritas.sgv.model.DetalleHistorialInventario;
import com.garritas.sgv.service.DetalleHistorialInventarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalles")
public class DetalleHistorialInventarioController {

    private final DetalleHistorialInventarioService service;

    public DetalleHistorialInventarioController(DetalleHistorialInventarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<DetalleHistorialInventario> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleHistorialInventario> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DetalleHistorialInventario guardar(@RequestBody DetalleHistorialInventario detalle) {
        return service.guardar(detalle);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
