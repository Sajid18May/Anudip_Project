package com.bookstore.amber.Entiry;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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

@OneToMany(cascade = CascadeType.ALL)
@JoinColumn(name="customer_id",referencedColumnName = "customer_id")
private List<Orders> orders;
}
