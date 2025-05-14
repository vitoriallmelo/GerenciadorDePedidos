package com.pedidos.pedidos.dto;

import com.pedidos.pedidos.model.Clientes;
import com.pedidos.pedidos.model.Pedidos;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidosDTO {
    private String descricao;
    private Clientes clientesDTO;

    public PedidosDTO(String descricao, Clientes clientes) {
        this.descricao = descricao;
        this.clientesDTO = clientes;
    }
    public Pedidos toEntity() {
        Pedidos pedidos = new Pedidos();
        pedidos.setDescricao(descricao);
        pedidos.setClientes(clientesDTO);
        return pedidos;
    }
    public static PedidosDTO fromEntity(Pedidos pedidos) {
        PedidosDTO dto = new PedidosDTO(pedidos.getDescricao(), pedidos.getClientes());
        return dto;
    }
}
