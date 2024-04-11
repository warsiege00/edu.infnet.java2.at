package edu.infnet.model.service;

import edu.infnet.model.domain.Aluno;
import edu.infnet.model.domain.Professor;
import edu.infnet.model.repository.AlunoRepository;
import edu.infnet.model.repository.ProfessorRepository;

import java.util.List;

public class AlunoService {
    private final AlunoRepository alunoRepository;
    public AlunoService(){
        this.alunoRepository = new AlunoRepository();
    }

    public void adicionar(Aluno aluno){
        alunoRepository.create(aluno);
    }
    public List<Aluno> obterTodos(){
        return alunoRepository.findAll();
    }

    public Aluno obterPorId(int id){
        return alunoRepository.findBy(id);
    }

    public void atualizar(int id, Aluno aluno){
        alunoRepository.update(aluno);
    }

    public Aluno excluir(int id){
        return alunoRepository.delete(id);
    }

}
