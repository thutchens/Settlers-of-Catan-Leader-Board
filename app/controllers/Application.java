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
        return ok(add.render(Form.form(PlayerForm.class), ""));
    }

    public Result addPlayer() {
        Form<PlayerForm> form = Form.form(PlayerForm.class).bindFromRequest();
        if (form.hasErrors()) {
            log.error("Error during player entry");
            return badRequest(add.render(form, "Error during player entry"));
        }
        PlayerForm player = form.get();
        if (player.getWins() > player.getGames()) {
            log.error("Wins can't be larger than games played");
            return badRequest(add.render(form, "Wins can't be larger than games played"));
        } else {
            Player play = new Player();
            play.setGames(player.getGames());
            play.setWins(player.getWins());
            play.setName(player.getName());
            playerService.addPlayer(play);
            log.info("Player Added '{}'", player);
            return ok(add.render(Form.form(PlayerForm.class), "Successfully added a player!"));
        }
    }

    public Result listPlayers() {
        return ok(Json.toJson(playerService.getAllPlayers()));
    }

}