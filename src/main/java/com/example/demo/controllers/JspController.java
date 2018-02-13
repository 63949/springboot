package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class JspController {

    @Autowired
    private LmsService lmsService;

    @GetMapping("/sss")
    String getView(Model model) {
//        model.addAttribute("msg", "Hello there, This message has been injected from the controller method");
        return "helloworld";
    }


    @GetMapping("/hello0")
    public ModelAndView getIndex(Model model) {
//        model.addAttribute("msg", "Hello there, This message has been injected from the controller method");
        ModelAndView m = new ModelAndView("index");
//        lmsService.findAllBooks();
        m.addObject("allbooks",lmsService.findAllBooks() );
        return m;
    }


}
