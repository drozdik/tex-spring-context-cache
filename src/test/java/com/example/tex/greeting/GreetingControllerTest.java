package com.example.tex.greeting;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GreetingControllerTest {
    @Autowired
    GreetingRepository greetingRepository;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void saveGreeting() throws Exception {
        String name = "John";
        String template = "Hello, %s";
        String createGreetingJson = objectMapper.writeValueAsString(new CreateGreetingRequest(name, template));

        mockMvc.perform(post("/greeting")
                        .contentType(APPLICATION_JSON)
                        .content(createGreetingJson))
                .andExpect(status().isOk());

        Optional<Greeting> greeting = greetingRepository.findByName(name);
        assertThat(greeting).isPresent();
        assertThat(greeting.get().getName()).isEqualTo("John");
        assertThat(greeting.get().getTemplate()).isEqualTo("Hello, %s");
    }
}
