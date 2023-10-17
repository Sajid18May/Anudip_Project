package com.bookstore.amber.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.amber.Entiry.Books;
import com.bookstore.amber.Service.BService;

@RestController
public class BookController {

    @Autowired
    BService bs;

    @PostMapping("/addBook")
    public Books addBooks(@RequestBody Books book){

        return bs.addBooks(book);
    }
    
}
