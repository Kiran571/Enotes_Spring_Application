package com.springboot.EnotesApp.Enotes.service;

import java.util.List;

import com.springboot.EnotesApp.Enotes.dto.CategoryDto;
import com.springboot.EnotesApp.Enotes.dto.CategoryResponse;
import com.springboot.EnotesApp.Enotes.entity.Category;


public interface CategoryService {

	public Boolean saveCategory(CategoryDto categoryDto);
	
	public List<CategoryDto> getAllCategory();
	
	public List<CategoryResponse> getActiveCategory();

	public CategoryDto getCategoryById(Integer id);
	


}
