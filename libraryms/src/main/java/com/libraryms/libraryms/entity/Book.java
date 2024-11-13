package com.libraryms.libraryms.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
@Entity
@Table(name="books")
public class Book {
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@ManyToMany
	@JoinTable(name="book_authors",
	             joinColumns= {@JoinColumn(name="book_id")},
	             inverseJoinColumns= {@JoinColumn(name="author_id")})
	private List<Author> authors;
	
	@ManyToMany
	@JoinTable(name="book_categories",
    joinColumns= {@JoinColumn(name="book_id")},
    inverseJoinColumns= {@JoinColumn(name="category_id")})
	private List<Category> categories;
	
	@ManyToMany
	@JoinTable(name="book_publishers",
    joinColumns= {@JoinColumn(name="book_id")},
    inverseJoinColumns= {@JoinColumn(name="publisher_id")})
	private List<Publisher> publishers;
	
	public Book() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Publisher> getPublishers() {
		return publishers;
	}

	public void setPublishers(List<Publisher> publishers) {
		this.publishers = publishers;
	}
	
}
