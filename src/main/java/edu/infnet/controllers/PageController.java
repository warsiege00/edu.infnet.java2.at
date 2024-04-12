package edu.infnet.controllers;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

import static spark.Spark.*;

public class PageController implements Controller {

    @Override
    public void registerRoutes() {

        staticFileLocation("/public");

        get("/", (req, res) -> {
            return new ModelAndView(null, "index.html");
        }, new MustacheTemplateEngine());

        get("/api-info", (req, res) -> {
            return new ModelAndView(null, "rotas.html");
        }, new MustacheTemplateEngine("public"));

    }
}
