package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//http://localhost:8080/hello
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String sayHi(){
        return  "Hi";
    }
}
