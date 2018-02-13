package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class LmsService {
    @Autowired
    private LmsRespository lmsRespository;

    public Collection<Book> findAllBooks(){
        List<Book> books = new ArrayList<Book>();
        Locale locale = Locale.US;
        for(Book book : lmsRespository.findAll()){
         /*   SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd",locale);
            Date d = book.getPurchaseDate();
            Date d1 = new Date(d.getYear(),d.getMonth(),d.getDate());
            book.setPurchaseDate(d1);*/

//            System.out.println(d);
           /* try {
                book.setPurchaseDate(f.parse(String.valueOf(d)));
            } catch (ParseException e) {
                e.printStackTrace();
            }*/
            books.add(book);
        }
        return books;
    }


    public void delete(long id) {
        lmsRespository.delete(id);
    }

    public Book findOne(long id) {
        return  lmsRespository.findOne(id);
    }

    public void save(Book book) {
        lmsRespository.save(book);
    }
}
