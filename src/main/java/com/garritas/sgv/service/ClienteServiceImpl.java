package com.garritas.sgv.service;

import com.garritas.sgv.model.Cliente;
import com.garritas.sgv.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente guardar(Cliente cliente) {
    if (StringUtils.isBlank(cliente.getNombres())) {
        throw new IllegalArgumentException("El nombre no puede estar vacío");
    }
        return clienteRepository.save(cliente);
    }

    @Override
    public void eliminar(Long id) {
        clienteRepository.deleteById(id);
    }
}
