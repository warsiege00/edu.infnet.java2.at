package edu.infnet.controllers;

import com.google.gson.Gson;
import edu.infnet.clients.LocalidadesClient;
import edu.infnet.model.domain.Aula;
import edu.infnet.model.domain.Professor;
import edu.infnet.model.service.AulaService;
import edu.infnet.model.service.ProfessorService;

import static spark.Spark.*;

public class AulaController implements Controller {

    private AulaService aulaService;
    private ProfessorService professorService;
    private LocalidadesClient localidadesClient;
    private static Gson gson = new Gson();

    public AulaController(){
        localidadesClient = new LocalidadesClient();
        professorService = new ProfessorService();
        aulaService = new AulaService();
    }
    @Override
    public void registerRoutes(){

        path("/api", () -> {

            post("/aulas", (request, response) -> {
                Aula novaAula = gson.fromJson(request.body(), Aula.class);
                aulaService.adicionar(novaAula);

                response.status(201);
                return "Aula adicionada com sucesso.";
            });

            get("/aulas", (request, response) -> {
                response.type("application/json");
                return gson.toJson(aulaService.obterTodos());
            });

//            get("/aulas/:id", (request, response) -> {
//                response.type("application/json");
//                int id = Integer.parseInt(request.params(":id"));
//                Professor professor = professorService.obterPorId(id);
//
//                if (professor != null) {
//                    return new Gson().toJson(professor);
//                } else {
//                    response.status(404);
//                    return "Professor não encontrado.";
//                }
//            });
//
//            delete("/aulas/:id", (request, response) -> {
//                int id = Integer.parseInt(request.params(":id"));
//                Professor removido = professorService.excluir(id);
//
//                if (removido != null) {
//                    response.status(204);
//                    return "Professor removido com sucesso.";
//                } else {
//                    response.status(404);
//                    return "Professor não encontrado.";
//                }
//
//            });

        });
    }

}
