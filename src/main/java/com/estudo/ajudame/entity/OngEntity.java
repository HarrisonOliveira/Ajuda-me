//package com.estudo.ajudame.entities;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//
//@Entity
//@Table(name = "tb_ong")
//@AllArgsConstructor
//@NoArgsConstructor
//@Setter
//@Getter
//@Builder
//public class OngEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ong")
//    @SequenceGenerator(name = "seq_ong", sequenceName = "sq_ong")
//    private Long id;
//
//    @Column(nullable = false)
//    private String nomeFantasia;
//
//    @Column(nullable = false)
//    private String cnpj;
//}
