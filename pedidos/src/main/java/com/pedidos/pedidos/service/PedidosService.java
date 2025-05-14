package com.pedidos.pedidos.service;

import com.pedidos.pedidos.dto.PedidosDTO;
import com.pedidos.pedidos.model.Pedidos;
import com.pedidos.pedidos.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidosService {
    @Autowired
    private PedidosRepository pedidosRepository;

    public PedidosDTO salvar (PedidosDTO pedidosDTO) {
        Pedidos pedidos = pedidosDTO.toEntity();
        pedidos = pedidosRepository.save(pedidos);
        return PedidosDTO.fromEntity(pedidos);
    }
    public List<PedidosDTO> listarPedidos () {
        return pedidosRepository.findAll().stream().map(PedidosDTO::fromEntity).collect(Collectors.toList());
    }
}
