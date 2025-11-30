package com.estudo.ajudame.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ongs", uniqueConstraints = {
    @UniqueConstraint(columnNames = "cnpj")
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "id")
@Schema(description = "Representação de uma Organização Não Governamental (ONG)")
public class Ong {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único da ONG no banco de dados", example = "1")
    private Long id;
    
    @Column(name = "nome_fantasia", nullable = false, length = 100)
    @Schema(description = "Nome fantasia da ONG", example = "Instituto Aurora Social", required = true)
    private String nomeFantasia;
    
    @Column(name = "cnpj", nullable = false, unique = true, length = 14)
    @Schema(description = "CNPJ da ONG (14 dígitos numéricos)", example = "39458276000145", required = true)
    private String cnpj;
    
    @Column(name = "data_cadastro", nullable = false, updatable = false)
    @Schema(description = "Data e hora de cadastro da ONG no sistema", example = "2025-01-12T10:30:00")
    private LocalDateTime dataCadastro;
    
    @PrePersist
    protected void onCreate() {
        if (dataCadastro == null) {
            dataCadastro = LocalDateTime.now();
        }
    }
}
