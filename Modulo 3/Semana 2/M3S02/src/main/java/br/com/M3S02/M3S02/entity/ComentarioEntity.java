package br.com.M3S02.M3S02.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comentarios")
public class ComentarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sugestao_id", nullable = false)
    private SugestaoEntity sugestao;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String texto;

    @Column(nullable = false)
    private Date dataEnvio;


    @PrePersist
    protected void onCreate() {
        dataEnvio = new Date();
    }
}