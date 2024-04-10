package com.fullstack.M1.S10.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="aluno")
@Data
@NoArgsConstructor
public class AlunoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    //CONSTRUTORES

    public AlunoEntity(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public AlunoEntity(String nome) {
        this.nome = nome;
    }
}
