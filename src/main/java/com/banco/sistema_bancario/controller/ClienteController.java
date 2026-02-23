package com.banco.sistema_bancario.controller;

import com.banco.sistema_bancario.dto.cliente.*;
import com.banco.sistema_bancario.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> criar(
            @RequestBody @Valid ClienteRequestDTO dto) {

        return ResponseEntity.status(201).body(service.criar(dto));
    }
}