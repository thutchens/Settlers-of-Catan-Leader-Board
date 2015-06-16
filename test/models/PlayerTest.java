package models;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

import configs.AppConfig;
import configs.TestDataConfig;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import static org.fest.assertions.Assertions.assertThat;

@ContextConfiguration(classes={AppConfig.class, TestDataConfig.class})
public class PlayerTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Test
    public void setPlayerName() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                Player player = new Player();
                player.setFirstName("foo");
                player.setLastName("foo");
                player.setWins(100);
                player.setGames(100);
                assertThat(player.getFirstName()).isEqualTo("foo");
                assertThat(player.getLastName()).isEqualTo("foo");
            }
        });
    }
}
