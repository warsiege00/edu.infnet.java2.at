package edu.infnet.model.domain;

import java.util.List;
import java.util.ArrayList;

public class Aula {
    private int id;
    private String disciplina;
    private List<Aluno> alunos;
    private Professor professor;

    public Aula(int id, String disciplina, List<Aluno> alunos) {
        this.id = id;
        this.disciplina = disciplina;
        this.alunos = alunos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Aluno> getAluno() {
        return alunos;
    }

    public void setAluno(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }
    public void definirProfessor(Professor professor) {
        this.professor = professor;
    }
}
