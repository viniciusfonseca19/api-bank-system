package com.banco.sistema_bancario.dto.cliente;

import com.banco.sistema_bancario.entity.Cliente;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class ClienteResponseDTO {

    private UUID id;
    private String nome;
    private String cpf;
    private String email;
    private LocalDateTime dataCriacao;

    public ClienteResponseDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.dataCriacao = cliente.getDataCriacao();
    }
}