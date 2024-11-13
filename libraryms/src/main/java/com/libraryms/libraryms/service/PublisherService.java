package com.libraryms.libraryms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryms.libraryms.entity.Publisher;
import com.libraryms.libraryms.repo.PublisherRepo;

@Service
public class PublisherService {
  
	@Autowired
	private PublisherRepo publisherRepo;
	  
	  public List<Publisher> getAllPublishers(){
		  return publisherRepo.findAll();
	  }
	  public Publisher getPublisherById(int id) {
		  return publisherRepo.findById(id)
				  .orElseThrow(() -> new RuntimeException("Given id is incorrect"));
	  }
	  public Publisher saveOrUpdatePublisher(Publisher publisher) {
		 return publisherRepo.save(publisher); 
	  }
	  public void deletePublisherById(int id) {
		  publisherRepo.findById(id).orElseThrow(() -> new RuntimeException("Given id is incorrect")); 
		  publisherRepo.deleteById(id);
	  }  
}
