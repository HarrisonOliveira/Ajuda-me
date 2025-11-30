package com.estudo.ajudame.service;

import com.estudo.ajudame.repository.OngRepository;
import com.estudo.ajudame.exception.OngAlreadyExistsException;
import com.estudo.ajudame.exception.OngNotFoundException;
import lombok.extern.slf4j.Slf4j;
import com.estudo.ajudame.domain.entity.Ong;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
public class OngService {
    
    private final OngRepository ongRepository;
    
    public OngService(OngRepository ongRepository) {
        this.ongRepository = ongRepository;
    }
    
    public Ong cadastrarOng(Ong ong) {
        log.info("Cadastrando ONG: {}", ong.getNomeFantasia());
        
        if (ongRepository.existsByCnpj(ong.getCnpj())) {
            log.warn("ONG com CNPJ {} já existe", ong.getCnpj());
            throw new OngAlreadyExistsException("ONG com CNPJ " + ong.getCnpj() + " já existe");
        }
        
        try {
            Ong ongSalva = ongRepository.save(ong);
            log.info("ONG cadastrada com sucesso: ID {}", ongSalva.getId());
            return ongSalva;
        } catch (DataIntegrityViolationException e) {
            log.error("Erro ao cadastrar ONG: violação de integridade", e);
            throw new OngAlreadyExistsException("Erro ao cadastrar ONG: dados inválidos ou duplicados");
        }
    }
    
    @Transactional(readOnly = true)
    public Ong buscarOngPorCnpj(String cnpj) {
        log.info("Buscando ONG por CNPJ: {}", cnpj);
        return ongRepository.findByCnpj(cnpj)
                .orElseThrow(() -> {
                    log.warn("ONG com CNPJ {} não encontrada", cnpj);
                    return new OngNotFoundException("ONG com CNPJ " + cnpj + " não encontrada");
                });
    }
    
    @Transactional(readOnly = true)
    public List<Ong> buscarTodas() {
        log.info("Buscando todas as ONGs");
        return ongRepository.findAll();
    }
    
    public void deletarOng(String cnpj) {
        log.info("Deletando ONG com CNPJ: {}", cnpj);
        
        if (!ongRepository.existsByCnpj(cnpj)) {
            log.warn("ONG com CNPJ {} não encontrada para deleção", cnpj);
            throw new OngNotFoundException("ONG com CNPJ " + cnpj + " não encontrada");
        }
        
        ongRepository.deleteByCnpj(cnpj);
        log.info("ONG com CNPJ {} deletada com sucesso", cnpj);
    }
    
    @Transactional(readOnly = true)
    public Ong buscarOngPorId(Long id) {
        log.info("Buscando ONG por ID: {}", id);
        return ongRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("ONG com ID {} não encontrada", id);
                    return new OngNotFoundException("ONG com ID " + id + " não encontrada");
                });
    }
}
