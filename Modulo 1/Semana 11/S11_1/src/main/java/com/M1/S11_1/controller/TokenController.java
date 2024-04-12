package com.M1.S11_1.controller;

import com.M1.S11_1.dto.request.LoginRequest;
import com.M1.S11_1.dto.response.LoginResponse;
import com.M1.S11_1.entity.PapelEntity;
import com.M1.S11_1.entity.UsuarioEntity;
import com.M1.S11_1.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class TokenController {

    private final UsuarioRepository usuarioRepository;

    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtEncoder jwtEncoder;

    private static long EXPIRACAO = 36000L;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> token(@RequestBody LoginRequest loginRequest) throws Exception {

        UsuarioEntity usuario = usuarioRepository.findByNomeUsuario(loginRequest.nomeUsuario())
                .orElseThrow(() -> new Exception("Erro ao logar (usuário não existe)"));

        if(usuario.isLoginCorrect(loginRequest, passwordEncoder)) {
            throw new Exception("Erro ao logar (senha incorreta)");
        }

        Instant now = Instant.now();

        String scope =
                usuario.getPapeis()
                        .stream()
                        .map(PapelEntity::getNomePapel)
                        .collect(Collectors.joining(""));

        JwtClaimsSet claims =
                JwtClaimsSet.builder()
                        .issuer("Semana11")
                        .issuedAt(now)
                        .expiresAt(now.plusSeconds(EXPIRACAO))
                        .subject(usuario.getId().toString())
                        .build();

        var valorJwt = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return ResponseEntity.ok(new LoginResponse(valorJwt, EXPIRACAO));
    }
}
