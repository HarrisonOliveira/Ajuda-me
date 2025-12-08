package com.estudo.ajudame.controller;

import com.estudo.ajudame.controller.request.OngRequest;
import com.estudo.ajudame.service.OngService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import com.estudo.ajudame.domain.entity.Ong;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/ongs")
@Tag(name = "ONGs", description = "API para gerenciamento de Organizações Não Governamentais")
public class OngController {

    private final OngService ongService;

    public OngController(OngService ongService) {
        this.ongService = ongService;
    }

    @PostMapping
    @Operation(summary = "Cadastrar nova ONG", description = "Cadastra uma nova ONG no sistema")
    public ResponseEntity<Ong> cadastrarOng(@Valid @RequestBody OngRequest ongRequest) {
        Ong ongCadastrada = this.ongService.cadastrarOng(ongRequest.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED).body(ongCadastrada);
    }

    @GetMapping
    @Operation(summary = "Listar todas as ONGs", description = "Retorna uma lista com todas as ONGs cadastradas")
    public ResponseEntity<List<Ong>> listarTodas() {
        List<Ong> ongs = this.ongService.buscarTodas();
        return ResponseEntity.ok(ongs);
    }

    @GetMapping("/cnpj/{cnpj}")
    @Operation(summary = "Buscar ONG por CNPJ", description = "Retorna uma ONG específica baseada no CNPJ fornecido")
    public ResponseEntity<Ong> buscarPorCnpj(
            @Parameter(description = "CNPJ da ONG a ser buscada", required = true)
            @PathVariable String cnpj) {
        Ong ong = this.ongService.buscarOngPorCnpj(cnpj);
        return ResponseEntity.ok(ong);
    }

    @GetMapping("/id/{id}")
    @Operation(summary = "Buscar ONG por ID", description = "Retorna uma ONG específica baseada no ID fornecido")
    public ResponseEntity<Ong> buscarPorId(
            @Parameter(description = "ID da ONG a ser buscada", required = true)
            @PathVariable Long id) {
        Ong ong = this.ongService.buscarOngPorId(id);
        return ResponseEntity.ok(ong);
    }

    @DeleteMapping("/cnpj/{cnpj}")
    @Operation(summary = "Deletar ONG por CNPJ", description = "Remove uma ONG do sistema baseada no CNPJ")
    public ResponseEntity<Void> deletarPorCnpj(
            @Parameter(description = "CNPJ da ONG a ser deletada", required = true)
            @PathVariable String cnpj) {
        this.ongService.deletarOng(cnpj);
        return ResponseEntity.noContent().build();
    }
}
