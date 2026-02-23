package com.banco.sistema_bancario.dto.cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteRequestDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String cpf;

    @Email
    @NotBlank
    private String email;
}