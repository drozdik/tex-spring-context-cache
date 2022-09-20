package com.example.tex.todo;

import lombok.Data;

@Data
public class CreateTodoTaskRequest {
    String description;

    public TodoTask toTask() {
        TodoTask task = new TodoTask();
        task.setDescription(description);
        return task;
    }
}
