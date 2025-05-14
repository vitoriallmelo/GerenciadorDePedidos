package com.pedidos.pedidos.service;

import com.pedidos.pedidos.dto.ClientesDTO;
import com.pedidos.pedidos.model.Clientes;
import com.pedidos.pedidos.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientesService {
    @Autowired
    private ClientesRepository clientesRepository;

    public ClientesDTO salvar (ClientesDTO clientesDTO) {
        Clientes clientes = clientesDTO.toEntity();
        clientes = clientesRepository.save(clientes);
        return ClientesDTO.fromEntity(clientes);
    }
    public List<ClientesDTO> listarClientes() {
        return clientesRepository.findAll().stream().map(ClientesDTO::fromEntity).collect(Collectors.toList());
    }
}
