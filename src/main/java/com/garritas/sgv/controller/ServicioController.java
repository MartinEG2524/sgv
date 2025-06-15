package com.garritas.sgv.controller;

import com.garritas.sgv.model.Servicio;
import com.garritas.sgv.service.ServicioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/servicios")
public class ServicioController {
    private final ServicioService service;
    public ServicioController(ServicioService service) { this.service = service; }

    @GetMapping public List<Servicio> listar() { return service.listar(); }
    @GetMapping("/{id}") public ResponseEntity<Servicio> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping public Servicio guardar(@RequestBody Servicio servicio) { return service.guardar(servicio); }
    @DeleteMapping("/{id}") public void eliminar(@PathVariable Long id) { service.eliminar(id); }
}
