package edu.infnet.model.service;

import edu.infnet.model.domain.Professor;

import java.util.*;

public class ProfessorService {
    private static Map<Integer, Professor> database = new HashMap<>();

    public ProfessorService(){
        Professor p = new Professor(1, "Elberth");
        Professor p2 = new Professor(2, "Matheus");
        database.put(1, p);
        database.put(2, p2);
    }

    public void adicionar(Professor professor){
        database.put(professor.getId(), professor);
    }
    public List<Professor> obterTodos(){
        return new ArrayList<>(database.values());
    }

    public Professor obterPorId(int id){
        return database.get(id);
    }

    public void atualizar(int id, Professor professor){
        database.put(professor.getId(), professor);
    }

    public Professor excluir(int id){
        return database.remove(id);
    }

}
