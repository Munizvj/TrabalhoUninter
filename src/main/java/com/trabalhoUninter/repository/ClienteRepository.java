package com.trabalhoUninter.repository;

import com.trabalhoUninter.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
