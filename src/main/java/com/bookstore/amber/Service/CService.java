package com.bookstore.amber.Service;

import org.springframework.beans.factory.annotation.Autowired;
import com.bookstore.amber.Entiry.Customers;
import com.bookstore.amber.Repo.CRepo;

public class CService {
    @Autowired
    CRepo cr;

    public Customers addBooks(Customers customer){

        return cr.save(customer);
    }
}
