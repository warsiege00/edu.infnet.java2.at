package edu.infnet.controllers;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

import java.io.File;

import static spark.Spark.*;

public class LandingPageController implements Controller {

    @Override
    public void registerRoutes() {

        staticFileLocation("/public");

        get("/", (req, res) -> {
            return new ModelAndView(null, "index.html");
        }, new MustacheTemplateEngine());

        get("/rotas", (req, res) -> {
            return new ModelAndView(null, "rotas.html");
        }, new MustacheTemplateEngine());

    }
}
