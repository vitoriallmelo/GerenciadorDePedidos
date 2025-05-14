package com.pedidos.pedidos.controller;

import com.pedidos.pedidos.dto.ClientesDTO;
import com.pedidos.pedidos.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
    @Autowired
    private ClientesService clientesService;

    @PostMapping
    public ResponseEntity<ClientesDTO> criar(@RequestBody ClientesDTO clientesDTO) {
        ClientesDTO salvo = clientesService.salvar(clientesDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }
    @GetMapping
    public List<ClientesDTO> listar() {
        return clientesService.listarClientes();
    }
}
