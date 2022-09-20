package com.example.tex;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GreetingService {
    private final GreetingRepository repository;

    public Greeting findGreetingByName(String name) {
        return repository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Not found greeting by name %s".formatted(name)));
    }

    public Greeting saveGreeting(CreateGreetingRequest request) {
        return repository.save(request.toGreeting());
    }
}
