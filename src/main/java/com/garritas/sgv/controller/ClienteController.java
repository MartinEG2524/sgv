package com.garritas.sgv.controller;

import com.garritas.sgv.model.Cliente;
import com.garritas.sgv.service.ClienteService;
import com.garritas.sgv.util.ClienteReporteService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    private final ClienteReporteService clienteReporteService;

    public ClienteController(ClienteService clienteService, ClienteReporteService clienteReporteService) {
    this.clienteService = clienteService;
    this.clienteReporteService = clienteReporteService;
    }

    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cliente guardar(@RequestBody Cliente cliente) {
        return clienteService.guardar(cliente);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        clienteService.eliminar(id);
    }

    @GetMapping("/exportar-excel")
    public ResponseEntity<byte[]> exportarExcel() {
        try {
            List<Cliente> clientes = clienteService.listar();
            InputStream excel = clienteReporteService.exportClientes(clientes);
            byte[] contenido = excel.readAllBytes();

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment; filename=clientes.xlsx");

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(contenido);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
