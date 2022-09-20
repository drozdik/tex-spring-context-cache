package com.example.tex.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService service;

    @PostMapping("/todo/task")
    public ResponseEntity<TodoTask> createTask(@RequestBody CreateTodoTaskRequest request) {
        return ResponseEntity.ok(
                service.createTask(request.toTask())
        );
    }

    @GetMapping("/todo")
    public ResponseEntity<List<TodoTask>> getTodoList() {
        return ResponseEntity.ok(service.getAllTodoTasks());
    }
}
