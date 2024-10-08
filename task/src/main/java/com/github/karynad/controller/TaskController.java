package com.github.karynad.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TaskController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello from Jira";
    }
}
