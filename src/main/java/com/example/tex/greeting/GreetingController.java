package com.example.tex.greeting;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class GreetingController {

    private final GreetingService service;

    @GetMapping("/greeting")
    public ResponseEntity<String> getGreeting(@RequestParam String name) {
        return ResponseEntity.ok(
                service.findGreetingByName(name).greetingText()
        );
    }

    @PostMapping("/greeting")
    public ResponseEntity<Greeting> getGreeting(@RequestBody CreateGreetingRequest request) {
        return ResponseEntity.ok(
                service.saveGreeting(request)
        );
    }
}
