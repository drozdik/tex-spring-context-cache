package com.example.tex.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TodoService {

    private final TodoTaskRepository repository;

    public TodoTask createTask(TodoTask task) {
        return repository.save(task);
    }

    public List<TodoTask> getAllTodoTasks() {
        return repository.findAll();
    }
}
