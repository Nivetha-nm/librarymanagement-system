package com.libraryms.libraryms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryms.libraryms.entity.Book;

public interface BookRepo extends JpaRepository<Book,Integer >  {

}
