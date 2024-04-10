package edu.infnet.model.domain;

public class Aula {
    private int id;
    private Aluno aluno;
    private Professor professor;
    private String disciplina;

    public Aula(int id, Aluno aluno, Professor professor, String disciplina) {
        this.id = id;
        this.aluno = aluno;
        this.professor = professor;
        this.disciplina = disciplina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
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
}
