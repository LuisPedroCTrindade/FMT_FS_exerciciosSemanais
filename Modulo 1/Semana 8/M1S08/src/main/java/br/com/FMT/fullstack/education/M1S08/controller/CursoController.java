package br.com.FMT.fullstack.education.M1S08.controller;

import br.com.FMT.fullstack.education.M1S08.model.AlunoModel;
import br.com.FMT.fullstack.education.M1S08.model.CursoModel;
import br.com.FMT.fullstack.education.M1S08.service.CursoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public List<CursoModel> get() {
        return cursoService.buscarTodos();
    }

    @PostMapping
    public CursoModel post(@RequestBody CursoModel curso) throws Exception {
        return cursoService.registrar(curso);
    }

    @PostMapping("{id}/add-aluno")
    public CursoModel post(@PathVariable Integer id, @RequestBody AlunoModel aluno) throws Exception {
        return cursoService.matricular(id, aluno.getId());
    }
}
