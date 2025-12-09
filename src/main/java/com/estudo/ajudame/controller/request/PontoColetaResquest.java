package com.estudo.ajudame.controller.request;

import com.estudo.ajudame.domain.entity.PontoColeta;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "DTO para requisição de cadastro de um Ponto de Coleta")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PontoColetaResquest {

    @Schema(description = "ID da ONG", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "ID de uma ONG é obrigatório")
    private Long idOng;

    @Schema(description = "Cidade ao qual o Ponto de Coleta está localizado")
    @NotBlank(message = "Nome da cidade deve ser informada")
    @Size(max = 50, message = "O nome da cidade deve ter no máximo 50 caracteres")
    private String cidade;

    @Schema(description = "Bairro ao qual o Ponto de Coleta está localizado")
    @NotBlank(message = "Nome do bairro deve ser informado")
    @Size(max = 50, message = "O nome do bairro deve ter no máximo 50 caracteres")
    private String bairro;

    @Schema(description = "Nome da Rua ao qual o Ponto de Coleta está localizado")
    @NotBlank(message = "Nome da rua deve ser informado")
    @Size(max = 100, message = "O nome da Rua deve ter no máximo 100 caracteres")
    private String logradouro;

    @Schema(description = "Número do edifício ao qual o Ponto de Coleta está localizado")
    @NotBlank(message = "Número do edifício deve ser informado")
    private String numero;

    @Schema(description = "CEP do Ponto de Coleta")
    @NotBlank(message = "CEP deve ser informado")
    @Pattern(regexp = "\\d{8}")
    private String cep;

    @Schema(description = "Complemento de endereço do Ponto de Coleta")
    @Size(max = 200, message = "O complemento deve ter no máximo 200 caracteres")
    private String complemento;

    public PontoColeta toEntity() {
        return PontoColeta.builder()
                .idOng(this.idOng)
                .cidade(this.cidade)
                .bairro(this.bairro)
                .logradouro(this.logradouro)
                .numero(this.numero)
                .cep(this.cep)
                .complemento(this.complemento)
                .build();
    }

}
