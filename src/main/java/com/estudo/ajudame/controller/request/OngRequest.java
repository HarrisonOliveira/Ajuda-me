package com.estudo.ajudame.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import model.Ong;

@AllArgsConstructor
@Getter
@Setter
public class OngRequest {

    @NotBlank(message = "O nome fantasia é obrigatório.")
    @Size(min = 3, max = 100, message = "O nome fantasia deve ter entre 3 e 100 caracteres.")
    private String nomeFantasia;

    @NotBlank(message = "O CNPJ é obrigatório.")
    @Pattern(
            regexp = "\\d{14}",
            message = "O CNPJ deve conter exatamente 14 dígitos numéricos (somente números)."
    )
    private String cnpj;

    public Ong ongDomain(){
        return new Ong(this.nomeFantasia, this.cnpj);
    }
}