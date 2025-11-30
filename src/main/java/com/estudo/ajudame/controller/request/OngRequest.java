package com.estudo.ajudame.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.estudo.ajudame.domain.entity.Ong;

@Schema(description = "DTO para requisição de cadastro de ONG")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OngRequest {

    @Schema(description = "Nome fantasia da ONG", example = "Instituto Aurora Social", required = true)
    @NotBlank(message = "O nome fantasia é obrigatório.")
    @Size(min = 3, max = 100, message = "O nome fantasia deve ter entre 3 e 100 caracteres.")
    private String nomeFantasia;

    @Schema(description = "CNPJ da ONG (14 dígitos numéricos)", example = "39458276000145", required = true)
    @NotBlank(message = "O CNPJ é obrigatório.")
    @Pattern(
            regexp = "\\d{14}",
            message = "O CNPJ deve conter exatamente 14 dígitos numéricos (somente números)."
    )
    private String cnpj;

    @Schema(description = "Converte o DTO para entidade ONG")
    public Ong toEntity() {
        return Ong.builder()
                .nomeFantasia(this.nomeFantasia)
                .cnpj(this.cnpj)
                .build();
    }
}