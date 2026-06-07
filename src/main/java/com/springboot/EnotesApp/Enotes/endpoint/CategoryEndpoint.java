package com.springboot.EnotesApp.Enotes.endpoint;

import static com.springboot.EnotesApp.Enotes.util.Constants.ROLE_ADMIN;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.EnotesApp.Enotes.dto.CategoryDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RequestMapping("/api/v1/category")
public interface CategoryEndpoint {

  @Operation(summary = "Save Category", tags = { "Category" }, description = "Admin Save  category")
  @PostMapping("/save")
  @PreAuthorize(ROLE_ADMIN)
  public ResponseEntity<?> saveCategory(@RequestBody CategoryDto categoryDto);

  @Operation(summary = "Save Category", tags = { "Category" }, description = "Admin Save  category")
  @GetMapping("/category")
  @PreAuthorize(ROLE_ADMIN)
  public ResponseEntity<?> getAllCategory();
}
