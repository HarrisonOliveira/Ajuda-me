package com.estudo.ajudame.repository;

import com.estudo.ajudame.domain.entity.PontoColeta;
import com.estudo.ajudame.enums.PontoColetaStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PontoColetaRepository extends JpaRepository<PontoColeta, Long> {

    List<PontoColeta> findAllByCidade(String cidade);
    List<PontoColeta> findAllByStatus(String status);
}
