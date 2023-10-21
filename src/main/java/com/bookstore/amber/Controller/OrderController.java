package com.bookstore.amber.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.amber.Entiry.Orders;
import com.bookstore.amber.Service.OService;


@RestController
public class OrderController {
    
    @Autowired
    OService os;

    
    @PostMapping("/addOrder")
    public Orders addOrders(@RequestBody Orders Order){

        return os.addOrders(Order);
    }
    
	  @GetMapping("/getOrders")
	    public List<Orders> getAllOrders() {
	        return os.fetchAllOrders();
	    }
	  
	  @GetMapping("/getOrders/{id}") //localhost:8080/getOrders/5
	  public Orders getOrdersById(@PathVariable("id")int id)
	  {
		  return os.getOrdersById(id);
	  }
	  
	  @DeleteMapping("/Orders/{id}")
	  public String deleteOrders(@PathVariable("id") int id) {
		  return os.deleteOrdersById(id);
	  }
}
