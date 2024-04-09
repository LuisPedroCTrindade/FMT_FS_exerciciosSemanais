package com.fullstack.M1.S09.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="visitante")
@Data
@NoArgsConstructor

public class VisitanteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String telefone;

    //CONSTRUTORES

    public VisitanteEntity(Long id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public VisitanteEntity(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }
}
