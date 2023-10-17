package com.bookstore.amber.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.amber.Entiry.Books;
import com.bookstore.amber.Repo.BRepo;
@Service
public class BService {
    @Autowired
    BRepo br;

    public Books addBooks(Books book){

        return br.save(book);
    }
}
