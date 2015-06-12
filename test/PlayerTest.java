import configs.AppConfig;
import models.Player;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.fest.assertions.Assertions.assertThat;

@ContextConfiguration(classes={AppConfig.class, TestDataConfig.class})
public class PlayerTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Test
    public void setPlayerName() {
        Player player = new Player();
        player.setName("foo");
        assertThat(player.getName()).isEqualTo("foo");
    }

}
