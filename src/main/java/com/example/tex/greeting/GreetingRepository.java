package com.example.tex;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface GreetingRepository extends JpaRepository<Greeting, Long> {
    Optional<Greeting> findByName(String name);
}
