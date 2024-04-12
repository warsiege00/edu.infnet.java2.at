package edu.infnet;
import edu.infnet.controllers.*;

import static spark.Spark.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        port(8080);



        PageController pageController = new PageController();
        pageController.registerRoutes();
        ProfessorController professorController = new ProfessorController();
        professorController.registerRoutes();
        AulaController aulaController = new AulaController();
        aulaController.registerRoutes();
        LocalidadeController localidadeController = new LocalidadeController();
        localidadeController.registerRoutes();
        AlunoController alunoController = new AlunoController();
        alunoController.registerRoutes();


    }
}