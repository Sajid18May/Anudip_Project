package com.bookstore.amber.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookstore.amber.Entiry.Customers;
import com.bookstore.amber.Service.CService;

import jakarta.validation.Valid;

@Controller
public class WebController {
    @Autowired
    CService cs;
    @GetMapping("/")
    public String register(Customers customers){

        return "index";
    }
    @PostMapping("/register")
    public String registerSucess(@Valid Customers customers, BindingResult bindingResult){
         
         if (bindingResult.hasErrors()) {
            return "index"; 
        }
        cs.addCustomers(customers);
        return "congrats";
    }
}
