package com.M1.S11_1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

    @GetMapping("/teste")
    public ResponseEntity<String> testar() {
        return new ResponseEntity<>("Teste", HttpStatus.OK);
    }
}
