package com.estudo.ajudame.repository;

import com.estudo.ajudame.domain.entity.PontoColeta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PontoColetaRepository extends CrudRepository<PontoColeta, Long> {
}
