package com.pedidos.pedidos.service;

import com.pedidos.pedidos.dto.ClientesDTO;
import com.pedidos.pedidos.dto.PedidosDTO;
import com.pedidos.pedidos.model.Clientes;
import com.pedidos.pedidos.repository.ClientesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientesService {
    private final ClientesRepository clientesRepository;

    //get
    public ResponseEntity<List<ClientesDTO>> listarClientes() {
        return  ResponseEntity.ok(clientesRepository.findAll().stream().map(ClientesDTO::fromEntity).collect(Collectors.toList()));
    }
    //post
    public ResponseEntity<ClientesDTO> salvarClientes (ClientesDTO clientesDTO) {
        Clientes clientes = clientesDTO.toEntity();
        clientes = clientesRepository.save(clientes);
        return  ResponseEntity.ok(ClientesDTO.fromEntity(clientes));
    }
    //put
    public ResponseEntity<ClientesDTO> atualizarClientes(@PathVariable Long id,@RequestBody ClientesDTO clientesDTO) {
       Clientes clientes = clientesDTO.toEntity();
       if(!clientesRepository.existsById(id)) {
           return  ResponseEntity.notFound().build();
       }
       clientes.setId(id);
       clientes = clientesRepository.save(clientes);
       return  ResponseEntity.ok(ClientesDTO.fromEntity(clientes));
    }
    //delete
    public ResponseEntity<Void> deletarClientes(@PathVariable Long id) {
        if(!clientesRepository.existsById(id)) {
            return  ResponseEntity.notFound().build();
        }
        clientesRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
