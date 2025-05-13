package com.pedidos.pedidos.model.DTO;

import com.pedidos.pedidos.model.entity.Pedidos;

public class PedidosDTO {
    private Long id;
    private String descricao;
    public PedidosDTO(Pedidos pedidos) {
        this.id = pedidos.getId();
        this.descricao = pedidos.getDescricao();
    }
}
