package com.banco.sistema_bancario.dto.conta;

import com.banco.sistema_bancario.entity.TipoConta;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ContaRequestDTO {

    @NotBlank
    private String numeroConta;

    @NotNull
    private TipoConta tipoConta;

    @NotNull
    private UUID clienteId;
}