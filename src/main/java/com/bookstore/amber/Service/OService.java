package com.bookstore.amber.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookstore.amber.Entiry.Orders;
import com.bookstore.amber.Repo.ORepo;

public class OService {
    @Autowired
    ORepo or;

    public Orders addOrders(Orders order){
        return or.save(order);
    }
}
