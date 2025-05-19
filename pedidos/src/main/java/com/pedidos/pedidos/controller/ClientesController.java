package com.pedidos.pedidos.controller;

import com.pedidos.pedidos.dto.ClientesDTO;
import com.pedidos.pedidos.dto.PedidosDTO;
import com.pedidos.pedidos.service.ClientesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClientesController {
    private final ClientesService clientesService;

    @GetMapping
    public ResponseEntity<List<ClientesDTO>> listar() {
        return clientesService.listarClientes();
    }
    @PostMapping
    public ResponseEntity<ClientesDTO> salvar(@RequestBody ClientesDTO clientesDTO) {
        return clientesService.salvarClientes(clientesDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ClientesDTO> atualizar(@PathVariable Long id, @RequestBody ClientesDTO clientesDTO) {
        return clientesService.atualizarClientes(id, clientesDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return clientesService.deletarClientes(id);
    }
}
