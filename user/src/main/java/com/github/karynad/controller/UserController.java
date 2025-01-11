package com.github.karynad.controller;

import com.github.karynad.model.Role;
import com.github.karynad.model.User;
import com.github.karynad.model.dto.UserDTO;
import com.github.karynad.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/save")
    public String save() {
        userService.register(new UserDTO("385567844", "rabb"));
        return "Hello from user2";
    }

    @GetMapping("/auth-only")
    public String test() {
        return "Success";
    }

    @GetMapping("/secured")
    public String secured() {
        return "Hello from secured";
    }

    @GetMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }
}
