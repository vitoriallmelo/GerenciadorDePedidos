package com.pedidos.pedidos.model.DTO;

import com.pedidos.pedidos.model.entity.Cliente;

public class ClienteDTO {
    private Long id;
    private String nome;
    private String email;

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
    }
}
