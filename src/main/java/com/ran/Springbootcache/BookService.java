package com.ran.Springbootcache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public String findById(int id) {
        return repository.findById(id);
    }
}
