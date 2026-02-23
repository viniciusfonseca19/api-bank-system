package com.banco.sistema_bancario.service;

import com.banco.sistema_bancario.dto.conta.*;
import com.banco.sistema_bancario.entity.*;
import com.banco.sistema_bancario.exception.*;
import com.banco.sistema_bancario.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ContaService {

    private final ContaRepository contaRepository;
    private final ClienteRepository clienteRepository;

    @Transactional
    public ContaResponseDTO criarConta(ContaRequestDTO dto) {

        if (contaRepository.existsByNumeroConta(dto.getNumeroConta())) {
            throw new BusinessException("Número da conta já existe.");
        }

        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado."));

        Conta conta = Conta.builder()
                .numeroConta(dto.getNumeroConta())
                .saldo(BigDecimal.ZERO)
                .tipoConta(dto.getTipoConta())
                .cliente(cliente)
                .dataCriacao(LocalDateTime.now())
                .build();

        contaRepository.save(conta);

        return new ContaResponseDTO(conta);
    }

    @Transactional
    public ContaResponseDTO depositar(String numero, BigDecimal valor) {

        Conta conta = buscarConta(numero);

        conta.setSaldo(conta.getSaldo().add(valor));

        return new ContaResponseDTO(conta);
    }

    @Transactional
    public ContaResponseDTO sacar(String numero, BigDecimal valor) {

        Conta conta = buscarConta(numero);

        if (conta.getSaldo().compareTo(valor) < 0) {
            throw new BusinessException("Saldo insuficiente.");
        }

        conta.setSaldo(conta.getSaldo().subtract(valor));

        return new ContaResponseDTO(conta);
    }

    @Transactional
    public void transferir(TransferenciaDTO dto) {

        if (dto.getContaOrigem().equals(dto.getContaDestino())) {
            throw new BusinessException("Transferência para mesma conta não permitida.");
        }

        Conta origem = buscarConta(dto.getContaOrigem());
        Conta destino = buscarConta(dto.getContaDestino());

        if (origem.getSaldo().compareTo(dto.getValor()) < 0) {
            throw new BusinessException("Saldo insuficiente.");
        }

        origem.setSaldo(origem.getSaldo().subtract(dto.getValor()));
        destino.setSaldo(destino.getSaldo().add(dto.getValor()));
    }

    private Conta buscarConta(String numero) {
        return contaRepository.findByNumeroConta(numero)
                .orElseThrow(() -> new ResourceNotFoundException("Conta não encontrada."));
    }
}