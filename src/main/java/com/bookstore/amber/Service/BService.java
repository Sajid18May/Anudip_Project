package com.bookstore.amber.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.amber.Entiry.Books;
import com.bookstore.amber.Repo.BRepo;
@Service
public class BService {
    @Autowired
    BRepo br;

    public Books addBooks(Books book){

        return br.save(book);
    }
    public List<Books> fetchAllBooks() {	
		return br.findAll();
	}

	public Books getBooksById(int id) {
		Optional<Books> order = br.findById(id);

		if (order.isPresent()) {
			return order.get();
		}
		return null;
	}

	
	public String deleteBooksById(int id) {
		if(br.findById(id).isPresent()) {
			br.deleteById(id);
			return "Order deleted successfully";
		}
		return "No such order in the database";
	}
}
