package com.estudo.ajudame.domain.entity;

import com.estudo.ajudame.enums.PontoColetaStatus;
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
    @Schema(description = "ID único do Ponto de Coleta no banco de dados")
    private Long id;

    @Column(name = "id_ong", nullable = false)
    @Schema(description = "ID da ong ao qual o Ponto de Coleta pertence", requiredMode = Schema.RequiredMode.REQUIRED)
    @OneToMany
    private Long idOng;

    @Column(name = "cidade", nullable = false)
    @Schema(description = "Cidade do Ponto de Coleta", requiredMode = Schema.RequiredMode.REQUIRED)
    private String cidade;

    @Column(name = "bairro", nullable = false)
    @Schema(description = "Bairro do Ponto de Coleta", requiredMode = Schema.RequiredMode.REQUIRED)
    private String bairro;

    @Column(name = "logradouro", nullable = false)
    @Schema(description = "Logradouro do Ponto de Coleta", requiredMode = Schema.RequiredMode.REQUIRED)
    private String logradouro;

    @Column(name = "numero", nullable = false)
    @Schema(description = "Númera de endereço do Ponto de Coleta", requiredMode = Schema.RequiredMode.REQUIRED)
    private String numero;

    @Column(name = "cep", nullable = false)
    @Schema(description = "CEP do Ponto de Coleta", requiredMode = Schema.RequiredMode.REQUIRED)
    private String cep;

    @Column(name = "complemento")
    @Schema(description = "complemento do endereço do Ponto de Coleta")
    private String complemento;

    @ElementCollection
    @CollectionTable(name = "tb_ponto_coleta_itens", joinColumns = @JoinColumn(name = "ponto_coleta_id"))
    @Column(name = "tipo_doacao", nullable = false)
    @Schema(description = "Tipo de items a serem recebidos neste Ponto de Doação",
            example = "Limpeza, Higiene Pessoal, Não perecíveis",
            requiredMode = Schema.RequiredMode.REQUIRED)
    List<String> tipoDoacao;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    @Schema(description = "Status do Ponto de Coleta")
    PontoColetaStatus status;

    @PrePersist
    protected void onCreate() {
        status = PontoColetaStatus.ABERTO;
    }

}
