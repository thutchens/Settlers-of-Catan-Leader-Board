import static org.fest.assertions.Assertions.assertThat;

import configs.AppConfig;

import models.Player;

import services.PlayerService;

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
        Player player = new Player();
        player.setName("foo");
        playerService.addPlayer(player);
        assertThat(player.getId()).isNotNull();
    }

    @Test
    public void getPlayers() {
        createPlayer();
        List<Player> players = playerService.getAllPlayers();
        assertThat(players.size()).isEqualTo(1);
    }

}