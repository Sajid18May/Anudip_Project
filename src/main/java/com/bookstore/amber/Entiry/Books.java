package com.bookstore.amber.Entiry;

import java.util.Date;
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
public class Books {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int book_id;
private String title;
private String author_name;
private String genre;
private double price;
private Date published_date;
private int stock_quantity;

@OneToMany(cascade = CascadeType.ALL)
@JoinColumn(name="book_id",referencedColumnName = "book_id")
private List<Orders> orders;
}
