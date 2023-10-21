package com.bookstore.amber.Entiry;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id ;
    //private int customer_id ;
    //private int book_id ;
    private Date order_date;
    private String status;
    private int quantity;
    private double subtotal;
}
