package com.pedidos.pedidos.repository;

import com.pedidos.pedidos.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
