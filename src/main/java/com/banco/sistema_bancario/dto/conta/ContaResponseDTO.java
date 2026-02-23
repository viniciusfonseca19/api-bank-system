package com.banco.sistema_bancario.dto.conta;

import com.banco.sistema_bancario.entity.Conta;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class ContaResponseDTO {

    private String numeroConta;
    private BigDecimal saldo;
    private String tipoConta;
    private LocalDateTime dataCriacao;

    public ContaResponseDTO(Conta conta) {
        this.numeroConta = conta.getNumeroConta();
        this.saldo = conta.getSaldo();
        this.tipoConta = conta.getTipoConta().name();
        this.dataCriacao = conta.getDataCriacao();
    }
}