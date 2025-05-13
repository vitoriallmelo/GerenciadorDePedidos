package com.pedidos.pedidos.repository;

import com.pedidos.pedidos.model.entity.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidosRepository extends JpaRepository<Pedidos,Long> {
}
