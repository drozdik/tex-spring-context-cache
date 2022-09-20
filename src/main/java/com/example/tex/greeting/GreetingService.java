package com.example.tex.greeting;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GreetingService {
    private final GreetingRepository repository;

    public Greeting findGreetingByName(String name) {
        return repository.findByName(name)
                .orElseGet(() -> Greeting.notFoundStub());
    }

    public Greeting saveGreeting(CreateGreetingRequest request) {
        return repository.save(request.toGreeting());
    }
}
