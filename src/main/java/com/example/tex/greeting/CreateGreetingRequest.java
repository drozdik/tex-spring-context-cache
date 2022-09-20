package com.example.tex.greeting;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateGreetingRequest {
    String name, template;

    public Greeting toGreeting() {
        Greeting greeting = new Greeting();
        greeting.setTemplate(template);
        greeting.setName(name);
        return greeting;
    }
}
