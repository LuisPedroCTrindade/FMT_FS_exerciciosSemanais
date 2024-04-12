package com.M1.S11_1.controller;

import com.M1.S11_1.dto.request.CadastrarUsuarioRequest;
import com.M1.S11_1.entity.PapelEntity;
import com.M1.S11_1.entity.UsuarioEntity;
import com.M1.S11_1.repository.PapelRepository;
import com.M1.S11_1.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
public class UsuarioController {

    private final BCryptPasswordEncoder passwordEncoder;

    private final UsuarioRepository usuarioRepository;
    private final PapelRepository papelRepository;

    @PostMapping("/cadastro")
    public ResponseEntity<String> novoUsuario(@RequestBody CadastrarUsuarioRequest cadastrarUsuarioRequest) throws Exception {

        PapelEntity papelEntity = papelRepository.findByNome("Usuario").get();

        Boolean usuarioExistente = usuarioRepository.findByNomeUsuario(cadastrarUsuarioRequest.nomeUsuario())
                .isPresent();

        if(usuarioExistente) {
            throw new Exception("Usuário já existe.");
        }

        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setNomeUsuario(cadastrarUsuarioRequest.nomeUsuario());
        usuario.setSenha(passwordEncoder.encode(cadastrarUsuarioRequest.senha()).toString());
        usuario.setPapeis(Set.of(papelEntity));

        usuarioRepository.save(usuario);

        return new ResponseEntity<>("Usuário criado.", HttpStatus.CREATED);
    }

}
