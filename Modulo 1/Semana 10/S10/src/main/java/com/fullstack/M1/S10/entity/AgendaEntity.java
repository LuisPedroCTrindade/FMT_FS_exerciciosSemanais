package com.fullstack.M1.S10.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="agenda")
@Data
@NoArgsConstructor
public class AgendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private AlunoEntity aluno;

    @ManyToOne
    @JoinColumn(name = "tutor_id", nullable = false)
    private TutorEntity tutor;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String tema;

    private String descricaoBreve;

    public AgendaEntity(Long id, AlunoEntity aluno, TutorEntity tutor, LocalDate data, String status, String tema, String descricaoBreve) {
        this.id = id;
        this.aluno = aluno;
        this.tutor = tutor;
        this.data = data;
        this.status = status;
        this.tema = tema;
        this.descricaoBreve = descricaoBreve;
    }

    public AgendaEntity(AlunoEntity aluno, TutorEntity tutor, LocalDate data, String status, String tema, String descricaoBreve) {
        this.aluno = aluno;
        this.tutor = tutor;
        this.data = data;
        this.status = status;
        this.tema = tema;
        this.descricaoBreve = descricaoBreve;
    }
}
