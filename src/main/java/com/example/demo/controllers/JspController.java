package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JspController {


    @GetMapping("/sss")
    String getView(Model model) {
//        model.addAttribute("msg", "Hello there, This message has been injected from the controller method");
        return "helloworld";
    }



}
