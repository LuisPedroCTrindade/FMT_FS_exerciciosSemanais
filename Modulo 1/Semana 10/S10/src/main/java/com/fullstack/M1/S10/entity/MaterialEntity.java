package com.fullstack.M1.S10.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="material")
@Data
@NoArgsConstructor
public class MaterialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "agenda_id", nullable = false)
    private AgendaEntity agenda;

    private String descricao;

    @Column(nullable = false)
    private String arquivo;

    public MaterialEntity(Long id, AgendaEntity agenda, String descricao, String arquivo) {
        this.id = id;
        this.agenda = agenda;
        this.descricao = descricao;
        this.arquivo = arquivo;
    }

    public MaterialEntity(AgendaEntity agenda, String descricao, String arquivo) {
        this.agenda = agenda;
        this.descricao = descricao;
        this.arquivo = arquivo;
    }
}
