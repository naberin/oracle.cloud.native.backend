package cloud.scoreboard.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HealthTest {
    Health health;

    @BeforeEach
    void function () {
        this.health = new Health();
    }

    @Test
    void healthShouldHaveOkForStatus() {
        String status = this.health.getStatus();
        assertEquals(status, "OK");
    }
}
