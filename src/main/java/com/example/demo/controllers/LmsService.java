package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class LmsService {
    @Autowired
    private LmsRespository lmsRespository;

    public Collection<Book> findAllBooks(){
        List<Book> books = new ArrayList<Book>();
        for(Book book : lmsRespository.findAll()){
            books.add(book);
        }
        return books;
    }


    public void delete(long id) {
        lmsRespository.delete(id);
    }
}
