package com.trabalhoUninter.repository;

import com.trabalhoUninter.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
