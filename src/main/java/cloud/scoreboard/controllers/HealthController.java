package cloud.scoreboard.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.scoreboard.entities.Health;

@RestController
@EnableAutoConfiguration
public class HealthController {

    @GetMapping("/health")
    public Health getHealth() {
        return new Health();
    }
}
