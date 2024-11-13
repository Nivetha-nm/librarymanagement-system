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
import com.libraryms.libraryms.entity.Category;

import com.libraryms.libraryms.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	@GetMapping
	public ResponseEntity<List<Category>> getAllCategory(){
		List<Category> categorys=categoryService.getAllCategorys();
		return ResponseEntity.ok(categorys);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategory(@PathVariable int id){
		Category category=categoryService.getCategoryById(id);
		if(category==null) {
			return ResponseEntity.notFound().build();
			}
		return ResponseEntity.ok(category);
	}
	
	@PostMapping
	 public ResponseEntity<Category> saveCategory(@RequestBody Category category){
		Category createCategory=categoryService.saveOrUpdateCategory(category);
		return ResponseEntity.status(HttpStatus.CREATED).body(createCategory);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category category){
		Category existingCategory = categoryService.getCategoryById(id);
		if(existingCategory==null)
		{
			return ResponseEntity.notFound().build();
		}
		category.setId(id);
		categoryService.saveOrUpdateCategory(category);
		return ResponseEntity.ok(category);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable int id){
		
		Category category= categoryService.getCategoryById(id);
		if(category==null)
		{
			return ResponseEntity.notFound().build();
		}
		categoryService.deleteCategoryById(id);
		return ResponseEntity.noContent().build();
	}
}

