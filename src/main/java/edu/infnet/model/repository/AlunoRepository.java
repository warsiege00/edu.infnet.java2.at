package edu.infnet.model.repository;

import edu.infnet.model.domain.Aluno;
import edu.infnet.model.domain.Professor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlunoRepository {
    private static Map<Integer, Aluno> database = new HashMap<>();

    public void create(Aluno aluno){
        database.put(aluno.getId(), aluno);
    }
    public List<Aluno> findAll(){
        return new ArrayList<>(database.values());
    }
    public Aluno findBy(int id){
        return database.get(id);
    }

    public void update(Aluno aluno){
        database.put(aluno.getId(), aluno);
    }
    public Aluno delete(int id){
        return database.remove(id);
    }

}
