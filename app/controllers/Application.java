package controllers;


import models.Bar;

import org.springframework.beans.factory.annotation.Autowired;

import play.data.Form;
import play.libs.Json;
import play.mvc.Result;

import services.BarService;

import views.html.index;
import views.html.leader;
import views.html.add;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@org.springframework.stereotype.Controller
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private BarService barService;

    public Result index() {
        return play.mvc.Controller.ok(index.render(Form.form(Bar.class)));
    }

    public Result leader() {
        return play.mvc.Controller.ok(leader.render(Form.form(Bar.class)));
    }

    public Result addPlayer() {
        return play.mvc.Controller.ok(add.render(Form.form(Bar.class)));
    }

    public Result addBar() {
        Form<Bar> form = Form.form(Bar.class).bindFromRequest();
        Bar bar = form.get();
        barService.addBar(bar);
        log.info("Bar Added");
        return play.mvc.Controller.redirect(controllers.routes.Application.addPlayer());
    }

    public Result listBars() {
        return play.mvc.Controller.ok(Json.toJson(barService.getAllBars()));
    }

}