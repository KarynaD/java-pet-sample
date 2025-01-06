package com.github.karynad.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
@RestController
public class TaskController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello from task0 new";
    }

    @GetMapping("/tasks")
    public Flux<String> getUsers() {
        return Flux.just("Alice78907666555", "Bob", "Charlie1234")
                .delayElements(Duration.ofMillis(2500)); // Асинхронная задержка
    }
}
