package com.M1.S11_1.service;

import com.M1.S11_1.dto.request.CriarCadernoRequest;
import com.M1.S11_1.dto.response.CadernoResponse;
import com.M1.S11_1.entity.CadernoEntity;
import com.M1.S11_1.entity.UsuarioEntity;
import com.M1.S11_1.error.NotFoundException;
import com.M1.S11_1.repository.CadernoRepository;
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
public class CadernoService {

    private final CadernoRepository cadernoRepository;
    private final JwtDecoder jwtDecoder;
    private final UsuarioRepository usuarioRepository;

    private Integer extrairUserId(String token) {
        return Integer.valueOf(jwtDecoder.decode(token).getClaims().get("subject").toString());
    }

    public List<CadernoResponse> buscarTodos(String token) {
        Integer idUsuario = extrairUserId(token);

        List<CadernoEntity> cadernoEntities = cadernoRepository.findAllByUsuario(idUsuario);

        List<CadernoResponse> cadernoResponseList = new ArrayList<>();

        cadernoEntities.forEach(t -> cadernoResponseList.add(
                new CadernoResponse(t.getId(), t.getNome())
        ));

        return cadernoResponseList;
    }

    public CadernoResponse buscarPorId(Integer id, String token) throws Exception {
        Integer idUsuario = extrairUserId(token);

        CadernoEntity cadernoEntity = cadernoRepository.findByUsuarioAndId(idUsuario, id)
                .orElseThrow(() -> new NotFoundException("Cadernos não encontrados."));

        return new CadernoResponse(cadernoEntity.getId(), cadernoEntity.getNome());
    }

    public CadernoResponse salvar(CriarCadernoRequest criarCadernoRequest, String token) {
        Integer idUsuario = extrairUserId(token);

        UsuarioEntity usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new NotFoundException("Caderno não encontrado."));

        CadernoEntity cadernoEntity = new CadernoEntity();
        cadernoEntity.setNome(criarCadernoRequest.nome());
        cadernoEntity.setUsuario(usuario);

        CadernoEntity cadernoSalvo = cadernoRepository.save(cadernoEntity);

        return new CadernoResponse(cadernoSalvo.getId(), cadernoSalvo.getNome());
    }

    public CadernoResponse atualizar(Integer id, CriarCadernoRequest criarCadernoRequest, String token) {
        Integer idUsuario = extrairUserId(token);

        CadernoEntity cadernoAtual = cadernoRepository.findByUsuarioAndId(idUsuario, id).orElseThrow(() -> new NotFoundException("Caderno não encontrado."));

        cadernoAtual.setNome(criarCadernoRequest.nome());

        CadernoEntity cadernoAtualizado = cadernoRepository.save(cadernoAtual);

        return new CadernoResponse(cadernoAtualizado.getId(), cadernoAtualizado.getNome());
    }

    public ResponseEntity<?> deletar(Integer id, String token) {
        if (!cadernoRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O caderno de ID " + id + " não foi localizado no sistema.");
        }
        cadernoRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Caderno de ID " + id + " excluído com sucesso.");
    }
}
