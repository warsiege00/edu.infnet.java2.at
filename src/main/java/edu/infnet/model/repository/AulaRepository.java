package edu.infnet.model.repository;

import edu.infnet.model.domain.Aula;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AulaRepository {
    private static Map<Integer, Aula> database = new HashMap<>();

    public void create(Aula aula){
        database.put(aula.getId(), aula);
    }
    public List<Aula> findAll(){
        return new ArrayList<>(database.values());
    }
    public Aula findBy(int id){
        return database.get(id);
    }

    public void update(Aula aula){
        database.put(aula.getId(), aula);
    }
    public Aula delete(int id){
        return database.remove(id);
    }

}
