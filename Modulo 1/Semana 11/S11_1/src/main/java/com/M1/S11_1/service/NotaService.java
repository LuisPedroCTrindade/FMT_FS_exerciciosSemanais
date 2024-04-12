package com.M1.S11_1.service;

import com.M1.S11_1.dto.request.CriarNotaRequest;
import com.M1.S11_1.dto.response.NotaResponse;
import com.M1.S11_1.entity.NotaEntity;
import com.M1.S11_1.entity.UsuarioEntity;
import com.M1.S11_1.error.NotFoundException;
import com.M1.S11_1.repository.NotaRepository;
import com.M1.S11_1.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotaService {

    private final NotaRepository notaRepository;
    private final JwtDecoder jwtDecoder;
    private final UsuarioRepository usuarioRepository;

    private Integer extrairUserId(String token) {
        return Integer.valueOf(jwtDecoder.decode(token).getClaims().get("subject").toString());
    }

    public List<NotaResponse> buscarTodos(String token) {
        Integer idUsuario = extrairUserId(token);

        List<NotaEntity> notaEntities = notaRepository.findAllByUsuario(idUsuario);

        List<NotaResponse> notaResponseList = new ArrayList<>();

        notaEntities.forEach(t -> notaResponseList.add(
                new NotaResponse(t.getId(), t.getTitulo())
        ));

        return notaResponseList;
    }

    public NotaResponse buscarPorId(Integer id, String token) throws Exception {
        Integer idUsuario = extrairUserId(token);

        NotaEntity notaEntity = notaRepository.findByUsuarioAndId(idUsuario, id)
                .orElseThrow(() -> new NotFoundException("Notas não encontradas."));

        return new NotaResponse(notaEntity.getId(), notaEntity.getTitulo());
    }

    public NotaResponse salvar(CriarNotaRequest criarNotaRequest, String token) {
        Integer idUsuario = extrairUserId(token);

        UsuarioEntity usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new NotFoundException("Nota não encontrada."));

        NotaEntity notaEntity = new NotaEntity();
        notaEntity.setTitulo(criarNotaRequest.titulo());
        notaEntity.setUsuario(usuario);

        NotaEntity notaSalvo = notaRepository.save(notaEntity);

        return new NotaResponse(notaSalvo.getId(), notaSalvo.getTitulo());
    }

    public NotaResponse atualizar(Integer id, CriarNotaRequest criarNotaRequest, String token) {
        Integer idUsuario = extrairUserId(token);

        NotaEntity notaAtual = notaRepository.findByUsuarioAndId(idUsuario, id).orElseThrow(() -> new NotFoundException("Nota não encontrada."));

        notaAtual.setTitulo(criarNotaRequest.titulo());

        NotaEntity notaAtualizado = notaRepository.save(notaAtual);

        return new NotaResponse(notaAtualizado.getId(), notaAtualizado.getTitulo());
    }

    public ResponseEntity<?> deletar(Integer id, String token) {
        if (!notaRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A nota de ID " + id + " não foi localizada no sistema.");
        }
        notaRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Nota de ID " + id + " excluída com sucesso.");
    }
}
