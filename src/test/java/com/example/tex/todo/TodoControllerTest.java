package com.example.tex.todo;

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
class TodoControllerTest {
    @Autowired
    TodoTaskRepository taskRepository;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void saveGreeting() throws Exception {
        String taskJson= objectMapper.writeValueAsString(new CreateTodoTaskRequest("description of task"));
        String responseContent = mockMvc.perform(post("/todo/task")
                        .contentType(APPLICATION_JSON)
                        .content(taskJson))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        Long taskId = objectMapper.readTree(responseContent).findValue("id").asLong();
        Optional<TodoTask> task = taskRepository.findById(taskId);
        assertThat(task).isPresent();
    }

}
