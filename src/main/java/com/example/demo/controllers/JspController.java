package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {
    @GetMapping(value = "/hellojsp0")
    public String  init(){
        return "index1";
    }
    @RequestMapping(value = "/hellojsp")
    public String hello(){
        return "index1";
    }

    @GetMapping
    String getView(Model model) {
//        model.addAttribute("msg", "Hello there, This message has been injected from the controller method");
        return "helloworld";
    }
}
