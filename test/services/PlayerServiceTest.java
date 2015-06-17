package services;

import static org.fest.assertions.Assertions.assertThat;

import configs.AppConfig;
import configs.TestDataConfig;

import models.Player;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.List;

@ContextConfiguration(classes={AppConfig.class, TestDataConfig.class})
public class PlayerServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private PlayerService playerService;

    @Test
    public void createPlayer() {
        Player play = new Player();
        play.setFirstName("foo");
        playerService.addPlayer(play);
        assertThat(play.getId()).isNotNull();
    }

    @Test
    public void getPlayers() {
        createPlayer();
        List<Player> players = playerService.getAllPlayers();
        assertThat(players.size()).isEqualTo(1);
    }

}