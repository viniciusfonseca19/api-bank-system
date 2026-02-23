package com.banco.sistema_bancario.repository;

import com.banco.sistema_bancario.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

    boolean existsByCpf(String cpf);

    Optional<Cliente> findByCpf(String cpf);
}