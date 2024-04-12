package com.M1.S11_1.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "papel")
@Data
@NoArgsConstructor
public class PapelEntity implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "papel_id")
    private Long id;

    @Column(unique = true)
    private String nomePapel;

    @Override
    public String getAuthority() {
        return this.nomePapel;
    }
}
