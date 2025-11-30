package com.estudo.ajudame.repository;

import com.estudo.ajudame.domain.entity.Ong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OngRepository extends JpaRepository<Ong, Long> {
    
    Optional<Ong> findByCnpj(String cnpj);
    
    boolean existsByCnpj(String cnpj);
    
    void deleteByCnpj(String cnpj);
}
