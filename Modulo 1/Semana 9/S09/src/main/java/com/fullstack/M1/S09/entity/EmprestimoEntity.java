package com.fullstack.M1.S09.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="emprestimo")
@Data
@NoArgsConstructor

public class EmprestimoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private LivroEntity livroId;

    @ManyToOne
    @JoinColumn(name = "membro_id")
    private MembroEntity membroId;

    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    //CONSTRUTORES

    public EmprestimoEntity(Long id, LivroEntity livroId, MembroEntity membroId, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.id = id;
        this.livroId = livroId;
        this.membroId = membroId;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public EmprestimoEntity(LivroEntity livroId, MembroEntity membroId, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.livroId = livroId;
        this.membroId = membroId;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }
}
