package com.example.tex.todo;

import org.springframework.data.jpa.repository.JpaRepository;

interface TodoTaskRepository extends JpaRepository<TodoTask, Long> {
}
