package com.libraryms.libraryms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryms.libraryms.entity.Author;

public interface AuthorRepo extends JpaRepository<Author,Integer > {
 
}
