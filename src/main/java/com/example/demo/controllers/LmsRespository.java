package com.example.demo.controllers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LmsRespository extends CrudRepository<Book,Long>{

}
