package edu.infnet;
import edu.infnet.clients.LocalidadesClient;
import edu.infnet.controllers.AulaController;
import edu.infnet.controllers.LocalidadeController;
import edu.infnet.controllers.ProfessorController;

import static spark.Spark.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        port(8080);


        ProfessorController professorController = new ProfessorController();
        professorController.registerRoutes();
        AulaController aulaController = new AulaController();
        aulaController.registerRoutes();
        LocalidadeController localidadeController = new LocalidadeController();
        localidadeController.registerRoutes();
    }
}