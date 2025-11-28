package com.estudo.ajudame.service;

import com.estudo.ajudame.DTO.OngDTO;
import com.estudo.ajudame.entities.OngEntity;
import com.estudo.ajudame.repositorys.OngRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class OngService {

    private OngRespository repository;

    public OngService(OngRespository repository) {
        this.repository = repository;
    }

    public OngEntity cadastrarOng(OngDTO ongDTO){
        OngEntity ongEntity = OngDTO.DTOToEntity(ongDTO);
        repository.save(ongEntity);
        log.info("Ong cadastrada com sucesso! Ong ID: {}", ongEntity.getId());
        return ongEntity;
    }

}