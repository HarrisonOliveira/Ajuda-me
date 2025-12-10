package com.estudo.ajudame.service;

import com.estudo.ajudame.domain.entity.Ong;
import com.estudo.ajudame.domain.entity.PontoColeta;
import com.estudo.ajudame.exception.OngNotFoundException;
import com.estudo.ajudame.exception.PontoColetaAlreadyExistsException;
import com.estudo.ajudame.exception.PontoColetaNotFoundException;
import com.estudo.ajudame.repository.PontoColetaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class PontoColetaService {
    private final PontoColetaRepository pontoColetaRepository;
    private final OngService ongService;

    public PontoColetaService(PontoColetaRepository pontoColetaRepository, OngService ongService) {
        this.pontoColetaRepository = pontoColetaRepository;
        this.ongService = ongService;
    }

    public PontoColeta cadastrarPontoColeta(PontoColeta pontoColeta) {
        log.info("Buscando ONG por ID: {}", pontoColeta.getIdOng());
        Ong ongEncontrada =  this.ongService.buscarOngPorId(pontoColeta.getIdOng());

        if (ongEncontrada == null) {
            log.error("Não foi possível encontrar a ONG com o ID {}", pontoColeta.getIdOng());
            throw new OngNotFoundException("Não foi possível encontrar a ONG com ID informado");
        }

        log.info("Cadastrando Ponto de Coleta: {}", pontoColeta);
        try {
            PontoColeta pontoSalvo = this.pontoColetaRepository.save(pontoColeta);

            log.info("Ponto de Coleta cadastrado com sucesso: {}", pontoSalvo);
            return pontoSalvo;
        } catch (DataIntegrityViolationException e) {
            log.error("Erro ao cadastrar Ponto de Coleta: {}", e.getMessage());
            throw new PontoColetaAlreadyExistsException("Erro ao cadastrar Ponto de Coleta: Dados inválidos ou duplicados");
        }
    }
    @Transactional(readOnly = true)
    public List<PontoColeta> buscarTodosPontosColeta() {
        log.info("Buscando todos os pontos de coleta cadastrados");
        return this.pontoColetaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<PontoColeta> buscarTodosPorCidade (String cidade) {
        log.info("Buscando todos os pontos de coleta cadastrados na cidade {}", cidade);
        List<PontoColeta> pontosEncontrados = pontoColetaRepository.findAllByCidade(cidade);

        if (pontosEncontrados.isEmpty()) {
            log.error("Não foi encontrado nenhum ponto de coleta na cidade {}", cidade);
            throw new PontoColetaNotFoundException("Não foi encontrado nenhum ponto de coleta na cidade informada");
        }

        return pontosEncontrados;
    }
}
