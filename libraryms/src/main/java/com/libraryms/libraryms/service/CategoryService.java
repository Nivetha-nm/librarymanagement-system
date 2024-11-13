package com.libraryms.libraryms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.libraryms.libraryms.entity.Category;
import com.libraryms.libraryms.repo.CategoryRepo;

@Service
public class CategoryService {
	
      @Autowired
      private CategoryRepo categoryRepo;
	  
	  public List<Category> getAllCategorys(){
		  return categoryRepo.findAll();
	  }
	  public Category getCategoryById(int id) {
		  return categoryRepo.findById(id)
				  .orElseThrow(() -> new RuntimeException("Given id is incorrect"));
	  }
	  public Category saveOrUpdateCategory(Category category) {
		 return categoryRepo.save(category); 
	  }
	  public void deleteCategoryById(int id) {
		  
		  categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Given id is incorrect")); 
		  categoryRepo.deleteById(id);
	  }  

}
