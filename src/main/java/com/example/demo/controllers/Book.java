package com.example.demo.controllers;

import javax.persistence.*;
import java.util.Date;
import java.util.zip.DataFormatException;

@Entity(name = "lms_tbl")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "book_name")
    private String book_name;

    private String author;

    @Column(name = "purchase_date")
    @Temporal(TemporalType.DATE)
    private Date purchaseDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
