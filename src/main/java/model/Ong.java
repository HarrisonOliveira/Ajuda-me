package model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Ong {
    private String nomeFantasia;
    private String cnpj;
    private String dataCadastro;

    public Ong(String nomeFantasia, String cnpj) {
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
    }
}
