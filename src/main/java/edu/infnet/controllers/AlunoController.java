package edu.infnet.controllers;

import com.google.gson.Gson;
import edu.infnet.model.domain.Aluno;
import edu.infnet.model.domain.Professor;
import edu.infnet.model.service.AlunoService;
import edu.infnet.model.service.ProfessorService;

import static spark.Spark.*;

public class AlunoController implements Controller {
    private AlunoService alunoService;
    private static Gson gson = new Gson();

    public AlunoController(){
        this.alunoService = new AlunoService();
    }
    @Override
    public void registerRoutes(){

        path("/api", () -> {
            post("/alunos", (request, response) -> {
                Aluno novoAluno = gson.fromJson(request.body(), Aluno.class);
                alunoService.adicionar(novoAluno);

                response.status(201);
                return "Aluno adicionado com sucesso.";
            });

            get("/alunos", (request, response) -> {
                response.type("application/json");
                return gson.toJson(alunoService.obterTodos());
            });

            get("/alunos/:id", (request, response) -> {
                response.type("application/json");
                int id = Integer.parseInt(request.params(":id"));
                Aluno aluno = alunoService.obterPorId(id);

                if (aluno != null) {
                    return new Gson().toJson(aluno);
                } else {
                    response.status(404);
                    return "Aluno não encontrado.";
                }
           });

            delete("/professores/:id", (request, response) -> {
                int id = Integer.parseInt(request.params(":id"));
                Aluno removido = alunoService.excluir(id);

                if (removido != null) {
                    response.status(204);
                    return "Professor removido com sucesso.";
                } else {
                    response.status(404);
                    return "Professor não encontrado.";
                }

            });
        });
    }

}
