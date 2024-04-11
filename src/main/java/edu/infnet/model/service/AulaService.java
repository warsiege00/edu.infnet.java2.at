package edu.infnet.model.service;

import edu.infnet.model.domain.Aluno;
import edu.infnet.model.domain.Aula;
import edu.infnet.model.domain.Professor;
import edu.infnet.model.repository.AulaRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AulaService {

    private final AulaRepository aulaRepository;

    private final ProfessorService professorService;
    private final AlunoService alunoService;

    public AulaService(){
        this.aulaRepository = new AulaRepository();
        this.professorService = new ProfessorService();
        this.alunoService = new AlunoService();
    }
    public void criar(Aula aula){
        aulaRepository.create(aula);
    }
    public List<Aula> obterTodos(){
        return aulaRepository.findAll();
    }

    public Aula obterPorId(int id){
        return aulaRepository.findBy(id);
    }

    public void atualizar(int id, Aula aula){
        aulaRepository.update(aula);
    }

    public Aula excluir(int id){
        return aulaRepository.delete(id);
    }

    public boolean adicionarAluno(int alunoId, int aulaId){
        Aluno aluno = alunoService.obterPorId(alunoId);
        Aula aula = obterPorId(aulaId);
        if (aluno == null) {
            return false; // Professor não encontrado
        }

        if (aula == null) {
            return false; // Aula não encontrada
        }
        aula.adicionarAluno(aluno);
        aulaRepository.update(aula);
        return true;
    }

    public boolean definirProfessor(int professorId, int aulaId){
        Professor professor = professorService.obterPorId(professorId);
        Aula aula = obterPorId(aulaId);
        if (professor == null) {
            return false; // Professor não encontrado
        }

        if (aula == null) {
            return false; // Aula não encontrada
        }
        aula.definirProfessor(professor);
        aulaRepository.update(aula);
        return true;
    }

}
