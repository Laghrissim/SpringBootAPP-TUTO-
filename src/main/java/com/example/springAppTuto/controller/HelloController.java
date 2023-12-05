package com.example.springAppTuto.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${Messages.Hello}")
    private String HelloMessage;

    @GetMapping(value = "/")
    public String hello(){
        return HelloMessage;
    }
}
