package com.pedidos.pedidos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    @ManyToOne
    @JoinColumn(nullable = false, name = "clientes_id")
    @JsonIdentityReference(alwaysAsId = true) //receber clientes apenas com o id
    @JsonBackReference  //controle da serialização: não serializa
    private Clientes clientes;
}
