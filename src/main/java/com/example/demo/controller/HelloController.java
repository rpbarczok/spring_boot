package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    @GetMapping
    public String sayHello(){
        return "Hello World!";
    }

    @GetMapping("/john")
    public String sayHelloPersonalized(){
        return "Hello John!";
    }

}
