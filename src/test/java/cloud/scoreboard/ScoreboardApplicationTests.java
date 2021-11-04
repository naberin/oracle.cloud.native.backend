package cloud.scoreboard;


import static org.assertj.core.api.Assertions.assertThat;

import cloud.scoreboard.controllers.HealthController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ScoreboardApplicationTests {

    @Autowired
    private HealthController healthController;

    // Smoke Test
    @Test
    void contextLoads() throws Exception {
        assertThat(healthController).isNotNull();
    }

}
