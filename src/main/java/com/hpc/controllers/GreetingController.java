package com.hpc.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("greet")
public class GreetingController {

    @GetMapping
    public String hello() {
        return "Hello World";
    }
}
