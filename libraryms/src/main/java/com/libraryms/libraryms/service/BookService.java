package com.libraryms.libraryms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryms.libraryms.entity.Book;
import com.libraryms.libraryms.repo.BookRepo;

@Service
public class BookService {
	
	@Autowired
	private BookRepo bookRepo;
	
	  
	  public List<Book> getAllBooks(){
		  return bookRepo.findAll();
	  }
	  public Book getBookById(int id) {
		  return bookRepo.findById(id)
				  .orElseThrow(() -> new RuntimeException("Given id is incorrect"));
	  }
	  public Book saveOrUpdateBook(Book book) {
		 return bookRepo.save(book); 
	  }
	  public void deleteBookById(int id) {
		  bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Given id is incorrect")); 
		  bookRepo.deleteById(id);
	  }
}
