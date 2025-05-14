package com.pedidos.pedidos.dto;

import com.pedidos.pedidos.model.Clientes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientesDTO {
    private String nome;
    private String email;

    public ClientesDTO(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    //DTO para entidade
    public Clientes toEntity() {
        Clientes clientes = new Clientes();
        clientes.setNome(nome);
        clientes.setEmail(email);
        return clientes;
    }
    // entidade para DTO
    public static ClientesDTO fromEntity(Clientes clientes) {
        return new ClientesDTO(clientes.getNome(), clientes.getEmail());
    }
}
