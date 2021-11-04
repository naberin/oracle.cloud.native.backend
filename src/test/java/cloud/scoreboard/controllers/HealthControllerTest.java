package cloud.scoreboard.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import cloud.scoreboard.entities.Health;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HealthController.class)
public class HealthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private Health health;

    @BeforeEach
    void setup() {
        this.health = new Health();
        this.objectMapper = new ObjectMapper();
    }

    @Test
    void itShouldReturnOK() throws Exception {
        MvcResult result = mockMvc.perform(get("/health"))
                .andReturn();
        String actualResponse = result.getResponse().getContentAsString();

        assertThat(result.getResponse().getStatus()).isEqualTo(200);

        assertThat(actualResponse).isEqualToIgnoringWhitespace(
                objectMapper.writeValueAsString(health));
    }

}