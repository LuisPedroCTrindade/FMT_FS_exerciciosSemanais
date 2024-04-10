package com.fullstack.M1.S10.service;

import com.fullstack.M1.S10.entity.AgendaEntity;
import com.fullstack.M1.S10.exception.NotFoundException;
import com.fullstack.M1.S10.repository.AgendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AgendaService {

    private final AgendaRepository agendaRepository;
    private final AlunoService alunoService;
    private final TutorService tutorService;

    public List<AgendaEntity> buscarTodos() {
        return agendaRepository.findAll();
    }
    
    public AgendaEntity buscarPorId(Long id) {
        return agendaRepository.findById(id).orElseThrow(() -> new NotFoundException("Agenda de ID " + id + " não encontrado."));
    }

    public AgendaEntity salvar(AgendaEntity agendaEntity) {
        agendaEntity.setId(null);

        return agendaRepository.save(agendaEntity);
    }

    public AgendaEntity atualizar(Long id, AgendaEntity agendaEntity) {
        AgendaEntity agendaAlterado = buscarPorId(id);

        agendaAlterado.setAluno(agendaEntity.getAluno());
        agendaAlterado.setTutor(agendaEntity.getTutor());
        agendaAlterado.setData(agendaEntity.getData());
        agendaAlterado.setStatus(agendaEntity.getStatus());
        agendaAlterado.setTema(agendaEntity.getTema());
        agendaAlterado.setDescricaoBreve(agendaEntity.getDescricaoBreve());

        return agendaRepository.save(agendaAlterado);
    }

    public void excluir(Long id) {
        AgendaEntity agendaEntity = buscarPorId(id);
        agendaRepository.delete(agendaEntity);
    }

    public List<AgendaEntity> buscarPorAluno(Long alunoId) {
        alunoService.buscarPorId(alunoId);
        return agendaRepository.findByAlunoIdOrderByData(alunoId);
    }

    public List<AgendaEntity> buscarPorTutor(Long tutorId) {
        tutorService.buscarPorId(tutorId);
        return agendaRepository.findByTutorIdOrderByData(tutorId);
    }

    public List<AgendaEntity> buscarProximosPorAluno(Long alunoId) {
        alunoService.buscarPorId(alunoId);
        return agendaRepository.findByAlunoIdAndDataGreaterThanOrderByData(alunoId, LocalDate.now());
    }

    public List<AgendaEntity> buscarProximosPorTutor(Long tutorId) {
        tutorService.buscarPorId(tutorId);
        return agendaRepository.findByTutorIdAndDataGreaterThanOrderByData(tutorId, LocalDate.now());
    }
}
