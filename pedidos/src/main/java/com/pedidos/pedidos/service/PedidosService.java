package com.pedidos.pedidos.service;

import com.pedidos.pedidos.dto.PedidosDTO;
import com.pedidos.pedidos.model.Pedidos;
import com.pedidos.pedidos.repository.PedidosRepository;
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
public class PedidosService {
    private final PedidosRepository pedidosRepository;

    //get
    public ResponseEntity<List<PedidosDTO>> listarPedidos () {
        return ResponseEntity.ok(pedidosRepository.findAll().stream().map(PedidosDTO::fromEntity).collect(Collectors.toList()));
    }
    //post
    public ResponseEntity<PedidosDTO> salvarPedidos (PedidosDTO pedidosDTO) {
        Pedidos pedidos = pedidosDTO.toEntity();
        pedidosRepository.save(pedidos);
        return ResponseEntity.ok(PedidosDTO.fromEntity(pedidos));
    }
    //put
    public ResponseEntity<PedidosDTO> atualizarPedidos (@PathVariable Long id, @RequestBody PedidosDTO pedidosDTO) {
        Pedidos pedidos = pedidosDTO.toEntity();
        if (!pedidosRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        pedidos.setId(id);
        pedidosRepository.save(pedidos);
        return ResponseEntity.ok(PedidosDTO.fromEntity(pedidos));
    }
    //delete
    public ResponseEntity<Void> deletarPedidos (@PathVariable Long id) {
        if (!pedidosRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        pedidosRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
