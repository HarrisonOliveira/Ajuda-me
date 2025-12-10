package com.estudo.ajudame.controller;

import com.estudo.ajudame.controller.request.AtualizarStatusRequest;
import com.estudo.ajudame.controller.request.PontoColetaResquest;
import com.estudo.ajudame.domain.entity.PontoColeta;
import com.estudo.ajudame.service.PontoColetaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.jspecify.annotations.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ponto-coletas")
@Tag(name = "Ponto de Coleta", description = "API para cadastro de Ponto de Coleta")
public class PontoColetaController {

    private final PontoColetaService pontoColetaService;

    public PontoColetaController(PontoColetaService pontoColetaService) {
        this.pontoColetaService = pontoColetaService;
    }

    @PostMapping
    @Operation(summary = "Cadastrar novo Ponto de Coleta",
            description = "Cadastra um novo Ponto de Coleta para uma ONG")
    public ResponseEntity<PontoColeta> cadastrarPontoColeta(@Valid @RequestBody @NonNull PontoColetaResquest pontoColetaResquest) {
        PontoColeta PontoColetaCadastrado = this.pontoColetaService.cadastrarPontoColeta(pontoColetaResquest.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED).body(PontoColetaCadastrado);
    }

    @GetMapping
    @Operation(summary = "Listar todos os Pontos de Coleta",
            description = "Retorna uma lista com todos os Pontos de Coleta cadastrados")
    public ResponseEntity<List<PontoColeta>> listarTodosPontosColeta() {
        List<PontoColeta> pontosColeta = this.pontoColetaService.buscarTodosPontosColeta();
        return ResponseEntity.ok(pontosColeta);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca um ponto de coleta pelo ID", description = "Busca um ponto de coleta pelo ID")
    public PontoColeta buscaPontoColetaPeloId(@Valid @PathVariable("id") Long id){
        return this.pontoColetaService.buscarPontoColetaPeloId(id);
    }

    @GetMapping("/cidade/{cidade}")
    @Operation(summary = "Listar todos os Pontos de Coleta por Cidade",
            description = "Retorna uma lista com todos os Pontos de Coleta cadastrados na cidade informada")
    public ResponseEntity<List<PontoColeta>> buscarTodosPorCidade(@Valid @PathVariable("cidade") String cidade) {
        List<PontoColeta> pontosColeta = this.pontoColetaService.buscarTodosPorCidade(cidade);
        return ResponseEntity.ok(pontosColeta);
    }

    @GetMapping("/status/{status}")
    @Operation(summary = "Listar todos os Pontos de Coleta por Status",
            description = "Retorna uma lista com todos os Pontos de Coleta cadastrados com o status informado")
    public ResponseEntity<List<PontoColeta>> buscarTodosPorStatus (@Valid @PathVariable("status") String status) {
        List<PontoColeta> pontosColeta = this.pontoColetaService.buscarTodosPorStatus(status);
        return ResponseEntity.ok(pontosColeta);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar status de um ponto de coleta",
            description = "Atualiza o status de um ponto de coleta")
    public ResponseEntity<PontoColeta> atualizarStatus(@NotBlank @PathVariable Long id,
                                                       @RequestBody @Valid AtualizarStatusRequest request) {

        PontoColeta pontoColetaAtualizado = this.pontoColetaService.atualizarStatus(id, request.status());
        return ResponseEntity.ok(pontoColetaAtualizado);
    }

}
