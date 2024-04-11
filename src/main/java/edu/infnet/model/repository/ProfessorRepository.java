package edu.infnet.model.repository;

import edu.infnet.model.domain.Professor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfessorRepository {
    private static Map<Integer, Professor> database = new HashMap<>();

    public void create(Professor professor){
        database.put(professor.getId(), professor);
    }
    public List<Professor> findAll(){
        return new ArrayList<>(database.values());
    }
    public Professor findBy(int id){
        return database.get(id);
    }

    public void update(Professor professor){
        database.put(professor.getId(), professor);
    }
    public Professor delete(int id){
        return database.remove(id);
    }

}
