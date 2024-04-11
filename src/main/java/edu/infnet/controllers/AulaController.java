package edu.infnet.controllers;

import com.google.gson.Gson;
import edu.infnet.clients.LocalidadesClient;
import edu.infnet.model.domain.Aluno;
import edu.infnet.model.domain.Aula;
import edu.infnet.model.domain.Professor;
import edu.infnet.model.service.AulaService;
import edu.infnet.model.service.ProfessorService;

import static spark.Spark.*;

public class AulaController implements Controller {

    private AulaService aulaService;
    private LocalidadesClient localidadesClient;
    private static Gson gson = new Gson();

    public AulaController(){
        localidadesClient = new LocalidadesClient();
        aulaService = new AulaService();
    }
    @Override
    public void registerRoutes(){

        path("/api", () -> {

            post("/aulas", (request, response) -> {
                Aula novaAula = gson.fromJson(request.body(), Aula.class);
                aulaService.criar(novaAula);

                response.status(201);
                return "Aula adicionada com sucesso.";
            });

            get("/aulas", (request, response) -> {
                response.type("application/json");
                return gson.toJson(aulaService.obterTodos());
            });

            get("/aulas/:id", (request, response) -> {
                response.type("application/json");
                int id = Integer.parseInt(request.params(":id"));
                Aula aula = aulaService.obterPorId(id);

                if (aula != null) {
                    return new Gson().toJson(aula);
                } else {
                    response.status(404);
                    return "Aula não encontrada.";
                }
            });

            delete("/aulas/:id", (request, response) -> {
                int id = Integer.parseInt(request.params(":id"));
                Aula aulaRemovida = aulaService.excluir(id);

                if (aulaRemovida != null) {
                    response.status(204);
                    return "Aula removida com sucesso.";
                } else {
                    response.status(404);
                    return "aulaRemovida não encontrada.";
                }

            });

            post("/aulas/:id/matricularAluno/:alunoId", (request, response) -> {
                Aluno aluno = gson.fromJson(request.body(), Aluno.class);
                int aulaId = Integer.parseInt(request.params(":id"));
                int alunoId = Integer.parseInt(request.params(":alunoId"));
                boolean alunoMatriculado = aulaService.adicionarAluno(alunoId, aulaId);

                if(!alunoMatriculado){
                    response.status(404);
                    return "Aluno não encontrado.";
                }

                response.status(201);
                return "Aluno matriculado com sucesso a aula.";

            });

            post("/aulas/:id/definirProfessor/:professorId", (request, response) -> {

                Professor professor = gson.fromJson(request.body(), Professor.class);
                int aulaId = Integer.parseInt(request.params(":id"));
                int professorId = Integer.parseInt(request.params(":professorId"));

                boolean professorDefinido = aulaService.definirProfessor(professorId, aulaId);
                if(!professorDefinido){
                    response.status(404);
                    return "Professor não encontrado.";
                }

                response.status(201);
                return "Professor definido com sucesso.";
            });

        });
    }

}
