package com.libraryms.libraryms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryms.libraryms.entity.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer >  {

}
