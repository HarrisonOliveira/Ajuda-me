package com.estudo.ajudame.controller;

import com.estudo.ajudame.controller.request.OngRequest;
import com.estudo.ajudame.service.OngService;
import jakarta.validation.Valid;
import model.Ong;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ongs")
public class OngController {

    private final OngService ongService;

    public OngController(OngService ongService) {
        this.ongService = ongService;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Ong> cadastroOng(@Valid @RequestBody OngRequest ongRequest) {
        Ong ongCadastrada = this.ongService.cadastrarOng(ongRequest.ongDomain());
        return ResponseEntity.status(HttpStatus.CREATED).body(ongCadastrada);
    }
}
