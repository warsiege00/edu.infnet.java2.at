package edu.infnet.model.service;

import edu.infnet.model.domain.Aluno;
import edu.infnet.model.domain.Aula;
import edu.infnet.model.domain.Professor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AulaService {
    private static Map<Integer, Aula> database = new HashMap<>();

    public AulaService(){
        Professor p2 = new Professor(2, "Elberth");
        Aluno a2 = new Aluno(1, "Matheus");
        Aula a = new Aula(1, a2,p2, "Matematica" );

        database.put(1, a);
    }

    public void adicionar(Aula aula){
        database.put(aula.getId(), aula);
    }
    public List<Aula> obterTodos(){
        return new ArrayList<>(database.values());
    }

    public Aula obterPorId(int id){
        return database.get(id);
    }

    public void atualizar(int id, Aula aula){
        database.put(aula.getId(), aula);
    }

    public Aula excluir(int id){
        return database.remove(id);
    }

}
