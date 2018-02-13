package com.example.demo.controllers;

import org.springframework.beans.propertyeditors.CustomDateEditor;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyCustomDateEditor extends CustomDateEditor {
    public MyCustomDateEditor(DateFormat dateFormat, boolean allowEmpty) {
        super(dateFormat, allowEmpty);
    }

    public MyCustomDateEditor(DateFormat dateFormat, boolean allowEmpty, int exactDateLength) {
        super(dateFormat, allowEmpty, exactDateLength);
    }

    private String myValue;
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        myValue = text;
        super.setAsText(text);
    }


}
