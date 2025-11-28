package com.estudo.ajudame.repositorys;

import com.estudo.ajudame.entities.OngEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OngRespository extends CrudRepository<OngEntity, Long> {
}
