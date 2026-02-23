package com.banco.sistema_bancario.dto.conta;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DepositoDTO {

    @NotNull
    @DecimalMin(value = "0.01")
    private BigDecimal valor;
}