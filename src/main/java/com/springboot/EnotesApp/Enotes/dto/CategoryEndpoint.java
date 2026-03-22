package com.springboot.EnotesApp.Enotes.dto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//@Tag(name = "Category Endpoint", description = "All the Category operation API's")
@RequestMapping("/api/v1/category")
public interface CategoryEndpoint {

    public ResponseEntity<?> deleteCategoryById(@PathVariable Integer id);

}
