package com.estudo.ajudame.service;

import com.estudo.ajudame.repository.IOngRepository;
import lombok.extern.slf4j.Slf4j;
import model.Ong;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class OngService {
    private IOngRepository IOngRepository;
    public Ong cadastrarOng(Ong ong){
        this.IOngRepository.salvar(ong);
        System.out.printf("Entrou na camada de serviço: %s%n", ong);
        return new Ong(
                "Instituto Aurora Social",
                "39458276000145",
                "2025-01-12"
        );
    }
}
