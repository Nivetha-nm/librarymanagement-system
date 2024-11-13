package com.libraryms.libraryms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libraryms.libraryms.entity.Publisher;
import com.libraryms.libraryms.service.PublisherService;

@RestController
@RequestMapping("/api/publisher")
public class PublisherController {

	
	@Autowired
	private PublisherService publisherService;
	
	@GetMapping
	public ResponseEntity<List<Publisher>> getAllPublishers(){
		List<Publisher>Publishers=publisherService.getAllPublishers();
		return ResponseEntity.ok(Publishers);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Publisher> getPublisher(@PathVariable int id){
		Publisher Publisher=publisherService.getPublisherById(id);
		if(Publisher==null) {
			return ResponseEntity.notFound().build();
			}
		return ResponseEntity.ok(Publisher);
	}
	
	@PostMapping
	 public ResponseEntity<Publisher> savePublisher(@RequestBody Publisher Publisher){
		Publisher createPublisher=publisherService.saveOrUpdatePublisher(Publisher);
		return ResponseEntity.status(HttpStatus.CREATED).body(createPublisher);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Publisher> updatePublisher(@PathVariable int id, @RequestBody Publisher Publisher){
		Publisher existingPublisher = publisherService.getPublisherById(id);
		if(existingPublisher==null)
		{
			return ResponseEntity.notFound().build();
		}
		Publisher.setId(id);
		publisherService.saveOrUpdatePublisher(Publisher);
		return ResponseEntity.ok(Publisher);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePublisher(@PathVariable int id){
		
		Publisher Publisher= publisherService.getPublisherById(id);
		if(Publisher==null)
		{
			return ResponseEntity.notFound().build();
		}
		publisherService.deletePublisherById(id);
		return ResponseEntity.noContent().build();
	}
}
