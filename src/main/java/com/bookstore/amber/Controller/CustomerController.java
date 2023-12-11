package com.bookstore.amber.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.amber.Entiry.Customers;
import com.bookstore.amber.Service.CService;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
    
    @Autowired
    CService cs;

    @PostMapping("/addCustomers")
	public Customers addCustomers(@Valid @RequestBody Customers Customers) {
		
		return cs.addCustomers(Customers);
	}
	@PostMapping("/register")
    public Customers registration(@Valid @RequestBody Customers Customers){
        Customers existingUser = cs.getByEmail(Customers.getEmail());

        if(existingUser != null)
            return null;
		else
        	return cs.addCustomers(Customers);
    }

	  @GetMapping("/getCustomers")
	    public List<Customers> getAllCustomers() {
	        return cs.fetchAllCustomers();
	    }
	  
	  @GetMapping("/getCustomers/{id}") //localhost:8080/getCustomers/5
	  public Customers getCustomersById(@PathVariable("id")int id)
	  {
		  return cs.getCustomersById(id);
	  }
	  
	  @PutMapping("/Customers/{id}")
	    public Customers updateCustomers(@PathVariable("id") int id, @RequestBody Customers Customers) {
	        return cs.upadteCustomersById(id, Customers);
	    }
	  
	  @DeleteMapping("/Customers/{id}")
	  public String deleteCustomers(@PathVariable("id") int id) {
		  return cs.deleteCustomersById(id);
	  }

	  @PostMapping("/log_in")
      public Customers login(@RequestBody Customers user){
		String email=user.getEmail();
		String password=user.getPassword();
         Customers c1=cs.getByEmail(email);
        if(c1!=null && c1.getPassword().equals(password)){

            return c1; 
        }
        else{
            return null;    
        }
    }
}
