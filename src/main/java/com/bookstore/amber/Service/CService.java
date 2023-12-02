package com.bookstore.amber.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.amber.Entiry.Customers;
import com.bookstore.amber.Repo.CRepo;

@Service
public class CService {
    @Autowired
    CRepo cr;

    public Customers addCustomers(Customers customer){

        return cr.save(customer);
    }
    	public List<Customers> fetchAllCustomers() {	
		return cr.findAll();
	}

	public Customers getCustomersById(int id) {
		Optional<Customers> customer = cr.findById(id);

		if (customer.isPresent()) {
			return customer.get();
		}
		return null;
	}

	
	public String deleteCustomersById(int id) {
		if(cr.findById(id).isPresent()) {
			cr.deleteById(id);
			return "customer deleted successfully";
		}
		return "No such customer in the database";
	}

    public Customers upadteCustomersById(int id, Customers customer) {
		Optional<Customers> customer1 = cr.findById(id);
		
		if (customer1.isPresent()) {
			
			Customers originalCustomer = customer1.get();
			
			 if (Objects.nonNull(customer.getFirst_name()) && !"".equalsIgnoreCase(customer.getFirst_name())) {
				 originalCustomer.setFirst_name(customer.getFirst_name());
	            }
			 if (Objects.nonNull(customer.getLast_name()) && !"".equalsIgnoreCase(customer.getLast_name())) {
				 originalCustomer.setLast_name(customer.getLast_name());
	            }
			 
			 if (Objects.nonNull(customer.getEmail()) && !"".equalsIgnoreCase(customer.getEmail())) {
				 originalCustomer.setEmail(customer.getEmail());
	            }
			 
			 if (Objects.nonNull(customer.getPassword()) && !"".equalsIgnoreCase(customer.getPassword())) {
				 originalCustomer.setPassword(customer.getPassword());
	            }
			
	            return cr.save(originalCustomer);
			
		}

		return null;
	}
	public Customers getByEmail(String email){
		return cr.findByEmail(email);
	}

}
