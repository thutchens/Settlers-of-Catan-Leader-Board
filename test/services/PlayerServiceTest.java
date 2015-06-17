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
        Player play = new Player("foo", "foo", 100, 100);
        assertThat(playerService.addPlayer(play)).isTrue();
        assertThat(play.getId()).isNotNull();
    }

    @Test
    public void createEmptyPlayer() {
        Player play = new Player();
        assertThat(playerService.addPlayer(play)).isFalse();
    }

    @Test
    public void createNullPlayer() {
        assertThat(playerService.addPlayer(null)).isFalse();
    }

    @Test
    public void createNoFirstNamePlayer() {
        Player play = new Player(null, "foo", 100, 100);
        assertThat(playerService.addPlayer(play)).isFalse();
    }

    @Test
    public void createNoLastNamePlayer() {
        Player play = new Player("foo", null, 100, 100);
        assertThat(playerService.addPlayer(play)).isFalse();
    }

    @Test
    public void createNoWinsPlayer() {
        Player play = new Player("foo", "foo", null, 100);
        assertThat(playerService.addPlayer(play)).isFalse();
    }

    @Test
    public void createNoGamesPlayer() {
        Player play = new Player("foo", "foo", 100, null);
        assertThat(playerService.addPlayer(play)).isFalse();
    }

    @Test
    public void createNoNamesPlayer() {
        Player play = new Player("", "", 100, 100);
        assertThat(playerService.addPlayer(play)).isFalse();
    }

    @Test
    public void getPlayers() {
        Player play = new Player("foo", "foo", 100, 100);
        assertThat(playerService.addPlayer(play)).isTrue();
        List<Player> players = playerService.getAllPlayers();
        assertThat(players.size()).isEqualTo(1);
    }

    @Test
    public void getNoPlayers() {
        assertThat(playerService.getAllPlayers().size()).isEqualTo(0);
    }

}