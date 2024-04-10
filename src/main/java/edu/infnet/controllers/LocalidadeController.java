package edu.infnet.controllers;

import com.google.gson.Gson;
import edu.infnet.clients.LocalidadesClient;
import edu.infnet.model.domain.Professor;
import edu.infnet.model.service.ProfessorService;

import static spark.Spark.*;

public class LocalidadeController implements Controller {
    private LocalidadesClient localidadesClient;
    private static Gson gson;

    public LocalidadeController(){
        localidadesClient = new LocalidadesClient();
        gson = new Gson();
    }
    @Override
    public void registerRoutes(){

        path("/api", () -> {
            get("/localidades/:cep", (request, response) -> {
                response.type("application/json");
                String cep = request.params(":cep");
                String end = localidadesClient.obterEndereco(cep);
                if (end != null) {
                    return new Gson().toJson(end);
                } else {
                    response.status(404);
                    return "Cep não encontrado.";
                }
           });
        });
    }

}
