package controllers;

import models.Player;

import services.PlayerService;

import views.html.add;
import views.html.index;
import views.html.leader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import play.data.Form;
import play.mvc.Result;

@org.springframework.stereotype.Controller
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private PlayerService playerService;

    public Result index() {
        return play.mvc.Controller.ok(index.render());
    }

    public Result leader() {
        return play.mvc.Controller.ok(leader.render());
    }

    public Result addToPlayer() {
        return play.mvc.Controller.ok(add.render(Form.form(Player.class)));
    }

    public Result addPlayer() {
        Form<Player> form = Form.form(Player.class).bindFromRequest();
        if (form.hasErrors()) {
            log.error("Error during player entry");
            return play.mvc.Controller.badRequest(add.render(form));
        }
        Player player = form.get();
        if (player.getWins() > player.getGames()) {
            log.error("Wins can't be larger than games played");
            return play.mvc.Controller.badRequest(add.render(form));
        } else {
            playerService.addPlayer(player);
            log.info("Player Added '{}'", player);
            return play.mvc.Controller.redirect(controllers.routes.Application.addPlayer());
        }
    }

}