package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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


  /*  @GetMapping("/hello0")
    public ModelAndView getIndex(Model model) {
//        model.addAttribute("msg", "Hello there, This message has been injected from the controller method");
        ModelAndView m = new ModelAndView("index");
//        lmsService.findAllBooks();
        m.addObject("allbooks",lmsService.findAllBooks() );
        return m;
    }*/
  @GetMapping("/hello0")
    public String getIndex(HttpServletRequest request) {
      request.setAttribute("allbooks",lmsService.findAllBooks());
      request.setAttribute("mode","BOOK_VIEW");
      return "index";
    }

    @GetMapping("/updateBook")
    public String getIndex(HttpServletRequest request, @RequestParam long id) {
        request.setAttribute("b",lmsService.findOne(id));
        request.setAttribute("mode","BOOK_EDIT");
        return "index";
    }

    // 检查到需要转换的类型自动转换
    @InitBinder()
    public void initBinder(WebDataBinder binder){
      binder.registerCustomEditor(Date.class,"purchaseDate",new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),false));
    }

    // 只需要传值就可以了。
    @PostMapping("/save")
    public String save(@ModelAttribute Book b, BindingResult bindingResult,HttpServletRequest request){
      System.out.println(b.getPurchaseDate());
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String pddd = f.format(b.getPurchaseDate());
       // book.setPurchaseDate(Date.parse());
        lmsService.save(b);
        b = null;
        request.setAttribute("allbooks",null);
        Collection<Book> ll = lmsService.findAllBooks();
        ll.size();
       /* request.setAttribute("allbooks",lmsService.findAllBooks());
        request.setAttribute("mode","BOOK_VIEW");*/
  //      return "ok";
        return "redirect:/hello0"; // 不要去直接请求别人的jsp,使用跳转访问.否则没有调CustomDateEditor的getValue方法就飞了,是因为CustomDateEditor对象没有重新生成的问题
    }

}
