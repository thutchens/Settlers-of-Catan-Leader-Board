package controllers;

import models.Player;
import models.PlayerForm;

import services.PlayerService;

import views.html.add;
import views.html.index;
import views.html.leader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import play.data.Form;
import play.libs.Json;
import play.mvc.Result;

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

    public Result addPlayer() throws Exception {
        Form<PlayerForm> form = Form.form(PlayerForm.class).bindFromRequest();
        if (form.hasErrors()) {
            return badRequest(add.render(form));
        }
        PlayerForm player = form.get();
        if (player.getWins() > player.getGames()) {
            form.reject("invalid.entry");
            return badRequest(add.render(form));
        }
        Player play = new Player(player.getFirstName(), player.getLastName(), player.getWins(), player.getGames());
        boolean playerIsUnique = playerService.addPlayer(play);
        if (playerIsUnique == false) {
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
