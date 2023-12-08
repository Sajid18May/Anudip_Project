package com.bookstore.amber.Entiry;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Customers {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int customer_id ;
@NotEmpty
@Size(min=2,message = "First name must be 2 charcters minimum")
private String first_name;
@NotEmpty
@Size(min=2,message = "First name must be 2 charcters minimum")
private String last_name;
@Email(message = "Not a valid Email")
private String email;
@NotEmpty
@Size(min = 8,message = "Password must be at least 8 characters long")
private String password ;
@NotEmpty
private String address;
@NotEmpty
@Size(min = 10,message = "Not a valid Phone Number")
private String phone_number;

}
