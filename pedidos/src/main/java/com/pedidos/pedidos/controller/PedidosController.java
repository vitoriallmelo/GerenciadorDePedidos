package com.pedidos.pedidos.controller;

import com.pedidos.pedidos.dto.PedidosDTO;
import com.pedidos.pedidos.service.PedidosService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pedidos")
public class PedidosController {
    private final PedidosService pedidosService;

    @GetMapping
    public ResponseEntity<List<PedidosDTO>> listar() {
        return pedidosService.listarPedidos();
    }
    @PostMapping
    public ResponseEntity<PedidosDTO> salvar(@RequestBody PedidosDTO pedidosDTO) {
        return pedidosService.salvarPedidos(pedidosDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PedidosDTO> atualizar(@PathVariable Long id, @RequestBody PedidosDTO pedidosDTO) {
        return pedidosService.atualizarPedidos(id, pedidosDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        return pedidosService.deletarPedidos(id);
    }
}
