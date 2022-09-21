package com.example.tex.todo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTodoTaskRequest {
    String description;

    public TodoTask toTask() {
        TodoTask task = new TodoTask();
        task.setDescription(description);
        return task;
    }
}
