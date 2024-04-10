package edu.infnet.controllers;
import edu.infnet.model.domain.Professor;
import edu.infnet.model.service.ProfessorService;
import com.google.gson.Gson;

import static spark.Spark.*;
public class ProfessorController implements Controller {
    private ProfessorService professorService;
    private static Gson gson = new Gson();

    public ProfessorController(){
        professorService = new ProfessorService();
    }
    @Override
    public void registerRoutes(){

        path("/api", () -> {
            post("/professores", (request, response) -> {
                Professor novoProfessor = gson.fromJson(request.body(), Professor.class);
                professorService.adicionar(novoProfessor);

                response.status(201);
                return "Professor adicionado com sucesso.";
            });

            get("/professores", (request, response) -> {
                response.type("application/json");
                return gson.toJson(professorService.obterTodos());
            });

            get("/professores/:id", (request, response) -> {
                response.type("application/json");
                int id = Integer.parseInt(request.params(":id"));
                Professor professor = professorService.obterPorId(id);

                if (professor != null) {
                    return new Gson().toJson(professor);
                } else {
                    response.status(404);
                    return "Professor não encontrado.";
                }
           });

            delete("/professores/:id", (request, response) -> {
                int id = Integer.parseInt(request.params(":id"));
                Professor removido = professorService.excluir(id);

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
