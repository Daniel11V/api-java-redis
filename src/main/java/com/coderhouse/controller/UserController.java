package com.coderhouse.controller;

import com.coderhouse.model.User;
import com.coderhouse.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/coder-house")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("user/login")
    public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) throws Exception {
        return service.getUser(username, pwd);
    }

}
