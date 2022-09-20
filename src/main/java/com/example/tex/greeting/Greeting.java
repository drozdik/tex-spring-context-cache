package com.example.tex;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Greeting {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;
    private String template;
    private String name;

    public String greetingText() {
        return String.format(template, name);
    }
}
