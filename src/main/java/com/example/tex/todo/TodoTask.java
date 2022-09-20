package com.example.tex.todo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class TodoTask {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;

    private String description;
}
