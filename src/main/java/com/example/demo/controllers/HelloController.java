package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

//http://localhost:8080/hello
@RestController
public class HelloController {
    @Autowired
    private LmsService lmsService;

    @RequestMapping("/hello")
    public String sayHi(){
        return  "Hi";
    }

    @GetMapping(value = "/findAllBooks")
    public Collection<Book> getAllBooks(){
        return lmsService.findAllBooks();
    }
}
