package com.fullstack.M1.S10.exception;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Erro {

    private String codigoErro;
    private String mensagemErro;

}
