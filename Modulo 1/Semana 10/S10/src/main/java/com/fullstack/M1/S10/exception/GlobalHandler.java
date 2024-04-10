package com.fullstack.M1.S10.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handler(Exception e) {
        Erro erro = Erro.builder().codigoErro("500")
                .mensagemErro(e.getMessage()).build();
        return ResponseEntity.status(500).body(erro);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> handler(DataIntegrityViolationException e) {
        Erro erro = Erro.builder().codigoErro("400")
                .mensagemErro(e.getMessage()).build();
        return ResponseEntity.status(400).body(erro);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handler(NotFoundException e) {
        Erro erro = Erro.builder().codigoErro("404")
                .mensagemErro(e.getMessage()).build();
        return ResponseEntity.status(404).body(erro);
    }

    @ExceptionHandler(ServerErrorException.class)
    public ResponseEntity<?> handler(ServerErrorException e) {
        Erro erro = Erro.builder().codigoErro("500").mensagemErro(e.getMessage()).build();
        return ResponseEntity.status(500).body(erro);
    }
}
