package com.bookstore.amber.Entiry;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Customers {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int customer_id ;
private String first_name;
private String last_name;
private String email;
private String password ;
private String address;
private String phone_number;
}
