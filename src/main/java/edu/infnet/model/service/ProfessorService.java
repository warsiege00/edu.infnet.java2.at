package edu.infnet.model.service;

import edu.infnet.model.domain.Professor;
import edu.infnet.model.repository.AulaRepository;
import edu.infnet.model.repository.ProfessorRepository;

import java.util.*;

public class ProfessorService {
    private final ProfessorRepository professorRepository;
    public ProfessorService(){
        this.professorRepository = new ProfessorRepository();
    }

    public void adicionar(Professor professor){
        professorRepository.create(professor);
    }
    public List<Professor> obterTodos(){
        return professorRepository.findAll();
    }

    public Professor obterPorId(int id){
        return professorRepository.findBy(id);
    }

    public void atualizar(int id, Professor professor){
        professorRepository.update(professor);
    }

    public Professor excluir(int id){
        return professorRepository.delete(id);
    }

}
