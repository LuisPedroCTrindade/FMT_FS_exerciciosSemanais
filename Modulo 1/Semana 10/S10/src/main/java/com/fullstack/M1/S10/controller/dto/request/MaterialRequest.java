package com.fullstack.M1.S10.controller.dto.request;

import com.fullstack.M1.S10.entity.AgendaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MaterialRequest {
    private Long id;
    private AgendaEntity agenda;
    private String descricao;
    private String arquivo;
}
