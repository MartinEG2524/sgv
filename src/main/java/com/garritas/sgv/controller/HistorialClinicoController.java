package com.garritas.sgv.controller;

import com.garritas.sgv.model.HistorialClinico;
import com.garritas.sgv.service.HistorialClinicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historiales")
public class HistorialClinicoController {

    private final HistorialClinicoService service;

    public HistorialClinicoController(HistorialClinicoService service) {
        this.service = service;
    }

    @GetMapping
    public List<HistorialClinico> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistorialClinico> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public HistorialClinico guardar(@RequestBody HistorialClinico historial) {
        return service.guardar(historial);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
