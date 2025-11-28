package com.estudo.ajudame.DTO;

import com.estudo.ajudame.entities.OngEntity;

public record OngDTO(String nomeFantasia, String cnpj) {

    public static OngDTO EntityToDTO(OngEntity ongEntity) {
        return new OngDTO(
                ongEntity.getNomeFantasia(),
                ongEntity.getCnpj());
    }

    public static OngEntity DTOToEntity(OngDTO ongDTO) {
        new OngEntity();
        return OngEntity.builder()
                .nomeFantasia(ongDTO.nomeFantasia())
                .cnpj(ongDTO.cnpj())
                .build();
    }
}
