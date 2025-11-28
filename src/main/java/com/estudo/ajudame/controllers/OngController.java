package com.estudo.ajudame.controllers;

import com.estudo.ajudame.DTO.OngDTO;
import com.estudo.ajudame.entities.OngEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/ongs")
public class OngController {

    @PostMapping
    public ResponseEntity<OngDTO> cadastroOng(OngDTO ongDTO){
        OngEntity ongEntity = OngDTO.DTOToEntity(ongDTO);
        OngDTO ongDTOResponse = OngDTO.EntityToDTO(ongEntity);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(ongEntity.getId())
                .toUri();
        /**
         * A resposta é um ResponseEntity com status 201 Created, o corpo contendo o DTO da ONG criada
         * e o header Location apontando para a URL do novo recurso, usando o id da ONG
         */
        return ResponseEntity.created(uri).body(ongDTOResponse);
    }
}
