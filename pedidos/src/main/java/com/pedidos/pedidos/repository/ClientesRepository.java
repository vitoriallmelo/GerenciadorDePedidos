package com.pedidos.pedidos.repository;

import com.pedidos.pedidos.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {
}
