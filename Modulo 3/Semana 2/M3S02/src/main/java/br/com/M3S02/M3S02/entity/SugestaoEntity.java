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
@Table(name = "sugestoes")
public class SugestaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(nullable = false)
    private Date dataEnvio;

    @Column(nullable = false)
    private Date dataAtualizacao;




    @PrePersist
    protected void onCreate() {
        dataEnvio = new Date();
        dataAtualizacao = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        dataAtualizacao = new Date();
    }
}
