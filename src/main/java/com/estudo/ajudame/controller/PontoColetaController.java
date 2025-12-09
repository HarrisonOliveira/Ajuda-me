package com.estudo.ajudame.controller;

import com.estudo.ajudame.controller.request.PontoColetaResquest;
import com.estudo.ajudame.domain.entity.Ong;
import com.estudo.ajudame.domain.entity.PontoColeta;
import com.estudo.ajudame.service.PontoColetaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ponto-coletas")
@Tag(name = "Ponto de Coleta", description = "API para cadastro de Ponto de Coleta")
public class PontoColetaController {

    private final PontoColetaService pontoColetaService;

    public PontoColetaController(PontoColetaService pontoColetaService) {
        this.pontoColetaService = pontoColetaService;
    }

    @PostMapping
    @Operation(summary = "Cadastrar novo Ponto de Coleta", description = "Cadastra um novo Ponto de Coleta para uma ONG")
    public ResponseEntity<PontoColeta> cadastrarPontoColeta(@Valid @RequestBody PontoColetaResquest pontoColetaResquest) {
        PontoColeta PontoColetaCadastrado = this.pontoColetaService.cadastrarPontoColeta(pontoColetaResquest.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED).body(PontoColetaCadastrado);
    }

}
