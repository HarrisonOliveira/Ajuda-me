package com.estudo.ajudame.domain.entity;

import com.estudo.ajudame.domain.entity.enums.PontoColetaStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity(name = "tb_ponto_coleta")
@Schema(description = "Entidade que representa um ponto de coleta")
public class PontoColeta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Schema(description = "ID única do Ponto de Coleta")
    Long id;

    @Column(name = "id_ong", nullable = false)
    @Schema(description = "ID da ong ao qual o Ponto de Coleta pertence")
    Long idOng;

    @Column(name = "cidade", nullable = false)
    @Schema(description = "Cidade do Ponto de Coleta")
    String cidade;

    @Column(name = "bairro", nullable = false)
    @Schema(description = "Bairro do Ponto de Coleta")
    String bairro;

    @Column(name = "logradouro", nullable = false)
    @Schema(description = "Logradouro do Ponto de Coleta")
    String logradouro;

    @Column(name = "numero", nullable = false)
    @Schema(description = "Númera de endereço do Ponto de Coleta")
    String numero;

    @Column(name = "complemento", nullable = true)
    @Schema(description = "complemento do endereço do Ponto de Coleta")
    String complemento;

    @Column(name = "cep", nullable = false)
    @Schema(description = "CEP do Ponto de Coleta")
    String cep;

    @ElementCollection
    @CollectionTable(name = "tb_ponto_coleta_itens", joinColumns = @JoinColumn(name = "ponto_coleta_id"))
    @Column(name = "tipo_doacao", nullable = false)
    @Schema(description = "Tipo de items a serem recebidos neste Ponto de Doação")
    List<String> tipoDoacao;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    @Schema(description = "Status do Ponto de Coleta")
    PontoColetaStatus status;

}
