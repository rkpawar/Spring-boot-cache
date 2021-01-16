package com.ran.Springbootcache;

import org.slf4j.Logger;
import org.slf4j.helpers.NOPLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book/")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping(value = "/{id}", produces = "application/json")
    public String findById(@PathVariable int id) throws InterruptedException {
        return service.findById(id);
    }
}
