package controllers;

import models.Player;
import models.PlayerForm;

import services.PlayerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import play.data.Form;
import play.libs.Json;
import play.mvc.Result;

import views.html.index;
import views.html.add;
import views.html.leader;

@org.springframework.stereotype.Controller
public class Application extends play.mvc.Controller {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private PlayerService playerService;

    public Result index() {
        return ok(index.render());
    }

    public Result leader() {
        return ok(leader.render());
    }

    public Result addToPlayer() {
        return ok(add.render(Form.form(PlayerForm.class)));
    }

    public Result addPlayer() {
        Form<PlayerForm> form = Form.form(PlayerForm.class).bindFromRequest();
        if (form.hasErrors()) {
            return badRequest(add.render(form));
        }
        PlayerForm player = form.get();
        if (player.getWins() > player.getGames()) {
            form.reject("invalid.entry");
            return badRequest(add.render(form));
        }
        Player play = new Player();
        play.setGames(player.getGames());
        play.setWins(player.getWins());
        play.setFirstName(player.getFirstName());
        play.setLastName(player.getLastName());
        boolean b = playerService.addPlayer(play);
        if (b == false) {
            form.reject("invalid.double");
            return badRequest(add.render(form));
        }
        log.info("Player Added '{}'", player);
        return ok(add.render(Form.form(PlayerForm.class)));
    }

    public Result listPlayers() {
        return ok(Json.toJson(playerService.getAllPlayers()));
    }

}