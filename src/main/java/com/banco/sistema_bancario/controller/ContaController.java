package com.banco.sistema_bancario.controller;

import com.banco.dto.conta.*;
import com.banco.service.ContaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/contas")
@RequiredArgsConstructor
public class ContaController {

    private final ContaService service;

    @PostMapping
    public ResponseEntity<ContaResponseDTO> criarConta(
            @RequestBody @Valid ContaRequestDTO dto) {

        return ResponseEntity.status(201).body(service.criarConta(dto));
    }

    @PostMapping("/{numero}/deposito")
    public ResponseEntity<ContaResponseDTO> depositar(
            @PathVariable String numero,
            @RequestBody @Valid DepositoDTO dto) {

        return ResponseEntity.ok(service.depositar(numero, dto.getValor()));
    }

    @PostMapping("/{numero}/saque")
    public ResponseEntity<ContaResponseDTO> sacar(
            @PathVariable String numero,
            @RequestBody @Valid SaqueDTO dto) {

        return ResponseEntity.ok(service.sacar(numero, dto.getValor()));
    }

    @PostMapping("/transferencia")
    public ResponseEntity<Void> transferir(
            @RequestBody @Valid TransferenciaDTO dto) {

        service.transferir(dto);
        return ResponseEntity.ok().build();
    }
}