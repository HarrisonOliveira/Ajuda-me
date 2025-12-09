package com.estudo.ajudame.service;

import com.estudo.ajudame.domain.entity.PontoColeta;
import com.estudo.ajudame.exception.PontoColetaAlreadyExistsException;
import com.estudo.ajudame.repository.PontoColetaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PontoColetaService {
    private final PontoColetaRepository pontoColetaRepository;

    public PontoColetaService(PontoColetaRepository pontoColetaRepository) {
        this.pontoColetaRepository = pontoColetaRepository;
    }

    public PontoColeta cadastrarPontoColeta(PontoColeta pontoColeta) {
        log.info("Cadastrando Ponto de Coleta: {}", pontoColeta.toString());

        try {
            PontoColeta pontoSalvo = pontoColetaRepository.save(pontoColeta);
            log.info("Ponto de Coleta cadastrado com sucesso: {}", pontoSalvo.toString());
            return pontoSalvo;
        } catch (DataIntegrityViolationException e) {
            log.error("Erro ao cadastrar Ponto de Coleta: {}", e.getMessage());
            throw new PontoColetaAlreadyExistsException("Erro ao cadastrar Ponto de Coleta: Dados inválidos ou duplicados");
        }
    }
}
