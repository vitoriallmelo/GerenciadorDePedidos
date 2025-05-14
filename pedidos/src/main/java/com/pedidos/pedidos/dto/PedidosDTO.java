package com.pedidos.pedidos.dto;

import com.pedidos.pedidos.model.Pedidos;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidosDTO {
    private String descricao;

    public PedidosDTO(String descricao) {
        this.descricao = descricao;
    }
    public Pedidos toEntity() {
        Pedidos pedidos = new Pedidos();
        pedidos.setDescricao(descricao);
        return pedidos;
    }
    public static PedidosDTO fromEntity(Pedidos pedidos) {
        return new PedidosDTO(pedidos.getDescricao());
    }
}
