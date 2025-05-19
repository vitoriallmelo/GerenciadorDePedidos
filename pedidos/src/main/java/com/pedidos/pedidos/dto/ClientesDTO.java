package com.pedidos.pedidos.dto;

import com.pedidos.pedidos.model.Clientes;
import com.pedidos.pedidos.model.Pedidos;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClientesDTO {
    private String nome;
    private String email;
    private List<Pedidos> listaPedidosDTO;

    public ClientesDTO(String nome, String email, List<Pedidos> listaPedidosDTO) {
        this.nome = nome;
        this.email = email;
        this.listaPedidosDTO = listaPedidosDTO;
    }

    //DTO para entidade
    public Clientes toEntity() {
        Clientes clientes = new Clientes();
        clientes.setNome(nome);
        clientes.setEmail(email);
        clientes.setListaPedidos(listaPedidosDTO);
        return clientes;
    }
    // entidade para DTO
    public static ClientesDTO fromEntity(Clientes clientes) {
        return new ClientesDTO(clientes.getNome(), clientes.getEmail(), clientes.getListaPedidos());
    }
}
