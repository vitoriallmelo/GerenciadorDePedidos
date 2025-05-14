package com.pedidos.pedidos.controller;

import com.pedidos.pedidos.dto.PedidosDTO;
import com.pedidos.pedidos.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class PedidosController {
    @Autowired
    private PedidosService pedidosService;

    @PostMapping
    public ResponseEntity<PedidosDTO> criar(@RequestBody PedidosDTO pedidosDTO) {
        PedidosDTO salvo = pedidosService.salvar(pedidosDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public List<PedidosDTO> listar() {
        return pedidosService.listarPedidos();
    }
}
