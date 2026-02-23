package com.banco.sistema_bancario.service;

import com.banco.sistema_bancario.dto.cliente.*;
import com.banco.sistema_bancario.entity.Cliente;
import com.banco.sistema_bancario.exception.BusinessException;
import com.banco.sistema_bancario.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteResponseDTO criar(ClienteRequestDTO dto) {

        if (repository.existsByCpf(dto.getCpf())) {
            throw new BusinessException("CPF já cadastrado.");
        }

        Cliente cliente = Cliente.builder()
                .nome(dto.getNome())
                .cpf(dto.getCpf())
                .email(dto.getEmail())
                .dataCriacao(LocalDateTime.now())
                .build();

        repository.save(cliente);

        return new ClienteResponseDTO(cliente);
    }
}